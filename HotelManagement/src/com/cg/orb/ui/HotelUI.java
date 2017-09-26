package com.cg.orb.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


import com.cg.orb.dto.HotelOwner;
import com.cg.orb.dto.RoomRegistration;
import com.cg.orb.exception.HotelApplicationException;
import com.cg.orb.service.HotelServiceImpl;
import com.cg.orb.service.IHotelService;



public class HotelUI {
	static Scanner sc=new Scanner(System.in);
	//static Scanner sc=null;
	static int choice =0;
	static RoomRegistration details=null;
	static IHotelService service=new HotelServiceImpl();
	static HotelOwner owner=null;

public static void main(String[] args) throws HotelApplicationException, IOException, SQLException 
{

	 //Scanner sc=null;
	System.out.println("Hotel Management Application ");
	System.out.println("*****************************");
	while(true)
	{
	System.out.println("1.Booking room");
	System.out.println("2.Get hotel owner details");
	System.out.println("3.Get details by room no");
	System.out.println("4.Exit");
	System.out.println("Enter your choice");
	  choice=sc.nextInt();
	switch(choice)
	{
	case 1:viewRegisterRoom();
		break;
	case 2:getRoomRegistrationDetails();
	break;
	case 3:getByRoomNoDetails();
	break;
	
	case 4:
		System.exit(0);
		break;
	}

	}
	
}


private static void viewRegisterRoom() throws HotelApplicationException, IOException, SQLException 
{
	ArrayList<Integer> hotel_Id=new 	ArrayList<Integer>();
	hotel_Id=service.getAllOwnerId();
	System.out.println("Existing HotelOwner IDS Are:"+hotel_Id);
	service=new HotelServiceImpl();
	
	
	int hotelId=sc.nextInt();
	if(service.validateHotelId(hotelId))
	{
	//if(!validateHotelId(r.getHotelId()))
	//{
	System.out.println("Select  room type Type (1-1AC, 2-2NON-AC):");
	int roomtype=sc.nextInt();
	if(service.validateRoomType(roomtype))
	{
	//if(!validateRoomType(r.getRoomType()))
	//{

	
	System.out.println("Enter room area");
	int roomarea=sc.nextInt();
	if(service.validateRoomArea(roomarea))
	{
	System.out.println("Enter rent amount");
	int rentamount=sc.nextInt();
	//if(!validateRoomType(r.getRentAmount()))
	//{

	System.out.println("Enter paid amount");
	int paidamount=sc.nextInt();
	//if(!validateRoomType(r.getPaidAmount()))
	//{

	if(service.validatePaidAmount(paidamount,rentamount))
	{
	
	details=new RoomRegistration(hotelId,roomtype,roomarea,rentamount,paidamount);
	
	
	
	int res=service.viewRegisterRoom(details);
	System.out.println("Room successfully registered.Room No:"+res);
	}
	

	
}}}}


private static void getRoomRegistrationDetails() {
	ArrayList<RoomRegistration> list=null;
	list=service.retrieveDetails();
	System.out.println("Room no\t Hotel id \t Room type \t Room area \t Rent amount \t Paid amount");
	for(RoomRegistration m:list)
	{
	/*	System.out.println(m.getHotelId());
		System.out.println(m.getName());
		System.out.println(m.getMobile());
		
	*/
	System.out.println(m);	
	}
}


private static void getByRoomNoDetails() throws IOException, SQLException {
	// TODO Auto-generated method stub
	
	IHotelService is = new HotelServiceImpl();
	// TODO Auto-generated method stub
	RoomRegistration ed = new RoomRegistration();
	
	System.out.println("Enter Id of room");
	int roomno = sc.nextInt();
	ed = is.getByRoomNoDetails(roomno);
	/*if(ed.getHotelId() == null)
	{
	System.out.println("Details Not Found");
	}
else
{
System.out.println("\nRoom no\t Hotel id\t Room type \t Room area \t Rent amount \t paid amount");*/
System.out.println(ed);
}
}

	












