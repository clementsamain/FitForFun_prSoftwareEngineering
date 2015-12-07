package fitandfun;

/**
 * Enum for Sex used by User and UserAdministration
 * @author Viki
 * @version 0.1
 * @see User.java
 * @see UserAdministrationController.java
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
