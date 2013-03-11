package com.astroreading.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.astroreading.enums.TransactionTypes;

public class Transaction {

	private String transactionId;
	private TransactionTypes transactionType;
	private Timestamp transactionDate;
	private BigDecimal amount;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public TransactionTypes getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionTypes transactionType) {
		this.transactionType = transactionType;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	
}
