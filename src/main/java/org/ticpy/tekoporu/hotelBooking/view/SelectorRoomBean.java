package org.ticpy.tekoporu.hotelBooking.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import org.ticpy.tekoporu.hotelBooking.business.RoomBC;
import org.ticpy.tekoporu.hotelBooking.domain.Room;
import org.ticpy.tekoporu.stereotype.ViewController;

@ManagedBean(name="selectorRoomBean")
@ViewController
public class SelectorRoomBean extends SelectorBean<Room, Long> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private RoomBC roomBC;
	
	@Inject
	private Room room;
	
	@Inject
	private EntityManager em;

	@Override
	@SuppressWarnings("serial")
	@PostConstruct
	protected void loadLazyDataModel() {
      this.setLazyDataModel(new LazyDataModel<Room>(){

    		@Override
    		public List<Room> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, String> filters) {
    			
    			if (filters.containsKey("globalFilter")) {
					String tipoValor = filters.get("globalFilter");
					filters = new HashMap<String, String>();
					filters.put("roomDesc", tipoValor);
				}

				if (sortField == null) {
					sortField = "roomId"; // default sort field
				}

				List<Room> rooms = new ArrayList<Room>();

				boolean sortAsc = true;
				if (sortOrder != null) {
					sortAsc = sortOrder.compareTo(SortOrder.ASCENDING) == 0;
				}

				rooms = roomBC.findPage(pageSize, first, sortField,
						sortAsc, filters);

				return rooms;
			}
		});
		this.getLazyDataModel().setRowCount(roomBC.count());
		this.getLazyDataModel().setPageSize(getPageSize());
 
	}

	public void setRoom(Room room) {

		this.room = room;
	}

	public Room getRoom() {

		return room;
	}
	
	public List<Room> getRooms(){
		List<Room> roomsList = roomBC.findAll();
		return roomsList;
	}
	
	
	public Room getRoomById(String roomId){
		Query q= em.createQuery("select r from Room r where c.room_id = :id");
		q.setParameter("id", roomId);	
		return  (Room) q.getResultList();
		 
	 }

	@Override
	protected List<Room> handleResultList() {

		// TODO Auto-generated method stub
		return null;
	}	

}
