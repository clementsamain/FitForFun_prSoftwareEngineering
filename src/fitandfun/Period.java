package fitandfun;

/**
 * Enum for Period used by Statistics
 * @author Stefan Kaindlbinder
 * @version 1.0
 * 
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