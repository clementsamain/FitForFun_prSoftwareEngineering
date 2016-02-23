package JUnitTests;

import static org.junit.Assert.*;

import org.junit.*;

import fitandfun.Period;

/**
 * @author Sabrina Füreder, Marion Lackner
 * @version 1.0
 * 
 */
public class PeriodTest {
	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Method to tear down the test class.
	 */
	@Before
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the toString method in class Period.
	 */
	@Test
	public void testToString() {
		assertEquals(Period.act.toString(), "dieses Jahr");
		assertEquals(Period.last.toString(), "letztes Jahr");
	}
}