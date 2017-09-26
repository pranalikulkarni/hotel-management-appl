package com.cg.orb.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.orb.dto.HotelOwner;
import com.cg.orb.dto.RoomRegistration;
import com.cg.orb.exception.HotelApplicationException;

public interface IHotelService {

	public int viewRegisterRoom(RoomRegistration r) throws HotelApplicationException;

	public ArrayList<Integer> getAllOwnerId() throws IOException, SQLException;

	public boolean validateHotelId(int hotelId);

	public boolean validatePaidAmount(int paidamount, int rentamount);

	public boolean validateRoomType(int roomtype);

	public ArrayList<RoomRegistration> retrieveDetails();

	public RoomRegistration getByRoomNoDetails(int e_id) throws IOException, SQLException;

	public boolean validateRoomArea(int roomarea);

	

	
	

}
