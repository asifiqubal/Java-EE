package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.BookList;

public class BookListAdapter {
	
	public void insert(BookList bl)
	{
		String sql = "INSERT INTO booklist VALUES (null, '"+bl.getBook_name()+"', '"+bl.getEdition()+"', '"+bl.getAuthor_name()+"', '"+bl.getCategory()+"', "+bl.getAvailable_copy()+", "+bl.getTotal_copy()+" )";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(BookList bl)
	{
		String sql = "UPDATE booklist SET book_name='"+bl.getBook_name()+"', edition='"+bl.getEdition()+"', author_name='"+bl.getAuthor_name()+"', category='"+bl.getCategory()+"', available_copy="+bl.getAvailable_copy()+", total_copy="+bl.getTotal_copy()+" WHERE book_id="+bl.getBook_id();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM booklist WHERE book_id="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<BookList> getAll()
	{
		String sql = "SELECT * FROM booklist";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<BookList> booklist = new ArrayList<BookList>();
		try {
			while(rs.next())
			{
				BookList bl = new BookList();
				bl.setBook_id(rs.getInt("book_id"));
				bl.setBook_name(rs.getString("book_name"));
				bl.setEdition(rs.getString("edition"));
				bl.setAuthor_name(rs.getString("author_name"));
				bl.setCategory(rs.getString("category"));
				bl.setAvailable_copy(rs.getInt("available_copy"));
				bl.setTotal_copy(rs.getInt("total_copy"));
				
				booklist.add(bl);
			}
			return booklist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<BookList> getSearchBook(String search)
	{
		String sql = "SELECT * FROM booklist where (book_name LIKE '%"+search+"%' || author_name LIKE '%"+search+"%' || category LIKE '%"+search+"%')";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<BookList> booklist = new ArrayList<BookList>();
		try {
			while(rs.next())
			{
				BookList bl = new BookList();
				bl.setBook_id(rs.getInt("book_id"));
				bl.setBook_name(rs.getString("book_name"));
				bl.setEdition(rs.getString("edition"));
				bl.setAuthor_name(rs.getString("author_name"));
				bl.setCategory(rs.getString("category"));
				bl.setAvailable_copy(rs.getInt("available_copy"));
				bl.setTotal_copy(rs.getInt("total_copy"));
				
				booklist.add(bl);
			}
			return booklist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BookList get(int id)
	{
		String sql = "SELECT * FROM booklist WHERE book_id="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		BookList bl = new BookList();
		try {
			if(rs.next())
			{
				bl.setBook_id(rs.getInt("book_id"));
				bl.setBook_name(rs.getString("book_name"));
				bl.setEdition(rs.getString("edition"));
				bl.setAuthor_name(rs.getString("author_name"));
				bl.setCategory(rs.getString("category"));
				bl.setAvailable_copy(rs.getInt("available_copy"));
				bl.setTotal_copy(rs.getInt("total_copy"));
				
				return bl;
			}
			else
			{
				return null;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
