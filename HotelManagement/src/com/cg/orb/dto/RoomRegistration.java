package com.cg.orb.dto;

public class RoomRegistration {
	//private int roomNo;
	
	@Override
	public String toString() {
		return "RoomRegistration [hotelId=" + hotelId + ", roomType=" + roomType + ", roomArea=" + roomArea
				+ ", rentAmount=" + rentAmount + ", paidAmount=" + paidAmount + "]";
	}
	private int hotelId;
	public RoomRegistration(int hotelId, int roomno, int roomType, int roomArea, int rentAmount, int paidAmount) {
		super();
		this.hotelId = hotelId;
		this.roomno = roomno;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.rentAmount = rentAmount;
		this.paidAmount = paidAmount;
	}
	private int roomno;
	private int roomType;
	 private int roomArea;
	 private int rentAmount;
	 private int paidAmount;
	 
	public  RoomRegistration()
	{
		
	}
	 public RoomRegistration( int hotelId, int roomType, int roomArea, int rentAmount, int paidAmount) {
		super();
		
		this.hotelId = hotelId;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.rentAmount = rentAmount;
		this.paidAmount = paidAmount;
	}
	
	


	public int getHotelId() {
		return hotelId;
	}

	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomType() {
		return roomType;
	}

	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}

	public int getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(int roomArea) {
		this.roomArea = roomArea;
	}

	public int getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	
}
