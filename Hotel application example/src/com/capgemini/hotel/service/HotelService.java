package com.capgemini.hotel.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.hotel.HotelManagementException.HotelBookingException;
import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.dao.CustomerBookingDAO;
import com.capgemini.hotel.dao.ICustomerBookingDAO;


public class HotelService implements IHotelService
{
	ICustomerBookingDAO dao;
	public HotelService()
	{
		dao = new CustomerBookingDAO();
	}
	@Override
	public int addCustomerDetails(CustomerBean cust) {
		
		return dao.addCustomerDetails(cust);
	}

	@Override
	public RoomBooking getBookingDetails(int CustomerId) throws Exception {
		
		return dao.getBookingDetails(CustomerId);
	}

	@Override
	public boolean isValidName(String name) {
		
		String pattern="[A-Z][a-z]{4,20}";
		boolean res=Pattern.matches(pattern, name);
		return res;
	}

	@Override
	public boolean isValidMobileNo(String mobileNo) {
		String pattern="[0-9]{10}";
		boolean res=Pattern.matches(pattern, mobileNo);
		return res;
	}

	@Override
	public boolean isValidMailId(String name) {
		Pattern pattern=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
Matcher matcher=pattern.matcher(name);
if(matcher.find())
return true;
else
return false;

	}

	@Override
	public boolean isValidRoomNo(int roomNo,String type) {
		
		if(roomNo==101 && type.equalsIgnoreCase("AC_SINGLE"))
			return true;
		else if(roomNo==102 && type.equalsIgnoreCase("AC_SINGLE"))
			return true;
		else if(roomNo==103 && type.equalsIgnoreCase("AC_DOUBLE"))
			return true;
		else if(roomNo==201 && type.equalsIgnoreCase("NONAC_SINGLE"))
			return true;
		else if(roomNo==202 && type.equalsIgnoreCase("NONAC_SINGLE"))
			return true;
		else if(roomNo==203 && type.equalsIgnoreCase("NONAC_DOUBLE"))
			return true;
		else
			return false;
		
	}
	@Override
	public boolean isValidAddress(String name) {
		

		String pattern="[A-Z][a-z]{4,20}";
		boolean res=Pattern.matches(pattern, name);
		return res;
	}

}
