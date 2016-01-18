package fitandfun;

/**
 * Enum for Sex used by User and UserAdministration
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
public enum Sex {
	None, Male, Female;

	@Override
	public String toString() {
		switch (this) {
		case None:
			return "";
		case Male:
			return "Männlich";
		case Female:
			return "Weiblich";
		default:
			return this.name();
		}
	};
}
