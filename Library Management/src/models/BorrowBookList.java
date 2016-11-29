package models;

public class BorrowBookList {
	
	private int borrow_id;
	private int book_id;
	private int user_id;
	private String borrow_date;
	private String expected_return_date;
	private String return_date;
	private int fine;
	private String status;
	private String book_name;
	private String edition;
	private String author_name;
	private String category;
	private int available_copy;
	private int total_copy;
	
	public int getBorrow_id() {
		return borrow_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public String getBorrow_date() {
		return borrow_date;
	}
	public String getExpected_return_date() {
		return expected_return_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public int getFine() {
		return fine;
	}
	public String getStatus() {
		return status;
	}
	public String getBook_name() {
		return book_name;
	}
	public String getEdition() {
		return edition;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public String getCategory() {
		return category;
	}
	public int getAvailable_copy() {
		return available_copy;
	}
	public int getTotal_copy() {
		return total_copy;
	}
	public void setBorrow_id(int borrow_id) {
		this.borrow_id = borrow_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}
	public void setExpected_return_date(String expected_return_date) {
		this.expected_return_date = expected_return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setAvailable_copy(int available_copy) {
		this.available_copy = available_copy;
	}
	public void setTotal_copy(int total_copy) {
		this.total_copy = total_copy;
	}

}
