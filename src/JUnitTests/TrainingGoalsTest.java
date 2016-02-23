package JUnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.*;

import fitandfun.model.TrainingGoals;
import fitandfun.model.GoalType;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.FloatProperty;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */
public class TrainingGoalsTest {

	private GoalType goaltype;
	private TrainingGoals traininggoal;
	private StringProperty name;
	private LocalDate date1;
	private float goalValue;
	private LocalDate startDate;
	private FloatProperty goalValueProperty;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void setUp() throws Exception {
		name = new SimpleStringProperty("");
		goaltype = new GoalType("");
		date1 = LocalDate.ofYearDay(2016, 19);
		startDate = LocalDate.ofYearDay(2016, 16);
		traininggoal = new TrainingGoals("", goaltype, goalValue, date1, startDate);
		goalValueProperty = new SimpleFloatProperty();
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setName method in class TrainingGoals
	 */
	@Test
	public void testSetName() {
		assertNotEquals("Trainingsziel", traininggoal.getName());

		traininggoal.setName("Trainingsziel");
		assertEquals("Trainingsziel", traininggoal.getName());
	}

	/**
	 * Method to test the getName method in class TrainingGoals
	 */
	@Test
	public void testGetName() {
		assertEquals("", traininggoal.getName());

		traininggoal.setName("Trainingsziel");
		assertEquals("Trainingsziel", traininggoal.getName());
	}

	/**
	 * Method to test the getTypeString method in class TrainingGoals
	 */
	@Test
	public void testGetTypeString() {
		assertEquals("", traininggoal.getName());

		traininggoal.setName("Traininggoal");
		assertEquals("Traininggoal", traininggoal.getName());
	}

	/**
	 * Method to test the setType method in class TrainingGoals
	 */
	@Test
	public void testSetType() {
		assertNotEquals(null, traininggoal.getType());

		traininggoal.setType(goaltype);
		assertEquals(goaltype, traininggoal.getType());
	}

	/**
	 * Method to test the getType method in class TrainingGoals
	 */
	@Test
	public void testGetType() {
		assertNotEquals(null, traininggoal.getType());
		traininggoal.setType(goaltype);
		assertEquals(goaltype, traininggoal.getType());
	}

	/**
	 * Method to test the getStartDateString method in class TrainingGoals
	 */
	@Test
	public void testGetStartDateString() {
		assertNotNull(traininggoal.getStartDate());

		assertEquals("2016-01-16", traininggoal.getStartDateString());
	}

	/**
	 * Method to test the setStartDateString method in class TrainingGoals
	 */
	@Test
	public void testSetStartDateString() {
		assertNotNull(traininggoal.getStartDate().toString());

		assertEquals("2016-01-16", traininggoal.getStartDateString());
		traininggoal.setStartDateString("2016-01-30");
		assertEquals("2016-01-30", traininggoal.getStartDateString());
	}

	/**
	 * Method to test the getDateString method in class TrainingGoals
	 */
	@Test
	public void testGetDateString() {
		assertNotNull(traininggoal.getDate());

		assertEquals("2016-01-19", traininggoal.getDateString());
	}

	/**
	 * Method to test the setDateString method in class TrainingGoals
	 */
	@Test
	public void testSetDateString() {
		assertNotNull(traininggoal.getDate().toString());

		assertEquals("2016-01-19", traininggoal.getDateString());
		traininggoal.setDateString("2016-01-30");
		assertEquals("2016-01-30", traininggoal.getDateString());
	}

	/**
	 * Method to test the getGoalValue method in class TrainingGoals
	 */
	@Test
	public void testGetGoalValue() {
		assertEquals(0.0, goalValueProperty.getValue(), 0.0);

		goalValueProperty.setValue(5.2);
		assertEquals(5.2, goalValueProperty.getValue(), 0.1);
	}

	/**
	 * Method to test the setGoalValue method in class TrainingGoals
	 */
	@Test
	public void testSetGoalValue() {
		goalValueProperty.setValue(5.2);
		assertEquals(5.2, goalValueProperty.getValue(), 0.1);
	}
}