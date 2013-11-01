package org.ticpy.tekoporu.hotelBooking.business;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import org.ticpy.tekoporu.hotelBooking.domain.People;
import org.ticpy.tekoporu.hotelBooking.persistence.PeopleDAO;

@BusinessController
public class PeopleBC extends DelegateCrud<People, Integer, PeopleDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
