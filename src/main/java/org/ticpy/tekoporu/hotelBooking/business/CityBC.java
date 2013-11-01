package org.ticpy.tekoporu.hotelBooking.business;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ticpy.tekoporu.stereotype.BusinessController;
import org.ticpy.tekoporu.template.DelegateCrud;

import org.ticpy.tekoporu.hotelBooking.domain.City;
import org.ticpy.tekoporu.hotelBooking.persistence.CityDAO;

@BusinessController
public class CityBC extends DelegateCrud<City, Long, CityDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CityDAO cityDAO;
	
	public List<City> findPage(int pageSize, int first, String sortField,
			boolean sortAsc, Map<String, String> filters) {
		return cityDAO
				.findPage(pageSize, first, sortField, sortAsc, filters);
	}
	
	public int count() {
		return cityDAO.count();
	}
	
}
