package com.hcl.retailbanking.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.hcl.retailbanking.controller.TransactionController;
import com.hcl.retailbanking.dto.ApiResponseDto;
import com.hcl.retailbanking.dto.TransactionDto;
import com.hcl.retailbanking.entity.Account;
import com.hcl.retailbanking.entity.Transaction;
import com.hcl.retailbanking.service.TransactionService;
import com.hcl.retailbanking.service.TransactionServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {

	@InjectMocks
	TransactionController transactionController;

	@Mock
	TransactionService transactionService;

	static TransactionDto transactionDto = new TransactionDto();
	static List<Transaction> lstTransaction = new ArrayList<>();
	static ApiResponseDto apiResponseDto = new ApiResponseDto();
	/**
	 * @author Sri Keerthna
	 * Values are initialized for transactionDto, transaction and Accounts
	 */
	@Before
	public void setup() {
		transactionDto.setMonth("September");
		transactionDto.setYear(2019);
		transactionDto.setUserId(1);

		List<Account> accounts = new ArrayList<>();
		Account account = new Account();
		account.setAccountNumber(1234L);
		account.setAccountType("Savings");
		account.setIfsC("SBI0010");
		account.setUserId(1);
		accounts.add(account);

		Transaction transaction = new Transaction();
		transaction.setAmount(200D);
		transaction.setBenefactorName("sri");
		transaction.setFromAccount(1234L);
		transaction.setToAccount(9876L);
		transaction.setTransactionDate(LocalDate.of(2019, 9, 2));
		transaction.setTransactionId(1);
		transaction.setTransactionType("Debited");
		lstTransaction.add(transaction);
	}

	
	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	/**
	 * @author Sri Keerthna
	 * Positive test case. If the transactions are available for a particular
	 * account number then it will return the transactions
	 */
	@Test
	public void viewTransactionsPositiveTest() {
		Mockito.when(transactionService.viewTransactions(transactionDto)).thenReturn(lstTransaction);
		HttpStatus statuscode = transactionController.viewTransaction(transactionDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);
		

	}

	/**
	 * @author Sri Keerthna
	 * Negative test case. If any value is null then it will return null value
	 */
	@Test
	public void viewTransactionsNegativeTest() {
		TransactionDto transactionDto = new TransactionDto();
		transactionDto.setMonth(null);

		Mockito.when(transactionService.viewTransactions(transactionDto)).thenReturn(null);
		logger.debug("Data entered has a null value");
		HttpStatus statuscode = transactionController.viewTransaction(transactionDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);

	}

	/**
	 * @author Sri Keerthna
	 * Negative test case. If any value is null then it will return null value
	 */
	@Test
	public void viewTransactionsNegativeTestNull() {
		transactionDto.setYear(null);

		Mockito.when(transactionService.viewTransactions(transactionDto)).thenReturn(null);
		logger.debug("Data entered has a null value");
		HttpStatus statuscode = transactionController.viewTransaction(transactionDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);

	}

	/**
	 * @author Sri Keerthna
	 * Negative test case. If any value is null then it will return null value
	 */
	@Test
	public void viewTransactionsNegativeTestNullValue() {
		transactionDto.setUserId(null);

		Mockito.when(transactionService.viewTransactions(transactionDto)).thenReturn(null);
		logger.debug("Data entered has a null value");
		HttpStatus statuscode = transactionController.viewTransaction(transactionDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);

	}

	/**
	 * @author Sri Keerthna
	 * Negative test case. If all values are null then it will return null value
	 */
	@Test
	public void viewTransactionsNegativeTestNullValues() {
		transactionDto.setMonth(null);
		transactionDto.setYear(null);
		transactionDto.setUserId(null);

		Mockito.when(transactionService.viewTransactions(transactionDto)).thenReturn(null);
		logger.debug("Data entered has a null value");
		HttpStatus statuscode = transactionController.viewTransaction(transactionDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);

	}

	/**
	 * @author Sri Keerthna
	 * Negative test case. If transactions are not available then it will return an empty list
	 */
	@Test
	public void viewTransactionsNegativeTestEmpty() {
		Mockito.when(transactionService.viewTransactions(transactionDto)).thenReturn(lstTransaction);
		logger.debug("Result has a empty set");
		HttpStatus statuscode = transactionController.viewTransaction(transactionDto).getStatusCode();
		assertEquals(HttpStatus.OK, statuscode);
	}

}
