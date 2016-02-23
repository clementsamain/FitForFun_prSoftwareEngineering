package JUnitTests;

import static org.junit.Assert.*;
import org.junit.*;
import fitandfun.model.ActivityType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Sabrina Füreder, Marion Lackner
 * @version 1.0
 * 
 */
public class ActivityTypeParameterTest {

	@SuppressWarnings("unused")
	private StringProperty paramName;
	@SuppressWarnings("unused")
	private StringProperty paramUnit;
	private ActivityType activity;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		paramName = new SimpleStringProperty("");
		paramUnit = new SimpleStringProperty("");
		activity = new ActivityType("");
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {

	}

	/**
	 * Method to test the getParamName method in class ActivityTypeParameter.
	 */
	@Test
	public void testGetParamName() {
		assertEquals("", activity.getName());

		activity.setName("ParamName");
		assertEquals("ParamName", activity.getName());
	}

	/**
	 * Method to test the setParamName method in class ActivityTypeParameter.
	 */
	@Test
	public void testSetParamName() {
		assertNotEquals("ParamName", activity.getName());

		activity.setName("ParamName");
		assertEquals("ParamName", activity.getName());
	}

	/**
	 * Method to test the getParamUnit method in class ActivityTypeParameter.
	 */
	@Test
	public void testGetParamUnit() {
		assertEquals("", activity.getName());

		activity.setName("ParamUnit");
		assertEquals("ParamUnit", activity.getName());
	}

	/**
	 * Method to test the setParamUit method in class ActivityTypeParameter.
	 */
	@Test
	public void testSetParamUnit() {
		assertNotEquals("ParamUnit", activity.getName());

		activity.setName("ParamUnit");
		assertEquals("ParamUnit", activity.getName());
	}
}