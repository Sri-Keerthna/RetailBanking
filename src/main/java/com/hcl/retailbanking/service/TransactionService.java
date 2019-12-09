package com.hcl.retailbanking.service;

import java.text.ParseException;
import java.util.List;

import com.hcl.retailbanking.dto.TransactionDto;
import com.hcl.retailbanking.entity.Transaction;

/**
 * @author Sri Keerthna. This is a TransactionService interface for Transaction table. It
 *         has 3 methods
 */

public interface TransactionService {

	/**
	 * From TransactionDto input is taken as month and year from user and transactions are fetched
	 * @param transactionDto
	 * @return list of transactions that are taken place in a month
	 * @throws ParseException 
	 */
//	public List<Transaction> viewTransactions(TransactionDto transactionDto);

	public List<Transaction> viewTransactions(String month, Integer year, Integer userId);
}
