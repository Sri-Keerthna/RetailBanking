package com.hcl.retailbanking.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.retailbanking.dto.TransactionDto;
import com.hcl.retailbanking.entity.Account;
import com.hcl.retailbanking.entity.Transaction;
import com.hcl.retailbanking.repository.AccountRepository;
import com.hcl.retailbanking.repository.TransactionRepository;
import com.hcl.retailbanking.util.Utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sri Keerthna This is a TransactionService Implementation class for
 *         Transaction table.
 */
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	/**
	 * TransactionRepository methods are autowired with this TransactionServiceImpl.
	 */
	@Autowired
	TransactionRepository transactionRepository;

	/**
	 * AccountRepository methods are autowired with this TransactionServiceImpl.
	 */
	@Autowired
	AccountRepository accountRepository;

	/**
	 * @author Sri Keerthna.
	 * In this method inputs are taken from user and using their
	 * account number monthly transactions will be displayed.
	 * If there is no transactions available on that month then it will return message as "no transactions available".
	 */
	@Override
	public List<Transaction> viewTransactions(String month, Integer year, Integer userId) {
		logger.info("Entering into transaction method with inputs");
//		String month = transactionDto.getMonth();
//		Integer year = transactionDto.getYear();
		Account account = accountRepository.findAccountNumberByUserId(userId);
		Long accountNumber = account.getAccountNumber();
		if (accountNumber != null) {
			List<LocalDate> dates = Utils.getDateFromMonthAndYear(month, year);
			if (!dates.isEmpty()) {
				LocalDate fromDate = dates.get(0);
				LocalDate toDate = dates.get(1);
				return transactionRepository.getTransactionsBetweenDates(fromDate, toDate, accountNumber);
			} else {
				return Collections.emptyList();
			}
		} else {
			return Collections.emptyList();
		}
	}

}
