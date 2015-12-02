/**
 * Activity Preset
 */
package fitandfun.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Viki
 * @version 0.1 
 */
public class Activity {
    
    /**
     * Activity Variables to fill data
     */
    private final ActivityType type;
    private final ObjectProperty<LocalDate> date;
    private final ObjectProperty<LocalTime> start;
    private final ObjectProperty<LocalTime> end;
    private final ObjectProperty<LocalTime> duration;
    private final FloatProperty distance;
    private final IntegerProperty calories;
    private final IntegerProperty height;
    private final FloatProperty avgspeed;
    
    /**
     * Activity Constructor 
     * @param type ActivityTpye to choose what Exercise the user did
     * @param date Date of the Activity
     */
    public Activity(ActivityType type, LocalDate date)
    {
        this.type = type;
        this.date = new SimpleObjectProperty<>(date);
        this.start = new SimpleObjectProperty<>(LocalTime.of(0,0));
        this.end = new SimpleObjectProperty<>(LocalTime.of(0,0));
        this.duration = new SimpleObjectProperty<>(LocalTime.of(end.get().getHour() - start.get().getHour(), end.get().getMinute() - start.get().getMinute()));
        this.distance = new SimpleFloatProperty(0);
        this.calories = new SimpleIntegerProperty(0);
        this.height = new SimpleIntegerProperty(0);
        float speed = 0; // distance/duration
        this.avgspeed = new SimpleFloatProperty(speed);
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
        this.type = type;
        this.date = new SimpleObjectProperty<>(date);
        this.start = new SimpleObjectProperty<>(start);
        this.end = new SimpleObjectProperty<>(end);
        this.duration = new SimpleObjectProperty<>(LocalTime.of(this.end.get().getHour() - this.start.get().getHour(), this.end.get().getMinute() - this.start.get().getMinute()));
        this.distance = new SimpleFloatProperty(0);
        this.calories = new SimpleIntegerProperty(0);
        this.height = new SimpleIntegerProperty(0);
        float speed = 0; // distance/duration
        this.avgspeed = new SimpleFloatProperty(speed);
    }
    
    /**
     * 
     * @param type ActivityTpye to choose what Exercise the user did
     * @param date Date of the Activity
     * @param start Time the Actitity was started
     * @param end Time the Actitity was finished
     * @param distance The Distance in km (can have up to 3 decimals) e.g 10.731
     */
    public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end, Float distance)
    {
        this.type = type;
        this.date = new SimpleObjectProperty<>(date);
        this.start = new SimpleObjectProperty<>(start);
        this.end = new SimpleObjectProperty<>(end);
        this.duration = new SimpleObjectProperty<>(LocalTime.of(this.end.get().getHour() - this.start.get().getHour(), this.end.get().getMinute() - this.start.get().getMinute()));
        this.distance = new SimpleFloatProperty(distance);
        this.calories = new SimpleIntegerProperty(0);
        this.height = new SimpleIntegerProperty(0);
        float speed = 0; // distance/duration
        this.avgspeed = new SimpleFloatProperty(speed);
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
    public Activity(ActivityType type, LocalDate date, LocalTime start, LocalTime end, Float distance, int height)
    {
        this.type = type;
        this.date = new SimpleObjectProperty<>(date);
        this.start = new SimpleObjectProperty<>(start);
        this.end = new SimpleObjectProperty<>(end);
        this.duration = new SimpleObjectProperty<>(LocalTime.of(this.end.get().getHour() - this.start.get().getHour(), this.end.get().getMinute() - this.start.get().getMinute()));
        this.distance = new SimpleFloatProperty(distance);
        this.calories = new SimpleIntegerProperty(0);
        this.height = new SimpleIntegerProperty(height);
        float speed = 0; // distance/duration
        this.avgspeed = new SimpleFloatProperty(speed);
    }
    
    /**
     * Get-Methods
     */
    
    public String getType()
    {
        return this.type.toString();
    }
    
    public LocalDate getDate()
    {
        return date.get();
    };
    
    public LocalTime getStart()
    {
        return start.get();
    };
    
    public LocalTime getEnd()
    {
        return end.get();
    };
    
    public LocalTime getDuration()
    {
        return duration.get();
    };
    
    public float getDistance()
    {
        return distance.get();
    };
    
    public int getCalories()
    {
        return calories.get();
    };
    
    public int getHeight()
    {
        return height.get();
    };
    
    public float getAVGSpeed()
    {
        return avgspeed.get();
    };
    
    /**
     * Set-Methods
     */
    public void setStart(LocalTime time)
    {
        this.start.set(time);
        updateDuration();
    }
    
    public void setEnd(LocalTime time)
    {
        this.end.set(time);
        updateDuration();
    }
    
    public void setDistance(float distance)
    {
        this.distance.set(distance);
    }
    
    public void setHeight(int height)
    {
        this.height.set(height);
    }
    
    /**
     * Update Duration when there are values from start and end available
     */
    private void updateDuration()
    {
        if((start.get().isAfter(LocalTime.MIN))&& (end.get().isAfter(LocalTime.MIN)))
        {
            this.duration.set(LocalTime.of(this.end.get().getHour() - this.start.get().getHour(), this.end.get().getMinute() - this.start.get().getMinute()));
        }
    }
    
    /**
     *  Update AVGSpeed when there are values from distance and duration available 
     */
    private void updateAVGSpeed()
    {
        if(duration.get().isAfter(LocalTime.MIN) && distance.get() > 0)
        {
            float time = duration.get().getHour() + duration.get().getMinute()/60;
            float speed = distance.get()/time;

            this.avgspeed.set(speed);
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
