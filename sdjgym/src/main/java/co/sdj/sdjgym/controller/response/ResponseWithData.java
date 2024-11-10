package co.sdj.sdjgym.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.sdj.crosscutting.helpers.ObjectHelper;

public abstract class ResponseWithData<T> extends Response {
	
	private List<T> data;

	public final List<T> getData() {
		return data;
	}

	public final void setData(List<T> data) {
		this.data = ObjectHelper.getDefault(data, this.data);
	}
	
}
