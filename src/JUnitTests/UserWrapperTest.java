package JUnitTests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fitandfun.model.User;
import fitandfun.model.UserWrapper;

/**
 * @author Kerstin Sachsenhofer
 * @version 1.0
 * 
 */

public class UserWrapperTest {

	private UserWrapper wrapper;
	private List<User> list;

	private User u1;
	private User u2;
	private User u3;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		wrapper = new UserWrapper();
		list = new LinkedList<User>();

		u1 = new User("User1");
		u2 = new User("User2");
		u3 = new User("User3");

		list.add(u1);
		list.add(u2);
		list.add(u3);
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the setUsers method in class UserWrapper
	 */
	@Test
	public void testSetUsers() {
		assertEquals(null, wrapper.getUsers());

		wrapper.setUsers(list);
		assertEquals(list, wrapper.getUsers());
	}

	/**
	 * Method to test the getUsers method in class UserWrapper
	 */
	@Test
	public void testGetUsers() {
		assertEquals(null, wrapper.getUsers());

		wrapper.setUsers(list);
		assertEquals(list, wrapper.getUsers());
	}
}