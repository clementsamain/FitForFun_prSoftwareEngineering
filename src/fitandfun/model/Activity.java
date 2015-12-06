/**
 * Activity Preset
 */
package fitandfun.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlElement;

import fitandfun.Sex;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Viki
 * @version 0.1 
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
    
    
    public Activity()
    {
    	this(null);
    }
    
    public Activity(ActivityType type)
    {
    	this(type,null);
    }
    
    /**
     * Activity Constructor 
     * @param type ActivityTpye to choose what Exercise the user did
     * @param date Date of the Activity
     */
    public Activity(ActivityType type, LocalDate date)
    {
    	this(type, date, null, null);
    }
    
    /**
     * 
     * @param type ActivityTpye to choose what Exercise the user did
     * @param date Date of the Activity
     * @param start Time the Actitity was started
     * @param end Time the Actitity was finished
     */
    public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end)
    {
        this(type, date, start, end, 0);
    }
    
    /**
     * 
     * @param type ActivityTpye to choose what Exercise the user did
     * @param date Date of the Activity
     * @param start Time the Actitity was started
     * @param end Time the Actitity was finished
     * @param distance The Distance in km (can have up to 3 decimals) e.g 10.731
     */
    public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end, float distance)
    {
    	this(type, date, start, end, distance, 0);
    }
    
    /**
     * 
     * @param type ActivityTpye to choose what Exercise the user did
     * @param date Date of the Activity
     * @param start Time the Actitity was started
     * @param end Time the Actitity was finished
     * @param distance The Distance in km (can have up to 3 decimals) for example 10.731
     * @param height Höhenmeter in meter for example 64
     */
    public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end, float distance, int height)
    {
        this.type = new SimpleObjectProperty<>(type);
        this.date = new SimpleObjectProperty<>(date);
        this.start = new SimpleObjectProperty<>(start);
        this.end = new SimpleObjectProperty<>(end);
        this.duration = new SimpleObjectProperty<>();
        this.distance = new SimpleFloatProperty(distance);
        this.calories = new SimpleIntegerProperty(0);
        this.height = new SimpleIntegerProperty(height);
        this.avgspeed = new SimpleFloatProperty(0);
        
        this.start.addListener((value) -> updateDuration());
        this.end.addListener((value) -> updateDuration());
        
        this.duration.addListener((value) -> updateAVGSpeed());
        this.distance.addListener((value) -> updateAVGSpeed());
        
        updateDuration();
        updateAVGSpeed();
        updateCalories();
    }
    
    private void updateCalories() {
    	//TODO
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for activityName
     */
    public ObjectProperty<ActivityType> activityTypeProperty()
    {
    	return this.type;
    }
    
    
    public String getTypeString()
    {
    	if(type.get() != null){
    		return type.get().getName();
    	}
    	return "";
    }
    
    public void setTypeString(String nType)
    {
    	
    }
    
    @XmlElement(name="Type")
    public ActivityType getType()
    {
    	return type.get();
    }
    
    public void setType(ActivityType type)
    {
    	this.type.set(type);
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for date
     */
    public ObjectProperty<LocalDate> dateProperty()
    {
    	return this.date;
    }
    
    @XmlElement(name = "Date")
    public String getDateString()
    {
    	if(date.get() == null)
    	{
    		return "";
    	}
    	return date.get().format(DateTimeFormatter.ISO_DATE);
    }
    
    public void setDateString(String dateString)
    {
    	if(dateString != null)
    	{
    		this.date.set(LocalDate.parse(dateString));
    	}else
    	{
    		this.date.set(null);
    	}
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for startTime
     */
    public ObjectProperty<LocalTime> startProperty()
    {
    	return this.start;
    }
    
    @XmlElement(name = "Start")
    public String getStartString()
    {
    	if(start.get() == null)
    	{
    		return "";
    	}
    	return start.get().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
    
    public void setStartString(String startString)
    {
    	if(startString != null)
    	{
    		this.start.set(LocalTime.parse(startString));
    	}else
    	{
    		this.start.set(null);
    	}
    }
    
    public void setStart(LocalTime start)
    {
    	this.start.set(start);
    }
    
    public LocalTime getStart()
    {
    	return this.start.get();
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for endTime
     */
    public ObjectProperty<LocalTime> endProperty()
    {
    	return this.end;
    }
    
    @XmlElement(name = "End")
    public String getEndString()
    {
    	if(end.get() == null)
    	{
    		return "";
    	}
    	return end.get().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
    
    public void setEndString(String endString)
    {
    	if(endString != null)
    	{
    		this.end.set(LocalTime.parse(endString));
    	}else
    	{
    		this.end.set(null);
    	}
    }
    
    public void setEnd(LocalTime end)
    {
    	this.end.set(end);
    }
    
    public LocalTime getEnd()
    {
    	return this.end.get();
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for duration
     */
    public ObjectProperty<LocalTime> durationProperty()
    {
    	return this.duration;
    }
    
    @XmlElement(name = "Duration")
    public String getDurationString()
    {
    	if(duration.get() == null)
    	{
    		return "";
    	}
    	return duration.get().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
    
    public void setDurationString(String durationString)
    {
    	if(durationString != null)
    	{
    		this.duration.set(LocalTime.parse(durationString));
    	}else
    	{
    		this.duration.set(null);
    	}
    }
    
    public void setDuration(LocalTime duration)
    {
    	this.duration.set(duration);
    }
    
    public LocalTime getDuration()
    {
    	return this.duration.get();
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for distance
     */
    public FloatProperty distanceProperty()
    {
    	return this.distance;
    }
    
    @XmlElement(name="Distance")
    public float getDistance()
    {
    	return distance.get();
    }
    
    public void setDistance(float distance)
    {
    	this.distance.set(distance);
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for avgSpeed
     */
    public FloatProperty avgSpeedProperty()
    {
    	return this.avgspeed;
    }
    
    @XmlElement(name="AVGSpeed")
    public float getAVGSpeed()
    {
    	return avgspeed.get();
    }
    
    public void setAVGSpeed(float speed)
    {
    	this.avgspeed.set(speed);
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for calories
     */
    public IntegerProperty calorieProperty()
    {
    	return this.calories;
    }
    
    @XmlElement(name="Calories")
    public int getCalories()
    {
    	return calories.get();
    }
    
    public void setCalories(int cal)
    {
    	this.avgspeed.set(cal);
    }
    
    /**
     * Property-getter, Getter- and Setter Methods for heightMeter
     */
    public IntegerProperty hmeterProperty()
    {
    	return this.height;
    }
    
    @XmlElement(name="HMeter")
    public int getHMeter()
    {
    	return height.get();
    }
    
    public void setHMeter(int meter)
    {
    	this.height.set(meter);
    }
    
    
    /**
     * Update Duration when there are values from start and end available
     */
    private void updateDuration()
    {
    	if(start.get() != null && end.get() != null)
    	{
	        if((end.get().isAfter(start.get())))
	        {
	            this.duration.set(LocalTime.of(this.end.get().getHour() - this.start.get().getHour(), this.end.get().getMinute() - this.start.get().getMinute()));
	        }else
	        {
	        	this.duration.set(LocalTime.MIN);
	        }
        }
    }
    
    /**
     *  Update AVGSpeed when there are values from distance and duration available 
     */
    private void updateAVGSpeed()
    {
    	if(duration.get() != null)
    	{
	        if(duration.get().isAfter(LocalTime.MIN) && distance.get() > 0)
	        {
	            float time = duration.get().getHour() + duration.get().getMinute()/60;
	            float speed = distance.get()/time;
	
	            this.avgspeed.set(speed);
	        }
    	}
    }
    
    /**
     * Get the AVGSpeed in m/s
     * @return returns the AVGSpeed in m/s 
     */
    private float getAVGSpeedmps()
    {
           return avgspeed.get()/(float)3.6;
    }
}
