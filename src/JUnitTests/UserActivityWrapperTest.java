package JUnitTests;

import static org.junit.Assert.*;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */

import org.junit.*;

import java.util.LinkedList;
import java.util.List;

import fitandfun.model.UserActivityWrapper;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */
public class UserActivityWrapperTest {

	private UserActivityWrapper wrapper;
	private List<Activity> list;

	private Activity a1;
	private Activity a2;
	private Activity a3;

	private ActivityType t1;
	private ActivityType t2;
	private ActivityType t3;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void setUp() throws Exception {
		wrapper = new UserActivityWrapper();
		list = new LinkedList<Activity>();

		t1 = new ActivityType("Activity1");

		a1 = new Activity(t1);
		a2 = new Activity(t2);
		a3 = new Activity(t3);

		list.add(a1);
		list.add(a2);
		list.add(a3);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the SetUserActivites method in class UserActivityWrapper
	 */
	@Test
	public void testSetUserActivities() {
		assertEquals(null, wrapper.getUserActivities());

		wrapper.setUserActivities(list);
		assertEquals(list, wrapper.getUserActivities());
	}

	/**
	 * Method to test the GetWorkouts method in class UserActivityWrapper
	 */
	@Test
	public void testGetWorkouts() {
		assertEquals(null, wrapper.getUserActivities());

		wrapper.setUserActivities(list);
		assertEquals(list, wrapper.getUserActivities());
	}
}