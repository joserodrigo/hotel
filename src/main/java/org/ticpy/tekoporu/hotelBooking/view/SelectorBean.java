package org.ticpy.tekoporu.hotelBooking.view;

import java.util.List;
import org.primefaces.model.LazyDataModel;
import org.ticpy.tekoporu.template.AbstractListPageBean;
import org.ticpy.tekoporu.template.JPACrud;

public abstract class SelectorBean<T, I> extends AbstractListPageBean<T, I> {

	private static final long serialVersionUID = 1L;

	private Class<? extends JPACrud<T, I>> entityBC;
	private transient LazyDataModel<T> lazyDataModel;
	private int pageSize = 5;
	private I selectedEntityId;
	private T selectedEntity;

	public Class<? extends JPACrud<T, I>> getEntityBC() {

		return entityBC;
	}

	public void setEntityBC(Class<? extends JPACrud<T, I>> entityBC) {

		this.entityBC = entityBC;
	}

	public LazyDataModel<T> getLazyDataModel() {

		return lazyDataModel;
	}

	public void setLazyDataModel(LazyDataModel<T> lazyDataModel) {

		this.lazyDataModel = lazyDataModel;
	}

	public int getPageSize() {

		return pageSize;
	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;
	}

	public I getSelectedEntityId() {

		return selectedEntityId;
	}

	public void setSelectedEntityId(I selectedEntityId) {

		this.selectedEntityId = selectedEntityId;
	}

	public T getSelectedEntity() {

		return selectedEntity;
	}

	public void setSelectedEntity(T selectedEntity) {

		this.selectedEntity = selectedEntity;
	}
//
//	@Override
//	protected List<T> handleResultList() {
//
//		// TODO Auto-generated method stub
//		return null;
//	}

	protected abstract void loadLazyDataModel();
}
