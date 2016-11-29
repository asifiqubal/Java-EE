package models;

public class Finance {
	
	private int user_id;
	private String finance_id;
	private String date;
	private int balance;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFinance_id() {
		return finance_id;
	}
	public void setFinance_id(String finance_id) {
		this.finance_id = finance_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

}
