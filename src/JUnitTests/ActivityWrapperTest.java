package JUnitTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.*;

import fitandfun.model.ActivityType;
import fitandfun.model.ActivityWrapper;

/**
 * @author Sabrina Füreder, Marion Lackner
 * @version 1.0
 * 
 */
public class ActivityWrapperTest {

	private ActivityWrapper wrapper;
	private List<ActivityType> list;

	private ActivityType activity1;
	private ActivityType activity2;
	private ActivityType activity3;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		wrapper = new ActivityWrapper();
		list = new LinkedList<ActivityType>();

		activity1 = new ActivityType("Workout1");
		activity2 = new ActivityType("Workout2");
		activity3 = new ActivityType("Workout3");

		list.add(activity1);
		list.add(activity2);
		list.add(activity3);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setActivites method in class ActivityWrapper.
	 */
	@Test
	public void testSetActivities() {
		assertEquals(null, wrapper.getActivities());

		wrapper.setActivities(list);
		assertEquals(list, wrapper.getActivities());
	}

	/**
	 * Method to test the getActivities method in class ActivityWrapper.
	 */
	@Test
	public void testGetActivites() {
		assertEquals(null, wrapper.getActivities());

		wrapper.setActivities(list);
		assertEquals(list, wrapper.getActivities());
	}
}