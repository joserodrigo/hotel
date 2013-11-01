package org.ticpy.tekoporu.hotelBooking.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.hotelBooking.business.PeopleBC;
import org.ticpy.tekoporu.hotelBooking.domain.People;

@ViewController
@PreviousView("/people_list.xhtml")
public class PeopleEditMB extends AbstractEditPageBean<People, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PeopleBC peopleBC;

	
	@Override
	@Transactional
	public String delete() {
		this.peopleBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.peopleBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.peopleBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.peopleBC.load(getId()));
	}

}