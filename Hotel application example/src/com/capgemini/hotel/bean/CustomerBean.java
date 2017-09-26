package com.capgemini.hotel.bean;

public class CustomerBean 
{
	public int custID;
	public String custName;
	public String email;
	public String custAddress;
	public String mobileNo;
	public String roomType;
	public int roomNo;
	
	public CustomerBean()
	{
		
	}
	
	
	public CustomerBean(int custID, String custName, String email,
			String custAddress, String mobileNo, String roomType, int roomNo,
			String status, RoomBooking room) {
		super();
		this.custID = custID;
		this.custName = custName;
		this.email = email;
		this.custAddress = custAddress;
		this.mobileNo = mobileNo;
		this.roomType = roomType;
		this.roomNo = roomNo;
		
		this.room = room;
	}


	
	public void setRoom(RoomBooking room) {
		this.room = room;
	}
	RoomBooking room;
	
	public RoomBooking getRoom() {
		return room;
	}
	public void setR(RoomBooking room) {
		this.room = room;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo2) {
		this.mobileNo = mobileNo2;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	
}
