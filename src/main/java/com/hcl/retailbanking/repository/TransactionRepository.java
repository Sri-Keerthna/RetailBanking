package com.hcl.retailbanking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.retailbanking.entity.Transaction;

/**
 * @author Sri Keerthna. This is a TransactionRepository class for Transaction
 *         table.
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	/**
	 * @author Sri Keerthna
	 * From the input we will fetch the Informations 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */

	@Query("SELECT t FROM Transaction t WHERE t.fromAccount=:accountNumber and t.transactionDate between :fromDate and :toDate")
	List<Transaction> getTransactionsBetweenDates(LocalDate fromDate, LocalDate toDate, Long accountNumber);
	 
}
