package fitandfun;

/**
 * Enum for Period used by Statistics
 * @author Stefan
 * @version 0.1
 * @see User.java
 * @see UserAdministrationController.java
 */
public enum Period {
	act, last;

	@Override
	public String toString() {
		switch (this) {
		case act:
			return "dieses Jahr";
		case last:
			return "letztes Jahr";
		default:
			return this.name();
		}
	};
}