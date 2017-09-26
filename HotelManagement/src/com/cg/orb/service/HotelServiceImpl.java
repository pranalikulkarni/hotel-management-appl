package com.cg.orb.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.frs.dao.HotelDaoImpl;
import com.cg.frs.dao.IHotelDAO;

import com.cg.orb.dbutil.DBUtil;
import com.cg.orb.dto.HotelOwner;
import com.cg.orb.dto.RoomRegistration;
import com.cg.orb.exception.HotelApplicationException;

public class HotelServiceImpl implements IHotelService  {


	IHotelDAO dao= new HotelDaoImpl();
@Override
public int viewRegisterRoom(RoomRegistration r) throws HotelApplicationException {
	
	
	// TODO Auto-generated method stub
	return dao.viewRegisterRoom(r);
}
@Override
public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException {
	// TODO Auto-generated method stub
	ArrayList<Integer> hotel_Id=new 	ArrayList<Integer>();
	 Connection conn=DBUtil.getConnection();
	 Statement st=conn.createStatement();
	 ResultSet rs=st.executeQuery("select hotel_Id from hotel_owners");
	 while(rs.next())
	 {
		 hotel_Id.add(rs.getInt(1));
	 }
	return hotel_Id;
}
/*
public boolean isvalidatedetails(RoomRegistration r) {
	List<String> validationErrors=new ArrayList<String>();
	boolean set=true;
	//return set;


if(!validateHotelId(r.getHotelId()))
{
	validationErrors.add("\n hotel id should be only 1,2,3");
}

if(!validateRoomType(r.getRoomType()))
{
	validationErrors.add("\n room type  should be only AC OR NONAC");
}

if(!validateRoomArea(r.getRoomArea()))
{
	validationErrors.add("\n room area  should be specific");
}

if(!validateRentAmo(r.getRentAmount()))
{
	validationErrors.add("\n rent amount should be les than paid amount");
}
if(!validateRoomType(r.getPaidAmount()))
{
	validationErrors.add("\n paid amount should be greater than paid amount");
}
if(!validationErrors.isEmpty())
{
	set=false;
}
return set;
}
*/
@Override

public boolean validateHotelId(int hotelId) {
	if(hotelId==1||hotelId==2||hotelId==3)
	{
		return true;
	}
	else
	{
		System.out.println("hotel owner  id does not exists");
		return false;
	}
	
}
@Override
public boolean validatePaidAmount(int paidamount, int rentamount) {
	if(paidamount >rentamount)
	{
		return true;
	}
	else
	{
		System.out.println("Paid Amount should be greater than rent amount");
		return false;
	}
	
}
@Override
public boolean validateRoomType(int roomtype) {
	if(roomtype==1||roomtype==2)
	{
		return true;
	}
	else
	{
		System.out.println("Room type should be AC or Non-AC");
		return false;
	}
	
}
@Override
public ArrayList<RoomRegistration> retrieveDetails() {
	// TODO Auto-generated method stub
	IHotelDAO dao=new HotelDaoImpl();
	//System.out.println("hiii");
	return dao.retrieveDetails();
	
}
@Override
public RoomRegistration getByRoomNoDetails(int roomno) throws IOException, SQLException {
	// TODO Auto-generated method stub
	
	
	RoomRegistration ed = new RoomRegistration();
	IHotelDAO ied= new HotelDaoImpl();
	 ed = ied.getByRoomNoDetails(roomno);
	
	return ed;
	
}
@Override
public boolean validateRoomArea(int roomarea) {
	// TODO Auto-generated method stub
	if(roomarea>0)
	{
		return true;
	}
	return false;
}

	

}
