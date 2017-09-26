package com.cg.frs.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.cg.orb.dbutil.DBUtil;
import com.cg.orb.dto.HotelOwner;
import com.cg.orb.dto.RoomRegistration;
import com.cg.orb.exception.HotelApplicationException;



public class HotelDaoImpl implements IHotelDAO
{
	Connection conn=null;

	Logger logger=Logger.getRootLogger();
	public HotelDaoImpl()
	{
		
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Override
	public int viewRegisterRoom(RoomRegistration r) throws HotelApplicationException 
	{
		// TODO Auto-generated method stub
	
		int room_no=0;
			try
			{
		conn=DBUtil.getConnection();
		String insertQuery="Insert into Room_Registration values(room_SEQ.nextval,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertQuery);
		ps.setInt(1,r.getHotelId());
		ps.setInt(2,r.getRoomType());
		ps.setInt(3,r.getRoomArea());
		
		ps.setInt(4,r.getRentAmount());
		
		ps.setInt(5,r.getPaidAmount());
		
		
					ps.executeUpdate();
					
					String sql="select room_SEQ.currval from dual";
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					
							while(rs.next()){
								room_no=rs.getInt(1);
							}
							logger.info("Executed Successfully");
							
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
				logger.error("Exception occured"+e.getMessage());
			
			}
			catch(SQLException e)
			{
				throw new HotelApplicationException(e.getMessage());
				//e.printStackTrace();
			}
			return room_no;
			
		
		
	}

	
	
	
	@Override
	public ArrayList<RoomRegistration> retrieveDetails() {
		// TODO Auto-generated method stub
		
		ArrayList<RoomRegistration> list=new ArrayList<RoomRegistration>();
		
		try
		{
		// TODO Auto-generated method stub
		conn=DBUtil.getConnection();
		String sql="Select *  from Room_Registration";
	
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		RoomRegistration r=null;
		while(rs.next())
		{
			int roomno=rs.getInt(1);
			int hid=rs.getInt(2);
			int roomtype=rs.getInt(3);
			int roomarea=rs.getInt(4);
			int rentamount=rs.getInt(5);
			int paidamount=rs.getInt(6);
			list.add(new RoomRegistration(roomno, hid,roomtype,roomarea, rentamount,paidamount));
		}
		}
	catch (SQLException|IOException e)
		{
		System.out.println(e.getMessage());
		}
		
		return list;
	}

	@Override
	public RoomRegistration getByRoomNoDetails(int roomno) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con = DBUtil.getConnection();
		
		String str = "Select * From Room_Registration where Room_NO = ?";
		PreparedStatement pst = con.prepareStatement(str);
		pst.setInt(1, roomno);
		ResultSet rs = pst.executeQuery();
		RoomRegistration ed = new RoomRegistration();
		
		while(rs.next())
		{
			ed.setRoomno(rs.getInt(1));
			ed.setHotelId(rs.getInt(2));
			ed.setRoomType(rs.getInt(3));
			ed.setRoomArea(rs.getInt(4));
			ed.setRentAmount(rs.getInt(5));
			ed.setPaidAmount(rs.getInt(6));
		}
		
		return ed;
		
		
		
		
	}
		
}