package JUnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;

/**
 * @author Sabrina Füreder, Marion Lackner
 * @version 1.0
 * 
 */
public class ActivityTest {

	private ActivityType activitytype;
	private Activity activity;
	private Activity activitydate;
	private FloatProperty distance;
	private FloatProperty avgspeed;
	private IntegerProperty calories;
	private IntegerProperty hmeter;
	private LocalDate date1;
	private LocalTime duration;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		activitytype = new ActivityType("");
		activity = new Activity(activitytype);
		date1 = LocalDate.ofYearDay(2016, 19);
		activitydate = new Activity(activitytype, date1);
		duration = LocalTime.of(00, 30, 00);
		distance = new SimpleFloatProperty();
		avgspeed = new SimpleFloatProperty();
		calories = new SimpleIntegerProperty();
		hmeter = new SimpleIntegerProperty();

	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the getTypeString method in class Activity.
	 */
	@Test
	public void testGetTypeString() {
		assertNotNull(activity.getType());

		assertEquals("", activity.getTypeString());
	}

	/**
	 * Method to test the getType method in class Activity.
	 */
	@Test
	public void testGetType() {
		assertEquals("", activitytype.getName());

		activitytype.setName("Activity");
		assertEquals("Activity", activitytype.getName());
	}

	/**
	 * Method to test the setType method in class Activity.
	 */
	@Test
	public void testSetType() {
		assertNotEquals(null, activity.getType());

		activity.setType(activitytype);
		assertEquals(activitytype, activity.getType());
	}

	/**
	 * Method to test the getDateString method in class Activity.
	 */
	@Test
	public void testGetDateString() {
		assertNotNull(activitydate.getDate());

		assertEquals("2016-01-19", activitydate.getDateString());
	}

	/**
	 * Method to test the setDateString method in class Activity.
	 */
	@Test
	public void testSetDateString() {
		assertNotNull(activitydate.getDate().toString());

		assertEquals("2016-01-19", activitydate.getDateString());
		activitydate.setDateString("2016-01-30");
		assertEquals("2016-01-30", activitydate.getDateString());
	}

	/**
	 * Method to test the getDurationString method in class Activity.
	 */
	@Test
	public void testGetDurationString() {
		assertNull(activitydate.getDuration());

		activitydate.setDuration(duration);
		assertEquals("00:30:00", activitydate.getDurationString());
	}

	/**
	 * Method to test the setDurationString method in class Activity.
	 */
	@Test
	public void testSetDurationString() {
		assertNull(activitydate.getDuration());

		activitydate.setDuration(duration);
		assertEquals("00:30:00", activitydate.getDurationString());
		activitydate.setDurationString("00:40:00");
		assertEquals("00:40:00", activitydate.getDurationString());
	}

	/**
	 * Method to test the getDistance method in class Activity.
	 */
	@Test
	public void testGetDistance() {
		assertEquals(0.0, distance.getValue(), 0.0);

		distance.setValue(5.2);
		assertEquals(5.2, distance.getValue(), 0.1);
	}

	/**
	 * Method to test the setDistance method in class Activity.
	 */
	@Test
	public void testSetDistance() {
		distance.setValue(5.2);
		assertEquals(5.2, distance.getValue(), 0.1);
	}

	/**
	 * Method to test the getAvgSpeed method in class Activity.
	 */
	@Test
	public void testGetAvgSpeed() {
		assertEquals(0.0, avgspeed.getValue(), 0.0);

		avgspeed.setValue(5.2);
		assertEquals(5.2, avgspeed.getValue(), 0.1);
	}

	/**
	 * Method to test the setAvgSpeed method in class Activity.
	 */
	@Test
	public void testSetAvgSpeed() {
		avgspeed.setValue(5.2);
		assertEquals(5.2, avgspeed.getValue(), 0.1);
	}

	/**
	 * Method to test the getCalories method in class Activity.
	 */
	@Test
	public void testGetCalories() {
		assertEquals(0, calories.get());

		calories.set(120);
		assertEquals(120, calories.get(), 0);
	}

	/**
	 * Method to test the setCalories method in class Activity.
	 */
	@Test
	public void testSetCalories() {
		calories.set(120);
		assertEquals(120, calories.get());
	}

	/**
	 * Method to test the getHMeter method in class Activity.
	 */
	@Test
	public void testGetHMeter() {
		assertEquals(0, hmeter.get());

		hmeter.set(320);
		assertEquals(320, hmeter.get(), 0);
	}

	/**
	 * Method to test the setHMeter method in class Activity.
	 */
	@Test
	public void testSetHMeter() {
		hmeter.set(120);
		assertEquals(120, hmeter.get());
	}
}