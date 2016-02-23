package JUnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fitandfun.model.Weight;
import fitandfun.model.WeightWrapper;

/**
 * @author Kerstin Sachsenhofer
 * @version 1.0
 * 
 */

public class WeightWrapperTest {

	private WeightWrapper wrapper;
	private List<Weight> list;

	private Weight w1;
	private Weight w2;
	private Weight w3;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void setUp() throws Exception {
		wrapper = new WeightWrapper();
		list = new LinkedList<Weight>();

		LocalDate date1 = LocalDate.ofYearDay(2016, 10);
		LocalDate date2 = LocalDate.ofYearDay(2016, 15);
		LocalDate date3 = LocalDate.ofYearDay(2016, 20);

		w1 = new Weight(date1, 55.0);
		w2 = new Weight(date2, 57.0);
		w3 = new Weight(date3, 56.0);

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
	 * Method to test the setWeight method in class WorkoutWrapper
	 */
	@Test
	public void testSetWeight() {
		assertEquals(null, wrapper.getWeight());

		wrapper.setWeight(list);
		assertEquals(list, wrapper.getWeight());
	}

	/**
	 * Method to test the getWeight method in class WorkoutWrapper
	 */
	@Test
	public void testGetWeight() {
		assertEquals(null, wrapper.getWeight());

		wrapper.setWeight(list);
		assertEquals(list, wrapper.getWeight());
	}
}