package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fitandfun.model.ActivityType;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Sabrina Füreder, Marion Lackner
 * @version 1.0
 * 
 */
public class ActivityTypeTest {

	@SuppressWarnings("unused")
	private StringProperty name;
	private ActivityType activity;
	private BooleanProperty date;
	private BooleanProperty start;
	private BooleanProperty end;
	private BooleanProperty distance;
	private BooleanProperty hmeter;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		activity = new ActivityType("");
		name = new SimpleStringProperty("");
		date = new SimpleBooleanProperty();
		start = new SimpleBooleanProperty();
		end = new SimpleBooleanProperty();
		distance = new SimpleBooleanProperty();
		hmeter = new SimpleBooleanProperty();
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the getName method in class ActivityTypeTest.
	 */
	@Test
	public void testGetName() {
		assertEquals("", activity.getName());

		activity.setName("Aktivität");
		assertEquals("Aktivität", activity.getName());
	}

	/**
	 * Method to test the setName method in class ActivityTypeTest.
	 */
	@Test
	public void testSetName() {
		assertNotEquals("Meine Aktivität", activity.getName());

		activity.setName("Meine Aktivität");
		assertEquals("Meine Aktivität", activity.getName());
	}

	/**
	 * Method to test the getDate method in class ActivityTypeTest.
	 */
	@Test
	public void testGetDate() {
		assertEquals(date.get(), false);

		date.set(true);
		assertEquals(true, date.get());
	}

	/**
	 * Method to test the setDate method in class ActivityTypeTest.
	 */
	@Test
	public void testSetDate() {
		assertEquals(date.get(), false);

		date.set(true);
		assertEquals(true, date.get());
	}

	/**
	 * Method to test the getStart method in class ActivityTypeTest.
	 */
	@Test
	public void testGetStart() {
		assertEquals(start.get(), false);

		start.set(true);
		assertEquals(true, start.get());
	}

	/**
	 * Method to test the setStart method in class ActivityTypeTest.
	 */
	@Test
	public void testSetStart() {
		assertEquals(start.get(), false);

		start.set(true);
		assertEquals(true, start.get());
	}

	/**
	 * Method to test the getEnd method in class ActivityTypeTest.
	 */
	@Test
	public void testGetEnd() {
		assertEquals(end.get(), false);

		end.set(true);
		assertEquals(true, end.get());
	}

	/**
	 * Method to test the setEnd method in class ActivityTypeTest.
	 */
	@Test
	public void testSetEnd() {
		assertEquals(end.get(), false);

		end.set(true);
		assertEquals(true, end.get());
	}

	/**
	 * Method to test the getDistance method in class ActivityTypeTest.
	 */
	@Test
	public void testGetDistance() {
		assertEquals(distance.get(), false);

		distance.set(true);
		assertEquals(true, distance.get());
	}

	/**
	 * Method to test the setDistance method in class ActivityTypeTest.
	 */
	@Test
	public void testSetDistance() {
		assertEquals(distance.get(), false);

		distance.set(true);
		assertEquals(true, distance.get());
	}

	/**
	 * Method to test the getHMeter method in class ActivityTypeTest.
	 */
	@Test
	public void testGetHMeter() {
		assertEquals(hmeter.get(), false);

		hmeter.set(true);
		assertEquals(true, hmeter.get());
	}

	/**
	 * Method to test the setHMeter method in class ActivityTypeTest.
	 */
	@Test
	public void testSetHMeter() {
		assertEquals(hmeter.get(), false);

		hmeter.set(true);
		assertEquals(true, hmeter.get());
	}
}