package JUnitTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fitandfun.model.WorkoutType;
import fitandfun.model.WorkoutWrapper;

/**
 * @author Kerstin Sachsenhofer
 * @version 1.0
 * 
 */

public class WorkoutWrapperTest {

	private WorkoutWrapper wrapper;
	private List<WorkoutType> list;

	private WorkoutType w1;
	private WorkoutType w2;
	private WorkoutType w3;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void setUp() throws Exception {
		wrapper = new WorkoutWrapper();
		list = new LinkedList<WorkoutType>();

		w1 = new WorkoutType("Workout1");
		w2 = new WorkoutType("Workout2");
		w3 = new WorkoutType("Workout3");

		list.add(w1);
		list.add(w2);
		list.add(w3);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setWorkouts method in class WorkoutWrapper
	 */
	@Test
	public void testSetWorkouts() {
		assertEquals(null, wrapper.getWorkouts());

		wrapper.setWorkouts(list);
		assertEquals(list, wrapper.getWorkouts());
	}

	/**
	 * Method to test the getWorkouts method in class WorkoutWrapper
	 */
	@Test
	public void testGetWorkouts() {
		assertEquals(null, wrapper.getWorkouts());

		wrapper.setWorkouts(list);
		assertEquals(list, wrapper.getWorkouts());
	}
}