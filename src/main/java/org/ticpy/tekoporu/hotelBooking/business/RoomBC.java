package org.ticpy.tekoporu.hotelBooking.business;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import org.ticpy.tekoporu.hotelBooking.domain.Room;
import org.ticpy.tekoporu.hotelBooking.persistence.RoomDAO;

@BusinessController
public class RoomBC extends DelegateCrud<Room, Long, RoomDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RoomDAO roomDAO;
	
	public List<Room> findPage(int pageSize, int first, String sortField,
			boolean sortAsc, Map<String, String> filters) {
		return roomDAO
				.findPage(pageSize, first, sortField, sortAsc, filters);
	}
	
	public int count() {
		return roomDAO.count();
	}
}
