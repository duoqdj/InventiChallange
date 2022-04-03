package com.inventi.updownloadcsv.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class Customer {

	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "beneficiary")
	private String beneficiary;
	
	@Column(name = "operation_date_time")
	private String operationDateTime;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "amount")
	private Integer amount;
	
	@Column(name = "currency")
	private String currency;

	public Customer(String accountNumber, String operationDateTime, String beneficiary, String comment, Integer amount,
			String currency) {
		this.accountNumber = accountNumber;
		this.operationDateTime = operationDateTime;
		this.beneficiary=beneficiary;
		this.comment = comment;
		this.amount = amount;
		this.currency = currency;
	}

	public Customer() {
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOperationDateTime() {
		return operationDateTime;
	}

	public void setOperationDateTime(String operationDateTime) {
		this.operationDateTime = operationDateTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", beneficiary=" + beneficiary + ", operationDateTime="
				+ operationDateTime + ", comment=" + comment + ", amount=" + amount + ", currency=" + currency + "]";
	}


	
	
	
	
	

}