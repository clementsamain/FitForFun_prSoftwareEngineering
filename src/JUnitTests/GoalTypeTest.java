package JUnitTests;

import static org.junit.Assert.*;
import org.junit.*;

import fitandfun.model.ActivityType;
import fitandfun.model.ActivityTypeParameter;
import fitandfun.model.GoalType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.ObjectProperty;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */

public class GoalTypeTest {

	public GoalType goaltype;
	public StringProperty name;
	private ObjectProperty<ActivityType> actType;
	private ObjectProperty<ActivityTypeParameter> actTypeParam;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void SetUp() throws Exception {
		goaltype = new GoalType("");
		name = new SimpleStringProperty("");
		actType = new SimpleObjectProperty<>();
		actTypeParam = new SimpleObjectProperty<>();
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void TearDown() throws Exception {
	}

	/**
	 * Method to test the setWName method in class GoalType
	 */
	@Test
	public void testSetName() {
		assertNotEquals("Goaltype", goaltype.getName());

		goaltype.setName("Goaltype");
		assertEquals("Goaltype", goaltype.getName());
	}

	/**
	 * Method to test the getName method in class GoalType
	 */
	@Test
	public void testGetName() {
		assertEquals("", goaltype.getName());

		goaltype.setName("Goaltype");
		assertEquals("Goaltype", goaltype.getName());
	}

	/**
	 * Method to test the actTypeProperty method in class GoalType
	 */
	@Test
	public void testactTypeProperty(ActivityType at) {
		goaltype.setActType(at);
		assertSame(at, goaltype.actTypeProperty());
	}

	@Test
	public void testSetActType(ActivityType at) {
		goaltype.setActType(at);
		assertSame(at, goaltype.actTypeProperty());
	}

	/**
	 * Method to test the actTypeProperty method in class GoalType
	 */
	@Test
	public void testactTypeParamProperty(ActivityTypeParameter param) {
		goaltype.setActTypeParam(param);
		assertSame(param, goaltype.actTypeParamProperty());
	}

	@Test
	public void testSetActType(ActivityTypeParameter param) {
		goaltype.setActTypeParam(param);
		assertSame(param, goaltype.actTypeParamProperty());
	}
}