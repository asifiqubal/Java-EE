package models;

public class BorrowList {
	private int borrow_id;
	private int book_id;
	private int user_id;
	private String borrow_date;
	private String expected_return_date;
	private String return_date;
	private int fine;
	private String status;
	
	public int getBorrow_id() {
		return borrow_id;
	}
	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExpected_return_date() {
		return expected_return_date;
	}
	public int getFine() {
		return fine;
	}
	public void setExpected_return_date(String expected_return_date) {
		this.expected_return_date = expected_return_date;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
}
