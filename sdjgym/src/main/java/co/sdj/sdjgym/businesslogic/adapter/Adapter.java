package co.sdj.sdjgym.businesslogic.adapter;

import java.util.List;

public interface Adapter<T,D > {
	D adaptTarget(T data);
	
	T adaptSource(D data);
	
	
	
	List<D> adaptTarget(List<T> data);

}
