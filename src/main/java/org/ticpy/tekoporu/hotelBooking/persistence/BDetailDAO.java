package org.ticpy.tekoporu.hotelBooking.persistence;

import javax.inject.Inject;

import org.slf4j.Logger;

import org.ticpy.tekoporu.stereotype.PersistenceController;
import org.ticpy.tekoporu.template.JPACrud;

import org.ticpy.tekoporu.hotelBooking.domain.BDetail;

@PersistenceController
public class BDetailDAO extends JPACrud<BDetail, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@SuppressWarnings("unused")
	private Logger logger;

}
