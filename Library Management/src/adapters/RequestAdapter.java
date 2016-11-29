package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.Request;

public class RequestAdapter {
	
	public void insert(Request req)
	{
		String sql = "INSERT INTO request VALUES (null, "+req.getUser_id()+", '"+req.getBook_name()+"', '"+req.getEdition()+"', '"+req.getAuthor_name()+"', '"+req.getRequest_date()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<Request> getAll()
	{
		String sql = "SELECT * FROM request";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<Request> reqlist = new ArrayList<Request>();
		try {
			while(rs.next())
			{
				Request req = new Request();
				req.setRequest_id(rs.getInt("request_id"));
				req.setUser_id(rs.getInt("user_id"));
				req.setBook_name(rs.getString("book_name"));
				req.setEdition(rs.getString("edition"));
				req.setAuthor_name(rs.getString("author_name"));
				req.setRequest_date(rs.getString("request_date"));
				
				reqlist.add(req);
			}
			return reqlist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
		
		public  ArrayList<Request> get(int id)
		{
			String sql = "SELECT * FROM request WHERE user_id="+id;
			DataAccess da = new DataAccess();
			ResultSet rs = da.getResultSet(sql);
			ArrayList<Request> reqlist = new ArrayList<Request>();
			try {
				while(rs.next())
				{
					Request rl = new Request();
					rl.setUser_id(rs.getInt("user_id"));
					rl.setBook_name(rs.getString("book_name"));
					rl.setEdition(rs.getString("edition"));
					rl.setAuthor_name(rs.getString("author_name"));
					rl.setRequest_date(rs.getString("request_date"));
					
					reqlist.add(rl);
				}
				
				return reqlist;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}
}
