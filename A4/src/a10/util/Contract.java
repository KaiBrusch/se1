package a10.util;

public class Contract {

	private Contract() {

	}

	public static void requires(boolean condition)
			throws ContractViolatedException {
		if (!condition)
			throw new ContractViolatedException(
					"Contract broken! It will cost ya!");
	}

	public static void requires(boolean... conditions)
			throws ContractViolatedException {
		for (boolean condition : conditions) {
			requires(condition);
		}
	}

	public static class ContractViolatedException extends Exception {
		private static final long serialVersionUID = 1L;
		public ContractViolatedException(String message) {
			super(message);
		}
	}

}
