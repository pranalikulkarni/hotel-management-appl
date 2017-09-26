package com.cg.orb.dto;

public class HotelOwner {
	
	private int hotelId ;
	private String name ;
	private String mobile ;
	
	
	public HotelOwner()
	{
		
	}

	public HotelOwner(int hotelId, String name, String mobile) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.mobile = mobile;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
		
	}


}

