package com.capgemini.hotel.dao;

import com.capgemini.hotel.HotelManagementException.HotelBookingException;
import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;

public interface ICustomerBookingDAO 
{
	int addCustomerDetails(CustomerBean cust);
	RoomBooking getBookingDetails(int CustomerId) throws HotelBookingException;
}
