package models;

public class BookList {
	private int book_id;
	private String book_name;
	private String edition;
	private String author_name;
	private String category;
	private int available_copy;
	private int total_copy;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getAvailable_copy() {
		return available_copy;
	}
	public void setAvailable_copy(int available_copy) {
		this.available_copy = available_copy;
	}
	public int getTotal_copy() {
		return total_copy;
	}
	public void setTotal_copy(int total_copy) {
		this.total_copy = total_copy;
	}
	
}
