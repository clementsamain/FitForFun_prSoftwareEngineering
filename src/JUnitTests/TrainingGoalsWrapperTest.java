package JUnitTests;

import static org.junit.Assert.*;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */

import java.util.List;
import java.time.LocalDate;
import java.util.LinkedList;

import org.junit.*;

import fitandfun.model.TrainingGoalsWrapper;
import fitandfun.model.GoalType;
import fitandfun.model.TrainingGoals;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */
public class TrainingGoalsWrapperTest {

	private TrainingGoalsWrapper wrapper;
	private List<TrainingGoals> list;

	private TrainingGoals tg1;
	private TrainingGoals tg2;

	private GoalType gt1;
	private GoalType gt2;

	private LocalDate dateStart1;
	private LocalDate dateStart2;

	private LocalDate goalDate1;
	private LocalDate goalDate2;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void setUp() throws Exception {
		wrapper = new TrainingGoalsWrapper();
		list = new LinkedList<TrainingGoals>();

		dateStart1 = LocalDate.ofYearDay(2016, 18);
		dateStart2 = LocalDate.ofYearDay(2016, 35);

		goalDate1 = LocalDate.ofYearDay(2016, 56);
		goalDate2 = LocalDate.ofYearDay(2016, 89);

		tg1 = new TrainingGoals("TrainingGoal1", gt1, 4.0f, goalDate1, dateStart1);
		tg2 = new TrainingGoals("TrainingGoal2", gt2, 4.0f, goalDate2, dateStart2);

		list.add(tg1);
		list.add(tg2);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setGoalTypes method in class TrainingGoalsWrapper
	 */
	@Test
	public void testSetGoalTypes() {
		assertEquals(null, wrapper.getGoals());

		wrapper.setGoals(list);
		assertEquals(list, wrapper.getGoals());
	}

	/**
	 * Method to test the setGetGoals method in class TrainingGoalsWrapper
	 */
	@Test
	public void testGetGoals() {
		assertEquals(null, wrapper.getGoals());

		wrapper.setGoals(list);
		assertEquals(list, wrapper.getGoals());
	}
}