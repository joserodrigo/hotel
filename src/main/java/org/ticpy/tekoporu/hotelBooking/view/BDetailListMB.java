package org.ticpy.tekoporu.hotelBooking.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import org.ticpy.tekoporu.annotation.NextView;
import org.ticpy.tekoporu.annotation.PreviousView;
import org.ticpy.tekoporu.stereotype.ViewController;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.transaction.Transactional;
import org.ticpy.tekoporu.hotelBooking.business.BDetailBC;
import org.ticpy.tekoporu.hotelBooking.domain.BDetail;

@ViewController
@NextView("/bDetail_edit.xhtml")
@PreviousView("/bDetail_list.xhtml")
public class BDetailListMB extends AbstractListPageBean<BDetail, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BDetailBC bDetailBC;
	
	@Override
	protected List<BDetail> handleResultList() {
		return this.bDetailBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				bDetailBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}