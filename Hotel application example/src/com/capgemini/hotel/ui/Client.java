package com.capgemini.hotel.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.hotel.HotelManagementException.HotelBookingException;
import com.capgemini.hotel.bean.CustomerBean;
import com.capgemini.hotel.bean.RoomBooking;
import com.capgemini.hotel.service.HotelService;



public class Client 
{

	public static void main(String[] args) 
	{
		CustomerBean cust =new CustomerBean();
		HotelService service=new HotelService();
		RoomBooking room=new RoomBooking();
		room.setStatus("Not_Booked");
		System.out.println("HOTEL BOOKING MANAGEMENT");
		System.out.println("1)Book Room\n2)View Booking Status\n3)Exit");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			do
			{
		    System.out.println("Enter Customer Name :");
			String custName=sc.next();
			boolean res=service.isValidName(custName);
				if(res==true)
				{
					cust.setCustName(custName);
					break;
				}
				else
				{
					System.err.println("Invalid name");
				}
			}while(true);
			
			
			
			do
			{
		    System.out.println("Enter Email :");
			String mail=sc.next();
			boolean res=service.isValidMailId(mail);
				if(res==true)
				{
					cust.setEmail(mail);
					break;
				}
				else
				{
					System.err.println("Invalid Email id");
				}
			}while(true);
			
			
			do
			{
		    System.out.println("Enter Customer Address :");
			String custAddress=sc.next();
			boolean res=service.isValidAddress(custAddress);
				if(res==true)
				{
					cust.setCustAddress(custAddress);
					break;
				}
				else
				{
					System.err.println("Invalid Address");
				}
			}while(true);
			
			
			
			do
			{
		    System.out.println("Enter Mobile No :");
			String mobileNo=sc.next();
			boolean res=service.isValidMobileNo(mobileNo);
				if(res==true)
				{
					cust.setMobileNo(mobileNo);
					break;
				}
				else
				{
					System.err.println("Invalid Mobile Number");
				}
			}while(true);
			
			
			
			do
			{
		    System.out.println("Enter Room No :");
			int roomNo=sc.nextInt();
			System.out.println("Enter Room Type");
			String roomType=sc.next();
			cust.setRoomNo(roomNo);
			cust.setRoomType(roomType);
			boolean res=service.isValidRoomNo(roomNo,roomType);
				if(res==true)
				{
					//cust.setRoomNo(roomNo);
					//cust.setRoomType(roomType);
					room.setStatus("Booked");
					break;
				}
				else
				{
					System.err.println("Invalid Room Number or Room Type");
					cust.setRoomNo(0);
					cust.setRoomType(null);
				}
			}while(true);
					int custId=service.addCustomerDetails(cust);
					System.out.println("Your Room has been successfully booked,your Customer ID is:"+custId);
			
			break;
			
		case 2:System.out.println("Enter Customer ID :");
				int cid=sc.nextInt();
				RoomBooking rm;
				try
				{
					rm=service.getBookingDetails(cid);
					if(rm.equals(null))
					{
						System.out.println("Sorry no records found for customer id"+cid);
					}
					else
					{
						
						System.out.println("Name of the customer: "+rm.getCust().getCustName());
						System.out.println("Booking Status: "+rm.getStatus());
						System.out.println("Room No: "+rm.getCust().getRoomNo());
						System.out.println("Room Type: "+rm.getCust().getRoomType());
					}
					
				}catch(Exception e)
				{
					try {
						throw new HotelBookingException(e.getMessage());
					} catch (HotelBookingException e1) {
		
						e1.printStackTrace();
					}
				}
				
				
				
			
			break;
		case 3:System.exit(0);
			break;
		}
	}
}
	
	


