package JUnitTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.LinkedList;

import org.junit.*;

import fitandfun.model.GoalType;
import fitandfun.model.GoalTypeWrapper;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */

public class GoalTypeWrapperTest {

	private GoalTypeWrapper wrapper;
	private List<GoalType> list;

	private GoalType g1;
	private GoalType g2;
	private GoalType g3;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void setUp() throws Exception {
		wrapper = new GoalTypeWrapper();
		list = new LinkedList<GoalType>();

		g1 = new GoalType("Goaltype1");
		g2 = new GoalType("Goaltype2");
		g3 = new GoalType("Goaltype3");

		list.add(g1);
		list.add(g2);
		list.add(g3);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setGoalTypes method in class GoalTypeWrapper
	 */
	@Test
	public void testSetGoalTypes() {
		assertEquals(null, wrapper.getGoalTypes());

		wrapper.setGoalTypes(list);
		assertEquals(list, wrapper.getGoalTypes());
	}

	/**
	 * Method to test the GetGoalTypes method in class GoalTypeWrapper
	 */
	@Test
	public void testGetGoalTypes() {
		assertEquals(null, wrapper.getGoalTypes());

		wrapper.setGoalTypes(list);
		assertEquals(list, wrapper.getGoalTypes());
	}
}