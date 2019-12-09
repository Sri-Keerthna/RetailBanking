package com.hcl.retailbanking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.retailbanking.dto.ApiResponseDto;
import com.hcl.retailbanking.entity.Transaction;
import com.hcl.retailbanking.service.TransactionService;
import com.hcl.retailbanking.service.TransactionServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Sri Keerthna. This is a TransactionController class for Transaction
 *         table.
 */
@RestController
@RequestMapping(name = "/transactions")
@Slf4j
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class TransactionController {

	/**
	 * @author Sri Keerthna. TransactionService is autowired in this controller
	 *         class
	 */
	@Autowired
	TransactionService transactionService;

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	/**
	 * @author Sri Keerthna. Transactions can be viewed for a particular user on
	 *         monthly basis.
	 * @param transactionDto
	 * @return
	 */
	@GetMapping("/monthTransaction/{userId}")
	public ResponseEntity<ApiResponseDto> viewTransaction(@PathVariable("userId") Integer userId,
			@RequestParam String month, Integer year) {
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		if (userId != null || month != null || year != null) {
			List<Transaction> transactions = transactionService.viewTransactions(month, year, userId);
			if (transactions.isEmpty()) {
				logger.debug("Result has a empty set");
				apiResponseDto.setMessage("No transactions available");
				return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
			} else {
				apiResponseDto.setMessage("Monthly transactions");
				apiResponseDto.setTransactions(transactions);
				return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
			}
		} else {
			logger.debug("Data entered has a null value");
			apiResponseDto.setMessage("Invalid input data");
			return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
		}
	}

}
