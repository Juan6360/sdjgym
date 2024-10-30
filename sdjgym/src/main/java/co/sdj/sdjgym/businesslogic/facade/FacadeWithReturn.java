package co.sdj.sdjgym.businesslogic.facade;

public interface FacadeWithReturn<T, R> {
	R execute(T data);
}
