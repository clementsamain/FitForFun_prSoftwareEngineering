package JUnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fitandfun.model.Weight;

/**
 * @author Kerstin Sachsenhofer
 * @version 1.0
 * 
 */

public class WeightTest {

	private Weight weight;
	private LocalDate date1;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		date1 = LocalDate.ofYearDay(2016, 15);
		weight = new Weight(date1, 53.0);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the getDateString method in class Weight.
	 */
	@Test
	public void testgetDateString() {
		assertEquals("2016-01-15", weight.getDateString());
		assertNotEquals("2016-01-14", weight.getDateString());
	}

	/**
	 * Method to test the setDateString method in class Weight.
	 */
	@Test
	public void testSetDateString() {
		assertEquals("2016-01-15", weight.getDateString());

		weight.setDateString("2016-01-18");
		assertEquals("2016-01-18", weight.getDateString());
		assertNotEquals("2016-01-15", weight.getDateString());

	}

	/**
	 * Method to test the getWeight method in class Weight.
	 */
	@Test
	public void testGetWeight() {
		assertEquals(53.0, weight.getWeight(), 0.1);

		weight.setWeight(54.0);
		assertEquals(54.0, weight.getWeight(), 0.1);
		assertNotEquals(53.0, weight.getWeight(), 0.1);
	}

	/**
	 * Method to test the setWeight method in class Weight.
	 */
	@Test
	public void testSetWeight() {
		assertEquals(53.0, weight.getWeight(), 0.1);

		weight.setWeight(54.0);
		assertEquals(54.0, weight.getWeight(), 0.1);
		assertNotEquals(53.0, weight.getWeight(), 0.1);
	}
}