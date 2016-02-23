package JUnitTests;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fitandfun.model.Activity;
import fitandfun.model.ActivityComparator;
import fitandfun.model.ActivityType;

/**
 * @author Kerstin Sachsenhofer, Simone Wolkerstorfer
 * @version 1.0
 * 
 */
public class ActivityComparatorTest {

	private ActivityComparator comparator;
	private ActivityType type1;
	private ActivityType type2;
	private LocalDate date1;
	private LocalDate date2;
	private Activity activity1;
	private Activity activity2;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		comparator = new ActivityComparator();

		type1 = new ActivityType("Sit-Up's");
		type1 = new ActivityType("Liegestützen");

		date1 = LocalDate.ofYearDay(2016, 15);
		date2 = LocalDate.ofYearDay(2016, 28);

		activity1 = new Activity(type1, date1);
		activity2 = new Activity(type2, date2);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the compare method in class ActivityComparator.
	 */
	@Test
	public void testCompare() {
		assertNotEquals(0, comparator.compare(activity1, activity2));
		assertEquals(13, comparator.compare(activity1, activity2));
	}
}
