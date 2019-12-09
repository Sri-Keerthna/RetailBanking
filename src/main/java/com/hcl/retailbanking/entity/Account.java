package com.hcl.retailbanking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

	@Id
	private Long accountNumber;
	private Integer userId;
	private Double balance;
	private String accountType;
	private String ifsC;
}
