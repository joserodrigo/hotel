package org.ticpy.tekoporu.hotelBooking.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.hotelBooking.business.RoomBC;
import org.ticpy.tekoporu.hotelBooking.domain.Room;

@ViewController
@NextView("/room_edit.xhtml")
@PreviousView("/room_list.xhtml")
public class RoomListMB extends AbstractListPageBean<Room, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RoomBC roomBC;
	
	@Override
	protected List<Room> handleResultList() {
		return this.roomBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				roomBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}