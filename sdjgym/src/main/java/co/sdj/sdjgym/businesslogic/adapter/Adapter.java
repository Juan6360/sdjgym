package co.sdj.sdjgym.businesslogic.adapter;

import java.util.List;



public interface Adapter<D, T> {
	D adaptSource(T data);
	
	T adaptTarget(D data);
	
	List<T> adaptTarget(List<D> data);
	
	List<D> adaptSource(List<T> data);

}
