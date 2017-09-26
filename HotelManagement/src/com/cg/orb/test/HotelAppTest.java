package com.cg.orb.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.frs.dao.HotelDaoImpl;
import com.cg.frs.dao.IHotelDAO;
import com.cg.orb.dto.RoomRegistration;
import com.cg.orb.exception.HotelApplicationException;

public class HotelAppTest {
	
	static IHotelDAO dao=null;
	static RoomRegistration details=null;
	
	@BeforeClass
	
	public static void initialize() 
	{
		System.out.println( "Testing is done");
		dao=new HotelDaoImpl();
		details=new  RoomRegistration();
	}
	
	
	
	@Test
	//public void test() {
		
		public void testData() {
			//fail("Not yet implemented");
		details.setHotelId(1);
		details.setRoomno(1001);
		details.setRoomType(2);
		details.setRoomArea(8000);
		details.setRentAmount(2022);
		details.setPaidAmount(202222);
			
		}

	@Test
	public void viewRegisterRoom() throws HotelApplicationException
	
	{
		assertNotNull(dao.viewRegisterRoom(details));
		
	}
	
	@Test
	public void retrieveDetails()
	
	{
		assertNotNull(dao.retrieveDetails());
		
	}
}



	//private void assertNotNull(ArrayList<RoomRegistration> retrieveDetails) {
		// TODO Auto-generated method stub
		
	//}



