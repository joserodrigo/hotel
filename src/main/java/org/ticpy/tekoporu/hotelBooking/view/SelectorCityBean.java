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

import org.ticpy.tekoporu.hotelBooking.business.CityBC;
import org.ticpy.tekoporu.hotelBooking.domain.City;
import org.ticpy.tekoporu.stereotype.ViewController;

@ManagedBean(name="selectorCityBean")
@ViewController
public class SelectorCityBean extends SelectorBean<City, Long> implements
		Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CityBC cityBC;

	@Inject
	private City city;
	
	@Inject
	private EntityManager em;
	
	//private Entidad value;

	@Override
	@SuppressWarnings("serial")
	@PostConstruct
	public void loadLazyDataModel() {

		// TODO Auto-generated method stub
		this.setLazyDataModel(new LazyDataModel<City>() {

			@Override
			public List<City> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, String> filters) {

				if (filters.containsKey("globalFilter")) {
					String tipoValor = filters.get("globalFilter");
					filters = new HashMap<String, String>();
					filters.put("cityDesc", tipoValor);
				}

				if (sortField == null) {
					sortField = "cityId"; // default sort field
				}

				List<City> cities = new ArrayList<City>();

				boolean sortAsc = true;
				if (sortOrder != null) {
					sortAsc = sortOrder.compareTo(SortOrder.ASCENDING) == 0;
				}

				cities = cityBC.findPage(pageSize, first, sortField,
						sortAsc, filters);

				return cities;
			}
		});
		this.getLazyDataModel().setRowCount(cityBC.count());
		this.getLazyDataModel().setPageSize(getPageSize());
	}

	public City getCity() {

		return this.city;
	}

	public void setCity(City city) {

		this.city = city;
	}

	public List<City> getCities(){
		List<City> citiesList = cityBC.findAll();
		return citiesList;
	}
	
	
	public City getCityById(String cityId){
		Query q= em.createQuery("select c from City c where c.city_id = :id");
		q.setParameter("id", cityId);	
		return  (City) q.getResultList();
		 
	 }

	@Override
	protected List<City> handleResultList() {

		// TODO Auto-generated method stub
		return null;
	}	
}
