package com.aliencoded.java.core.training.sockets.serialization.domain;

public class Account {

	private int accountId;
	private String accountName;
	
	
	public Account(int accountId, String accountName) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
	}
	

	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + "]";
	}
	

	
}
