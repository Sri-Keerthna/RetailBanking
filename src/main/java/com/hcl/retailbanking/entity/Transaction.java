package com.hcl.retailbanking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sri Keerthna. This is a Transaction class for Transaction table. It
 *         has 7 parameters
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

	/*
	 * @param The transaction id of the transaction
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;

	/*
	 * @param The Account number from which amount will be debit.
	 */
	private Long fromAccount;

	/*
	 * @param The benefactor name
	 */
	private String benefactorName;

	/*
	 * @param The Account number to which amount will be credit.
	 */
	private Long toAccount;

	/*
	 * @param The amount to transfer
	 */
	private Double amount;

	/*
	 * @param The status of the transaction
	 */
	private String transactionType;

	/*
	 * @param The transaction date
	 */
	private LocalDate transactionDate;

}
