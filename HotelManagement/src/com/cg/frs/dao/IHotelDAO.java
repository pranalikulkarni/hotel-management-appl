package com.cg.frs.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.orb.dto.HotelOwner;
import com.cg.orb.dto.RoomRegistration;
import com.cg.orb.exception.HotelApplicationException;

public interface IHotelDAO {

	public int viewRegisterRoom(RoomRegistration details) throws HotelApplicationException;
	public RoomRegistration   getByRoomNoDetails(int e_id) throws IOException, SQLException;
	public ArrayList<RoomRegistration> retrieveDetails();

}
