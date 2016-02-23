package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fitandfun.model.WorkoutType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Kerstin Sachsenhofer
 * @version 1.0
 * 
 */

public class WorkoutTypeTest {

	public WorkoutType workout;
	public StringProperty name;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		workout = new WorkoutType("");
		name = new SimpleStringProperty("");
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setName method in class WorkoutType.
	 */
	@Test
	public void testSetName() {
		assertNotEquals("MeinWorkout", workout.getName());

		workout.setName("MeinWorkout");
		assertEquals("MeinWorkout", workout.getName());
	}

	/**
	 * Method to test the getName method in class WorkoutType.
	 */
	@Test
	public void testGetName() {
		assertEquals("", workout.getName());

		workout.setName("Workout");
		assertEquals("Workout", workout.getName());
	}

	/**
	 * Method to test the getExercise1 method in class WorkoutType.
	 */
	@Test
	public void testGetExercise1() {
		assertEquals(null, workout.getExercise1());

		workout.setExercise1("Liegestütze");
		assertEquals("Liegestütze", workout.getExercise1());
	}

	/**
	 * Method to test the setExercise1 method in class WorkoutType.
	 */
	@Test
	public void testSetExercise1() {
		assertEquals(null, workout.getExercise1());

		workout.setExercise1("Liegestütze");
		assertEquals("Liegestütze", workout.getExercise1());
	}

	/**
	 * Method to test the getExercise2 method in class WorkoutType.
	 */
	@Test
	public void testGetExercise2() {
		assertEquals(null, workout.getExercise2());

		workout.setExercise2("Sit-Up's");
		assertEquals("Sit-Up's", workout.getExercise2());
	}

	/**
	 * Method to test the setExercise2 method in class WorkoutType.
	 */
	@Test
	public void testSetExercise2() {
		assertEquals(null, workout.getExercise2());

		workout.setExercise2("Sit-Up's");
		assertEquals("Sit-Up's", workout.getExercise2());
	}

	/**
	 * Method to test the getExercise3 method in class WorkoutType.
	 */
	@Test
	public void testGetExercise3() {
		assertEquals(null, workout.getExercise3());

		workout.setExercise3("Gewichte heben");
		assertEquals("Gewichte heben", workout.getExercise3());
	}

	/**
	 * Method to test the setExercise3 method in class WorkoutType.
	 */
	@Test
	public void testSetExercise3() {
		assertEquals(null, workout.getExercise3());

		workout.setExercise3("Gewichte heben");
		assertEquals("Gewichte heben", workout.getExercise3());
	}

	/**
	 * Method to test the getExercise4 method in class WorkoutType.
	 */
	@Test
	public void testGetExercise4() {
		assertEquals(null, workout.getExercise4());

		workout.setExercise4("Liegestütze");
		assertEquals("Liegestütze", workout.getExercise4());
	}

	/**
	 * Method to test the setExercise4 method in class WorkoutType.
	 */
	@Test
	public void testSetExercise4() {
		assertEquals(null, workout.getExercise4());

		workout.setExercise4("Liegestütze");
		assertEquals("Liegestütze", workout.getExercise4());
	}

	/**
	 * Method to test the getExercise5 method in class WorkoutType.
	 */
	@Test
	public void testGetExercise5() {
		assertEquals(null, workout.getExercise5());

		workout.setExercise5("Sit-Up's");
		assertEquals("Sit-Up's", workout.getExercise5());
	}

	/**
	 * Method to test the setExercise5 method in class WorkoutType.
	 */
	@Test
	public void testSetExercise5() {
		assertEquals(null, workout.getExercise5());

		workout.setExercise5("Sit-Up's");
		assertEquals("Sit-Up's", workout.getExercise5());
	}

	/**
	 * Method to test the getExercise6 method in class WorkoutType.
	 */
	@Test
	public void testGetExercise6() {
		assertEquals(null, workout.getExercise6());

		workout.setExercise6("Bauchklappen");
		assertEquals("Bauchklappen", workout.getExercise6());
	}

	/**
	 * Method to test the setExercise6 method in class WorkoutType.
	 */
	@Test
	public void testSetExercise6() {
		assertEquals(null, workout.getExercise6());

		workout.setExercise6("Bauchklappen");
		assertEquals("Bauchklappen", workout.getExercise6());
	}

	/**
	 * Method to test the getRepeat1 method in class WorkoutType.
	 */
	@Test
	public void testGetRepeat1() {
		assertEquals(null, workout.getRepeat1());

		workout.setRepeat1("5");
		assertEquals("5", workout.getRepeat1());
	}

	/**
	 * Method to test the setRepeat1 method in class WorkoutType.
	 */
	@Test
	public void testSetRepeat1() {
		assertEquals(null, workout.getRepeat1());

		workout.setRepeat1("5");
		assertEquals("5", workout.getRepeat1());
	}

	/**
	 * Method to test the getRepeat2 method in class WorkoutType.
	 */
	@Test
	public void testGetRepeat2() {
		assertEquals(null, workout.getRepeat2());

		workout.setRepeat2("8");
		assertEquals("8", workout.getRepeat2());
	}

	/**
	 * Method to test the setRepeat2 method in class WorkoutType.
	 */
	@Test
	public void testSetRepeat2() {
		assertEquals(null, workout.getRepeat2());

		workout.setRepeat2("5");
		assertEquals("5", workout.getRepeat2());
	}

	/**
	 * Method to test the getRepeat3 method in class WorkoutType.
	 */
	@Test
	public void testGetRepeat3() {
		assertEquals(null, workout.getRepeat3());

		workout.setRepeat3("19");
		assertEquals("19", workout.getRepeat3());
	}

	/**
	 * Method to test the setRepeat3 method in class WorkoutType.
	 */
	@Test
	public void testSetRepeat3() {
		assertEquals(null, workout.getRepeat3());

		workout.setRepeat3("3");
		assertEquals("3", workout.getRepeat3());
	}

	/**
	 * Method to test the getRepeat4 method in class WorkoutType.
	 */
	@Test
	public void testGetRepeat4() {
		assertEquals(null, workout.getRepeat4());

		workout.setRepeat4("14");
		assertEquals("14", workout.getRepeat4());
	}

	/**
	 * Method to test the setRepeat4 method in class WorkoutType.
	 */
	@Test
	public void testSetRepeat4() {
		assertEquals(null, workout.getRepeat4());

		workout.setRepeat4("14");
		assertEquals("14", workout.getRepeat4());
	}

	/**
	 * Method to test the getRepeat5 method in class WorkoutType.
	 */
	@Test
	public void testGetRepeat5() {
		assertEquals(null, workout.getRepeat5());

		workout.setRepeat5("10");
		assertEquals("10", workout.getRepeat5());
	}

	/**
	 * Method to test the setRepeat5 method in class WorkoutType.
	 */
	@Test
	public void testSetRepeat5() {
		assertEquals(null, workout.getRepeat5());

		workout.setRepeat5("10");
		assertEquals("10", workout.getRepeat5());
	}

	/**
	 * Method to test the getRepeat6 method in class WorkoutType.
	 */
	@Test
	public void testGetRepeat6() {
		assertEquals(null, workout.getRepeat6());

		workout.setRepeat6("5");
		assertEquals("5", workout.getRepeat6());
	}

	/**
	 * Method to test the setRepeat6 method in class WorkoutType.
	 */
	@Test
	public void testSetRepeat6() {
		assertEquals(null, workout.getRepeat6());

		workout.setRepeat6("5");
		assertEquals("5", workout.getRepeat6());
	}

	/**
	 * Method to test the getCountsToGo method in class WorkoutType.
	 */
	@Test
	public void testGetCountsToGo() {
		assertEquals(null, workout.getCountsToGo());

		workout.setCountsToGo("5");
		assertEquals("5", workout.getCountsToGo());
	}

	/**
	 * Method to test the setCountsToGo method in class WorkoutType.
	 */
	@Test
	public void testSetCountsToGo() {
		assertEquals(null, workout.getCountsToGo());

		workout.setCountsToGo("5");
		assertEquals("5", workout.getCountsToGo());
	}
}