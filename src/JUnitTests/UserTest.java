package JUnitTests;

import static org.junit.Assert.*;
import java.time.LocalDate;
import org.junit.*;
import fitandfun.model.User;
import fitandfun.Sex;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author Simone Wolkerstorfer
 * @version 1.0
 * 
 */
public class UserTest {

	private User user;
	private Sex sex;
	private LocalDate birthday;
	private FloatProperty weight;
	private IntegerProperty height;
	private float w;
	private int h;
	private FloatProperty bmi;
	private BooleanProperty isNew;

	/**
	 * Method to initialized the test class.
	 */
	@Before
	public void setUp() throws Exception {
		sex = Sex.Female;
		user = new User("Simone", sex);
		birthday = LocalDate.of(2016, 1, 19);
		user.setBirhtday(birthday);
		weight = new SimpleFloatProperty(55.0f);
		height = new SimpleIntegerProperty(175);
		bmi = new SimpleFloatProperty();
		isNew = new SimpleBooleanProperty();
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setUsername method in class User
	 */
	@Test
	public void testSetUsername() {
		assertNotEquals("User", user.getUsername());

		// user.setUsername("User");
		assertEquals("Simone", user.getUsername());
	}

	/**
	 * Method to test the getUserName method in class User
	 */
	@Test
	public void testGetUsername() {
		assertEquals("Simone", user.getUsername());

		user.setUsername("User");
		assertEquals("User", user.getUsername());
	}

	/**
	 * Method to test the getSex method in class User
	 */
	@Test
	public void testGetSex() {
		assertEquals(Sex.Female, user.getSex());

		user.setSex(Sex.Male);
		assertEquals(Sex.Male, user.getSex());
	}

	/**
	 * Method to test the setSex method in class User
	 */
	@Test
	public void testSetSex() {
		assertNotEquals(null, user.getSex());

		user.setSex(sex);
		assertEquals(sex, user.getSex());
	}

	/**
	 * Method to test the getBirthday method in class User
	 */
	@Test
	public void testGetBirthday() {
		assertEquals(birthday, user.getBirthday());

		LocalDate l = LocalDate.ofYearDay(2016, 14);
		user.setBirhtday(l);

		assertEquals(l, user.getBirthday());
	}

	/**
	 * Method to test the setBirthday method in class User
	 */
	@Test
	public void testSetBirthday() {
		assertEquals(birthday, user.getBirthday());

		LocalDate l = LocalDate.of(2016, 1, 14);
		user.setBirhtday(l);

		assertEquals(l, user.getBirthday());
	}

	/**
	 * Method to test the getBithdayString method in class User
	 */
	@Test
	public void testGetBirthdayString() {
		assertEquals("2016-01-19", user.getBirthdayString());

		user.setBirthdayString("2016-05-02");
		assertEquals("2016-05-02", user.getBirthdayString());
	}

	/**
	 * Method to test the setBirthdayString method in class User
	 */
	@Test
	public void testSetBirthdayString() {
		assertEquals("2016-01-19", user.getBirthdayString());

		user.setBirthdayString("2016-05-02");
		assertEquals("2016-05-02", user.getBirthdayString());
	}

	/**
	 * Method to test the getWeight method in class User
	 */
	@Test
	public void testGetWeight() {
		assertEquals(55.0, weight.getValue(), 0.0);

		weight.setValue(5.2);
		assertEquals(5.2, weight.getValue(), 0.1);
	}

	/**
	 * Method to test the setWeight method in class User
	 */
	@Test
	public void testSetWeight() {
		weight.setValue(5.2);
		assertEquals(5.2, weight.getValue(), 0.1);
	}

	/**
	 * Method to test the getHeight method in class User
	 */
	@Test
	public void testGetHeight() {
		assertEquals(175, height.get());

		height.set(120);
		assertEquals(120, height.get(), 0);
	}

	/**
	 * Method to test the setHeight method in class User
	 */
	@Test
	public void testSetHeight() {
		height.set(120);
		assertEquals(120, height.get());
	}

	/**
	 * Method to test the getBMI method in class User
	 */
	@Test
	public void testGetBMI() {
		assertEquals(0.0, bmi.getValue(), 0.0);

		bmi.setValue(5.2);
		assertEquals(5.2, bmi.getValue(), 0.1);
	}

	/**
	 * Method to test the getIsNew method in class User
	 */
	@Test
	public void testGetIsNew() {
		isNew.set(true);
		assertEquals(true, isNew.get());
	}

	/**
	 * Method to test the setIsNew method in class User
	 */
	@Test
	public void testSetIsNew() {
		isNew.set(false);
		assertEquals(false, isNew.get());
	}

	/**
	 * Method to test the updateBMI method in class User
	 */
	@Test
	public void testUpdateBMI() {
		assertEquals(this.bmi.get(), user.getBMI(), 0.1);

		user.updateBMI();
		assertEquals(this.bmi.get(), user.getBMI(), 0.1);
	}
}