package org.ticpy.tekoporu.hotelBooking.view;

import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractEditPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.hotelBooking.business.BDetailBC;
import org.ticpy.tekoporu.hotelBooking.domain.BDetail;

@ViewController
@PreviousView("/bDetail_list.xhtml")
public class BDetailEditMB extends AbstractEditPageBean<BDetail, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BDetailBC bDetailBC;
	
	@Override
	@Transactional
	public String delete() {
		this.bDetailBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.bDetailBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.bDetailBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.bDetailBC.load(getId()));
	}

}