package com.astroreading.enums;

public enum TransactionTypes {
	CreditCard(1) , Check(2) , Paypal(3) ,DebitCard(4);
	int type;
	TransactionTypes(int type){
		this.type = type;
	}
}
