package com.capgemini.hotel.bean;

public class RoomBooking 
{
	public String custName;
	public String roomType;
	public String status;
	public CustomerBean cust;
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CustomerBean getCust() {
		return cust;
	}
	public void setCust(CustomerBean cust) {
		this.cust = cust;
	}
	public RoomBooking(String custName, String roomType, String status,
			CustomerBean cust) {
		super();
		this.custName = custName;
		this.roomType = roomType;
		this.status = status;
		this.cust = cust;
	}
	public RoomBooking() {
		
		
	}
	
	
	


}
