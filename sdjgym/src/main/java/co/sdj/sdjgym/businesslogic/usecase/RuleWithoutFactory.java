package co.sdj.sdjgym.businesslogic.usecase;

public interface RuleWithoutFactory<T> {
	void execute(T data);

}
