package org.ticpy.tekoporu.hotelBooking.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.hotelBooking.business.BookingBC;
import org.ticpy.tekoporu.hotelBooking.domain.Booking;

@ViewController
@NextView("/booking_edit.xhtml")
@PreviousView("/booking_list.xhtml")
public class BookingListMB extends AbstractListPageBean<Booking, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BookingBC bookingBC;
	
	@Override
	protected List<Booking> handleResultList() {
		return this.bookingBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				bookingBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}