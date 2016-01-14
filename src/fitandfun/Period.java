package fitandfun;

/**
 * Enum for Period used by Statistics
 * @author Stefan
 * @version 0.1
 * @see User.java
 * @see UserAdministrationController.java
 */
public enum Period {
	Month, Year, All;

	@Override
	public String toString() {
		switch (this) {
		case Month:
			return "letztes Monat";
		case Year:
			return "letztes Jahr";
		case All:
			return "Alles";
		default:
			return this.name();
		}
	};
}