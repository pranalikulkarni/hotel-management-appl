package com.capgemini.hotel.service;

import com.capgemini.hotel.HotelManagementException.HotelBookingException;
import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;

public interface IHotelService 
{
	int addCustomerDetails(CustomerBean cust);
	RoomBooking getBookingDetails(int CustomerId) throws HotelBookingException, Exception;
	public boolean isValidName(String name);
	public boolean isValidMobileNo(String name);
	public boolean isValidMailId(String name);
	public boolean isValidRoomNo(int name,String type);
	public boolean isValidAddress(String name);
	
}
