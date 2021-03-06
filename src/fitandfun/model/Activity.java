package fitandfun.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Activity-Class for creating UserActivities
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
public class Activity {

	/**
	 * Activity Variables to fill data
	 */
	private final ObjectProperty<ActivityType> type;
	private final ObjectProperty<LocalDate> date;
	private final ObjectProperty<LocalTime> start;
	private final ObjectProperty<LocalTime> end;
	private final ObjectProperty<LocalTime> duration;
	private final FloatProperty distance;
	private final IntegerProperty calories;
	private final IntegerProperty height;
	private final FloatProperty avgspeed;
	private final StringProperty gpxName;

	/**
	 * Activity-Constructor
	 * 
	 * @see {@link Activity#Activity(ActivityType)}
	 */
	public Activity() {
		this(null);
	}

	/**
	 * Activity-Constructor
	 * 
	 * @see {@link Activity#Activity(ActivityType, LocalDate)}
	 */
	public Activity(ActivityType type) {
		this(type, null);
	}

	/**
	 * Activity-Constructor
	 * 
	 * @see {@link Activity#Activity(ActivityType, LocalDate, LocalTime, LocalTime)}
	 */
	public Activity(ActivityType type, LocalDate date) {
		this(type, date, null, null);
	}

	/**
	 * Activity-Constructor
	 * 
	 * @see {@link Activity#Activity(ActivityType, LocalDate, LocalTime, LocalTime, float)}
	 */
	public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end) {
		this(type, date, start, end, 0);
	}

	/**
	 * Activity-Constructor
	 * 
	 * @see {@link Activity#Activity(ActivityType, LocalDate, LocalTime, LocalTime, float, int)}
	 */
	public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end, float distance) {
		this(type, date, start, end, distance, 0, null);
	}

	/**
	 * Constructor for Activity
	 * 
	 * @param type
	 *            ActivityTpye to choose what Exercise the user did
	 * @param date
	 *            Date of the Activity
	 * @param start
	 *            Time the Actitity was started
	 * @param end
	 *            Time the Actitity was finished
	 * @param distance
	 *            The Distance in km (can have up to 2 decimals) for example
	 *            10.73
	 * @param height
	 *            Höhenmeter in meter for example 64
	 */
	public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end, float distance, int height, String gpxName) {
		this.type = new SimpleObjectProperty<>(type);
		this.date = new SimpleObjectProperty<>(date);
		this.start = new SimpleObjectProperty<>(start);
		this.end = new SimpleObjectProperty<>(end);
		this.duration = new SimpleObjectProperty<>();
		this.distance = new SimpleFloatProperty(distance);
		this.calories = new SimpleIntegerProperty(0);
		this.height = new SimpleIntegerProperty(height);
		this.avgspeed = new SimpleFloatProperty(0);
		this.gpxName = new SimpleStringProperty (gpxName);

		this.start.addListener((value) -> updateDuration());
		this.end.addListener((value) -> updateDuration());

		this.duration.addListener((value) -> updateAVGSpeed());
		this.distance.addListener((value) -> updateAVGSpeed());

		updateDuration();
		updateAVGSpeed();
		updateCalories();
	}

	/**
	 * Method how to calculate Calories - update the Calories Variable
	 * <br> Not implemented -> ToDo in Version 2.0
	 */
	private void updateCalories() {
		// TODO
	}

	/**
	 * Property-getter, Getter- and Setter Methods for activityType
	 */
	public ObjectProperty<ActivityType> activityTypeProperty() {
		return this.type;
	}

	@XmlTransient
	public String getTypeString() {
		if (type.get() != null) {
			return type.get().getName();
		}
		return "";
	}

	@XmlElement(name = "Type")
	public ActivityType getType() {
		return type.get();
	}

	public void setType(ActivityType type) {
		this.type.set(type);
	}

	/**
	 * Property-getter, Getter- and Setter Methods for date
	 */
	public ObjectProperty<LocalDate> dateProperty() {
		return this.date;
	}

	@XmlElement(name = "Date")
	public String getDateString() {
		if (date.get() == null) {
			return "";
		}
		return date.get().format(DateTimeFormatter.ISO_DATE);
	}

	public void setDateString(String dateString) {
		if (dateString != null) {
			this.date.set(LocalDate.parse(dateString));
		} else {
			this.date.set(null);
		}
	}
	
	public LocalDate getDate()
	{
		return date.get();
	}

	/**
	 * Property-getter, Getter- and Setter Methods for startTime
	 */
	public ObjectProperty<LocalTime> startProperty() {
		return this.start;
	}

	@XmlElement(name = "Start")
	public String getStartString() {
		if (start.get() == null) {
			return "";
		}
		return start.get().format(DateTimeFormatter.ISO_LOCAL_TIME);
	}

	public void setStartString(String startString) {
		if (startString != null) {
			this.start.set(LocalTime.parse(startString));
		} else {
			this.start.set(null);
		}
	}

	public void setStart(LocalTime start) {
		this.start.set(start);
	}
	
	public void setStart(int h, int m, int s)
	{
		LocalTime t = LocalTime.of(h, m, s);
		this.start.set(t);
	}
	
	public void setStart(int h, int m)
	{
		LocalTime t = LocalTime.of(h, m, 0);
		this.start.set(t);
	}

	@XmlTransient
	public LocalTime getStart() {
		return this.start.get();
	}

	/**
	 * Property-getter, Getter- and Setter Methods for endTime
	 */
	public ObjectProperty<LocalTime> endProperty() {
		return this.end;
	}

	@XmlElement(name = "End")
	public String getEndString() {
		if (end.get() == null) {
			return "";
		}
		return end.get().format(DateTimeFormatter.ISO_LOCAL_TIME);
	}

	public void setEndString(String endString) {
		if (endString != null) {
			this.end.set(LocalTime.parse(endString));
		} else {
			this.end.set(null);
		}
	}

	public void setEnd(LocalTime end) {
		this.end.set(end);
	}
	
	public void setEnd(int h, int m, int s)
	{
		LocalTime t = LocalTime.of(h, m, s);
		this.end.set(t);
	}

	@XmlTransient
	public LocalTime getEnd() {
		return this.end.get();
	}

	/**
	 * Property-getter, Getter- and Setter Methods for duration
	 */
	public ObjectProperty<LocalTime> durationProperty() {
		return this.duration;
	}

	@XmlTransient
	public String getDurationString() {
		if (duration.get() == null) {
			return "";
		}
		return duration.get().format(DateTimeFormatter.ISO_LOCAL_TIME);
	}

	public void setDurationString(String durationString) {
		if (durationString != null) {
			this.duration.set(LocalTime.parse(durationString));
		} else {
			this.duration.set(null);
		}
	}

	public void setDuration(LocalTime duration) {
		this.duration.set(duration);
	}
	
	@XmlTransient
	public LocalTime getDuration() {
		return this.duration.get();
	}

	/**
	 * Property-getter, Getter- and Setter Methods for distance
	 */
	public FloatProperty distanceProperty() {
		return this.distance;
	}

	@XmlElement(name = "Distance")
	public float getDistance() {
		return distance.get();
	}

	public void setDistance(float distance) {
		this.distance.set(distance);
	}

	/**
	 * Property-getter, Getter- and Setter Methods for avgSpeed
	 */
	public FloatProperty avgSpeedProperty() {
		return this.avgspeed;
	}

	@XmlTransient
	public float getAVGSpeed() {
		return avgspeed.get();
	}

	public void setAVGSpeed(float speed) {
		this.avgspeed.set(speed);
	}

	/**
	 * Property-getter, Getter- and Setter Methods for calories
	 */
	public IntegerProperty calorieProperty() {
		return this.calories;
	}

	@XmlElement(name = "Calories")
	public int getCalories() {
		return calories.get();
	}

	public void setCalories(int cal) {
		this.avgspeed.set(cal);
	}

	/**
	 * Property-getter, Getter- and Setter Methods for heightMeter
	 */
	public IntegerProperty hmeterProperty() {
		return this.height;
	}

	@XmlElement(name = "HMeter")
	public int getHMeter() {
		return height.get();
	}

	public void setHMeter(int meter) {
		this.height.set(meter);
	}
	
	/**
	 *  Property- getter, Getter- and Setter Methods for gpxName		      
	 */
	
	public StringProperty gpxProperty() {
		return this.gpxName;
	}
	
	@XmlElement(name = "gpxName")   
	public String getgpxName(){
		return gpxName.get();
	}
	
	public void setGpxName (String gpxName){
		this.gpxName.set(gpxName);
	}

	/**
	 * Update Duration when there are values from start and end available
	 */
	private void updateDuration() {
		try{
		if (start.get() != null && end.get() != null) {
			if ((end.get().isAfter(start.get()))) {
				this.duration.set(LocalTime.of(this.end.get().getHour() - this.start.get().getHour(),
						this.end.get().getMinute() - this.start.get().getMinute()));
			} else {
				this.duration.set(LocalTime.MIN);
			}
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Update AVGSpeed when there are values from distance and duration
	 * available
	 */
	private void updateAVGSpeed() {
		try {
			if (duration.get() != null) {
				if (duration.get().isAfter(LocalTime.MIN) && distance.get() > 0) {
					float time = duration.get().getHour() + duration.get().getMinute() / 60;
					float speed = distance.get() / time;

					this.avgspeed.set(speed);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
