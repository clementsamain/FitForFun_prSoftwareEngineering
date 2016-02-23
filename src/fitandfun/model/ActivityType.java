package fitandfun.model;

import javax.xml.bind.annotation.XmlElement;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * ActivityType to load and save ActivityTypes used by all Users
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
public class ActivityType {

	/**
	 * Activity Variables to fill data
	 */
	private final StringProperty actName;
	private final SimpleBooleanProperty date;
	private final SimpleBooleanProperty start;
	private final SimpleBooleanProperty end;
	private final SimpleBooleanProperty distance;
	private final SimpleBooleanProperty hmeter;

	public ActivityType() {
		this(null);
	}

	/**
	 * Activity Constructor
	 * 
	 * @param type
	 *            ActivityTpye to choose what Exercise the user did
	 * @param date
	 *            Date of the Activity
	 */
	public ActivityType(String name) {
		this.actName = new SimpleStringProperty(name);
		this.date = new SimpleBooleanProperty();
		this.start = new SimpleBooleanProperty();
		this.end = new SimpleBooleanProperty();
		this.distance = new SimpleBooleanProperty();
		this.hmeter = new SimpleBooleanProperty();
	}

	/**
	 * Property-getter, Getter- and Setter Methods for activityName
	 */
	public StringProperty nameProperty() {
		return this.actName;
	}

	@XmlElement(name = "Type")
	public String getName() {
		return this.actName.get();
	}

	public void setName(String name) {
		this.actName.set(name);
	}

	public SimpleBooleanProperty dateProperty() {
		return this.date;
	}

	@XmlElement(name = "Date")
	public boolean getDate() {
		return this.date.get();
	}

	public void setDate(boolean val) {
		this.date.set(val);
	}

	public SimpleBooleanProperty startProperty() {
		return this.start;
	}

	@XmlElement(name = "Start")
	public boolean getStart() {
		return this.start.get();
	}

	public void setStart(boolean val) {
		this.start.set(val);
	}

	public SimpleBooleanProperty endProperty() {
		return this.end;
	}

	@XmlElement(name = "End")
	public boolean getEnd() {
		return this.end.get();
	}

	public void setEnd(boolean val) {
		this.end.set(val);
	}

	public SimpleBooleanProperty distanceProperty() {
		return this.distance;
	}

	@XmlElement(name = "Distance")
	public boolean getDistance() {
		return this.distance.get();
	}

	public void setDistance(boolean val) {
		this.distance.set(val);
	}

	public SimpleBooleanProperty hmeterProperty() {
		return this.hmeter;
	}

	@XmlElement(name = "HMeter")
	public boolean getHMeter() {
		return this.hmeter.get();
	}

	public void setHMeter(boolean val) {
		this.hmeter.set(val);
	}
}
