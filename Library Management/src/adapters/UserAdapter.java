package adapters;

import java.sql.ResultSet;

import models.User;

public class UserAdapter {
	
	public void insert(User user)
	{
		String sql = "INSERT INTO user VALUES (null, '"+user.getUser_name()+"', '"+user.getPassword()+"', '"+user.getType()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(User user)
	{
		String sql = "UPDATE user SET user_name='"+user.getUser_name()+"', password='"+user.getPassword()+"' WHERE user_id="+user.getUser_id();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM user WHERE id="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public User get(String user_name, String password)
	{
		String sql = "SELECT * FROM user WHERE user_name='"+user_name+"' and password='"+password+"' ";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		User user = new User();
		try {
			if(rs.next())
			{
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
				
				return user;
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
