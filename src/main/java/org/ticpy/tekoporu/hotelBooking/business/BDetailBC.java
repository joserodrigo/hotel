package org.ticpy.tekoporu.hotelBooking.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import org.ticpy.tekoporu.hotelBooking.domain.BDetail;
import org.ticpy.tekoporu.hotelBooking.persistence.BDetailDAO;

@BusinessController
public class BDetailBC extends DelegateCrud<BDetail, Long, BDetailDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
