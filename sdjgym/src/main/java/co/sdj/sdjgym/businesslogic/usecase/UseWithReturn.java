package co.sdj.sdjgym.businesslogic.usecase;

public interface UseWithReturn<D,R> {
	R execute(D data);
}
