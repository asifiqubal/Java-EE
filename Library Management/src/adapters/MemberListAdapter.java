package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

import models.MemberList;;

public class MemberListAdapter {
	
	public void insert(MemberList mem)
	{
		String sql = "INSERT INTO memberlist VALUES ("+mem.getUser_id()+", '"+mem.getMember_name()+"', '"+mem.getAddress()+"', '"+mem.getPhone()+"','"+mem.getEmail()+"','"+mem.getDob()+"','"+mem.getStatus()+"')";
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public void update(MemberList mem)
	{
		String sql = "UPDATE memberlist SET member_name='"+mem.getMember_name()+"', address='"+mem.getAddress()+"', email='"+mem.getEmail()+"', phone='"+mem.getPhone()+"', dob='"+mem.getDob()+"', status='"+mem.getStatus()+"' WHERE user_id="+mem.getUser_id();
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	public void delete(int id)
	{
		String sql = "DELETE FROM memberlist WHERE user_id="+id;
		DataAccess da = new DataAccess();
		da.executeQuery(sql);
	}
	
	public ArrayList<MemberList> getAll()
	{
		String sql = "SELECT * FROM memberlist";
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		ArrayList<MemberList> memlist = new ArrayList<MemberList>();
		try {
			while(rs.next())
			{
				MemberList mem = new MemberList();
				mem.setUser_id(rs.getInt("user_id"));
				mem.setMember_name(rs.getString("member_name"));
				mem.setAddress(rs.getString("address"));
				mem.setPhone(rs.getString("phone"));
				mem.setDob(rs.getString("dob"));
				mem.setEmail(rs.getString("email"));
				mem.setStatus(rs.getString("status"));
				
				memlist.add(mem);
			}
			return memlist;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public MemberList get(int id)
	{
		String sql = "SELECT * FROM memberlist WHERE user_id="+id;
		DataAccess da = new DataAccess();
		ResultSet rs = da.getResultSet(sql);
		MemberList mem = new MemberList();
		try {
			if(rs.next())
			{
				mem.setUser_id(rs.getInt("user_id"));
				mem.setMember_name(rs.getString("member_name"));
				mem.setAddress(rs.getString("address"));
				mem.setPhone(rs.getString("phone"));
				mem.setDob(rs.getString("dob"));
				mem.setEmail(rs.getString("email"));
				mem.setStatus(rs.getString("status"));
				
				return mem;
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
