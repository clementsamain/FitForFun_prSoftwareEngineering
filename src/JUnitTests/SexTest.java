package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fitandfun.Sex;

/**
 * @author Sabrina Füreder, Marion Lackner
 * @version 1.0
 * 
 */
public class SexTest {
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
	 * Method to test the toString method in class Sex.
	 */
	@Test
	public void testToString() {
		assertEquals(Sex.None.toString(), "");
		assertEquals(Sex.Male.toString(), "Männlich");
		assertEquals(Sex.Female.toString(), "Weiblich");
	}
}