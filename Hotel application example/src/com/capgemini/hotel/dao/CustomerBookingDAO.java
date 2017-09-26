package com.capgemini.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capgemini.hotel.HotelManagementException.HotelBookingException;
import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.utility.DatabaseConnection;


public class CustomerBookingDAO implements ICustomerBookingDAO
{

	@Override
	public int addCustomerDetails(CustomerBean cust) {
		

		try {
			int custID=0;
			
		Connection con=DatabaseConnection.getConnection();
		String insertQuery="insert into RoomsDetail values(?,?,?)";
		PreparedStatement ps= con.prepareStatement(insertQuery);
		if(cust.getRoomNo()==101)
		{
		ps.setInt(1,cust.getRoomNo());
		ps.setString(2,"AC_SINGLE");
		ps.setString(3,"Booked");
		}
		else if (cust.getRoomNo()==102)
		{
		ps.setInt(1,cust.getRoomNo());
		ps.setString(2,"AC_SINGLE");
		ps.setString(3,"Booked");
		}
		else if (cust.getRoomNo()==103)
		{
		ps.setInt(1,cust.getRoomNo());
		ps.setString(2,"AC_DOUBLE");
		ps.setString(3,"Booked");
		}
		else if (cust.getRoomNo()==201)
		{
		ps.setInt(1,cust.getRoomNo());
		ps.setString(2,"NONAC_SINGLE");
		ps.setString(3,"Booked");
		}
		else if (cust.getRoomNo()==202)
		{
		ps.setInt(1,cust.getRoomNo());
		ps.setString(2,"NONAC_SINGLE");
		ps.setString(3,"Booked");
		}
		else if (cust.getRoomNo()==203)
		{
		ps.setInt(1,cust.getRoomNo());
		ps.setString(2,"NONAC_DOUBLE");
		ps.setString(3,"Booked");
		}
		else
		{
			ps.setInt(1, cust.roomNo);
			ps.setString(2,"null");
			ps.setString(3,"Not Booked");
		}
		
		int row1=ps.executeUpdate();

		String insertQuery1="insert into CustomerDetails values(CustomerID_SEQ.nextVal,?,?,?,?,?,?)";
		PreparedStatement ps1= con.prepareStatement(insertQuery1);
		ps1.setString(1, cust.getCustName());
		ps1.setString(2, cust.getEmail());
		ps1.setString(3,cust.getCustAddress());
		ps1.setString(4,cust.getMobileNo());
		ps1.setString(5,cust.getRoomType());
		ps1.setInt(6, cust.getRoomNo());
		
		
		
			int row=ps1.executeUpdate();
			if(row==1)
			{
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select CustomerID_SEQ.currVal from dual");
				if(rs.next())
				{
					custID=rs.getInt(1);
					
					return custID;
				}
					
			}
			
			
	} catch (SQLException e) {
		
		System.out.println(e.getMessage());
	}
		return 0;
	}

	@Override
	public RoomBooking getBookingDetails(int CustomerId) throws HotelBookingException {
		
		try{
			Connection con=DatabaseConnection.getConnection();
			String selectQuery="select CustomerDetails.CustName,RoomsDetail.Status,CustomerDetails.RoomNo,CustomerDetails.RoomType from CustomerDetails ,RoomsDetail  where CustomerDetails.RoomNo=RoomsDetail.RoomNo AND CustomerDetails.CustID=?";
			
			PreparedStatement ps;
			ps = con.prepareStatement(selectQuery);
			ps.setInt(1, CustomerId);
			
			ResultSet rs=ps.executeQuery();
			RoomBooking room=new RoomBooking();
			
			while(rs.next())
			{
				CustomerBean cust=new CustomerBean();
				//RoomBooking room=new RoomBooking();
				cust.setCustName(rs.getString("CustName"));
				
				cust.setRoomNo(rs.getInt("RoomNo"));
				cust.setRoomType(rs.getString("RoomType"));
				room.setCust(cust);
				room.setStatus(rs.getString("Status"));
				return room;
			}
			

			}
			catch(SQLException e)
			{
				throw new HotelBookingException(e.getMessage());
			}
		return null;
			
	}
	
}
