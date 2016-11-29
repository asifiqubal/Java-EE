package adapters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.BorrowBookList;
import models.BorrowList;

public class BorrowListAdapter {
	
	public void insert(BorrowList bl)
	{
		String sql = "INSERT INTO borrowlist VALUES (null, "+bl.getBook_id()+", '"+bl.getUser_id()+"', '"+bl.getBorrow_date()+"', '"+bl.getExpected_return_date()+"',null,null, '"+bl.getStatus()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void delete(int id)
	{
		String sql = "DELETE FROM borrowlist WHERE borrow_id='"+id+"' ";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void updateStatus(int id, String status)
	{
		String sql = "UPDATE borrowlist SET status='"+status+"' WHERE borrow_id='"+id+"' ";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(BorrowBookList bl)
	{
		String sql = "UPDATE borrowlist SET return_date='"+bl.getReturn_date()+"' ,fine='"+bl.getFine()+"' ,status='"+bl.getStatus()+"' WHERE borrow_id="+bl.getBorrow_id();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void updateAvailable(int id,int copy)
	{
		String sql = "UPDATE booklist SET available_copy='"+copy+"' WHERE book_id='"+id+"' ";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<BorrowBookList> getBorrowHistory(int id, String status)
	{
		String sql = "SELECT booklist.*, borrowlist.* FROM borrowlist INNER JOIN booklist ON booklist.book_id=borrowlist.book_id WHERE borrowlist.user_id='"+id+"' && borrowlist.status='"+status+"' ";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<BorrowBookList> list = new ArrayList<BorrowBookList>();
		try {
			while(rs.next())
			{
				BorrowBookList bl = new BorrowBookList();
				bl.setBorrow_id(rs.getInt("borrow_id"));
				bl.setBook_id(rs.getInt("book_id"));
				bl.setUser_id(rs.getInt("user_id"));
				bl.setBorrow_date(rs.getString("borrow_date"));
				bl.setExpected_return_date(rs.getString("expected_return_date"));
				bl.setReturn_date(rs.getString("return_date"));
				bl.setFine(rs.getInt("fine"));
				bl.setStatus(rs.getString("status"));
				bl.setBook_name(rs.getString("book_name"));
				bl.setEdition(rs.getString("edition"));
				
				list.add(bl);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BorrowBookList getInfo(int id)
	{
		String sql = "SELECT booklist.*, borrowlist.* FROM borrowlist INNER JOIN booklist ON booklist.book_id=borrowlist.book_id WHERE borrowlist.borrow_id='"+id+"' ";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		BorrowBookList list = new BorrowBookList();
		try {
			if(rs.next())
			{
				list.setBook_id(rs.getInt("book_id"));
				list.setUser_id(rs.getInt("user_id"));
				list.setBorrow_date(rs.getString("borrow_date"));
				list.setExpected_return_date(rs.getString("expected_return_date"));
				list.setBook_name(rs.getString("book_name"));
				list.setEdition(rs.getString("edition"));
				list.setAuthor_name(rs.getString("author_name"));
				list.setCategory(rs.getString("category"));
				list.setBorrow_id(rs.getInt("borrow_id"));
				list.setAvailable_copy(rs.getInt("available_copy"));
				return list;
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
	
	public ArrayList<BorrowBookList> getAllBorrowHistory(String status)
	{
		String sql = "SELECT booklist.*, borrowlist.* FROM borrowlist INNER JOIN booklist ON booklist.book_id=borrowlist.book_id WHERE borrowlist.status='"+status+"' ";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<BorrowBookList> list = new ArrayList<BorrowBookList>();
		try {
			while(rs.next())
			{
				BorrowBookList bl = new BorrowBookList();
				bl.setBorrow_id(rs.getInt("borrow_id"));
				bl.setBook_id(rs.getInt("book_id"));
				bl.setUser_id(rs.getInt("user_id"));
				bl.setBorrow_date(rs.getString("borrow_date"));
				bl.setExpected_return_date(rs.getString("expected_return_date"));
				bl.setReturn_date(rs.getString("return_date"));
				bl.setFine(rs.getInt("fine"));
				bl.setStatus(rs.getString("status"));
				bl.setBook_name(rs.getString("book_name"));
				bl.setEdition(rs.getString("edition"));
				
				list.add(bl);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int countRequest(int id, String status)
	{
		String sql = "SELECT COUNT(*) FROM borrowlist WHERE user_id='"+id+"' && status='"+status+"' ";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		int c=0;
		try {
			while (rs.next()) 
			{
			     c = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public Boolean checking(int uid, int bid)
	{
		String sql = "SELECT * FROM borrowlist WHERE user_id='"+uid+"' && book_id='"+bid+"' && (status='requested' OR status='borrowed') ";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		Boolean b= false;
		try {
			if(rs.next())
			{
				b = true;
			}
			
			else
				b = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
}
