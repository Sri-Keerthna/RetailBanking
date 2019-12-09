package com.hcl.retailbanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.retailbanking.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	/**
	 * @author Sri Keerthna
	 * By using userId find the account number
	 * @param userId
	 * @return
	 */
	Account findAccountNumberByUserId(Integer userId);

}
