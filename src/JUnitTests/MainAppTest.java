package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fitandfun.MainApp;


/**
 * @author Kerstin Sachsenhofer
 * @version 1.0
 * 
 */
public class MainAppTest {

	private MainApp mainApp;

	/**
	 * Method to initialize the test class.
	 */
	@Before
	public void setUp() throws Exception {
		mainApp = new MainApp();
	}

	/**
	 * Method to tear down the test class.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method to test the start method in class MainApp.
	 */
	@Test
	public void testStart() {

	}

	/**
	 * Method to test the initRootLayout method in class MainApp.
	 */
	@Test
	public void testInitRootLayout() {

	}

	/**
	 * Method to test the showLogin method in class MainApp.
	 */
	@Test
	public void testShowLogin() {

	}

	/**
	 * Method to test the showHomepage method in class MainApp.
	 */
	@Test
	public void testShowHomepage() {

	}

	/**
	 * Method to test the showOverviewActivity method in class MainApp.
	 */
	@Test
	public void testShowOverviewActivity() {

	}

	/**
	 * Method to test the showStatistics method in class MainApp.
	 */
	@Test
	public void testShowStatistics() {

	}

	/**
	 * Method to test the showTrainingGoals method in class MainApp.
	 */
	@Test
	public void testShowTrainingGoals() {

	}

	/**
	 * Method to test the showInputActivityController method in class MainApp.
	 */
	@Test
	public void testShowInputActivityController() {

	}

	/**
	 * Method to test the showWorkouts method in class MainApp.
	 */
	@Test
	public void testShowWorkouts() {

	}

	/**
	 * Method to test the showUserAdministration method in class MainApp.
	 */
	@Test
	public void testShowUserAdministration() {

	}

	/**
	 * Method to test the showWeightController method in class MainApp.
	 */
	@Test
	public void testShowWeightController() {

	}

	/**
	 * Method to test the showInputTrainingGoalController method in class
	 * MainApp.
	 */
	@Test
	public void testShowInputTrainingGoalController() {

	}

	/**
	 * Method to test the showTrainingGoalCompletedController method in class
	 * MainApp.
	 */
	@Test
	public void testShowTrainingGoalCompletedController() {

	}

	/**
	 * Method to test the showInputGoalType method in class MainApp.
	 */
	@Test
	public void testShowInputGoalType() {

	}

	/**
	 * Method to test the showRecentActivitiesController method in class
	 * MainApp.
	 */
	@Test
	public void testShowRecentActivitiesController() {

	}

	/**
	 * Method to test the showMapMenu method in class MainApp.
	 */
	@Test
	public void testShowMapMenu() {

	}

	/**
	 * Method to test the showMapController method in class MainApp.
	 */
	@Test
	public void testShowMapController() {

	}

	/**
	 * Method to test the showWorkoutsDoneController method in class MainApp.
	 */
	@Test
	public void testShowWorkoutsDoneController() {

	}

	/**
	 * Method to test the setGPXName method in class MainApp.
	 */
	@Test
	public void testSetGPXName() {
		assertEquals("", mainApp.getGPXName());

		mainApp.setGPXName("NewGPXName");
		assertEquals("NewGPXName", mainApp.getGPXName());
	}

	/**
	 * Method to test the getGPXName method in class MainApp.
	 */
	@Test
	public void testGetGPXName() {
		assertEquals("", mainApp.getGPXName());

		mainApp.setGPXName("NewGPXName");
		assertEquals("NewGPXName", mainApp.getGPXName());
	}

	/**
	 * Method to test the saveUserXML method in class MainApp.
	 */
	@Test
	public void testSaveUserXML() {

	}

	/**
	 * Method to test the saveActivityXML method in class MainApp.
	 */
	@Test
	public void testSaveActivityXML() {

	}

	/**
	 * Method to test the saveUserActivityXML method in class MainApp.
	 */
	@Test
	public void testSaveUserActivityXML() {

	}

	/**
	 * Method to test the saveWeightXML method in class MainApp.
	 */
	@Test
	public void testSaveWeightXML() {

	}

	/**
	 * Method to test the saveTrainingGoalsXML method in class MainApp.
	 */
	@Test
	public void testSaveTrainingGoalsXML() {

	}

	/**
	 * Method to test the saveWorkoutsXML method in class MainApp.
	 */
	@Test
	public void testSaveWorkoutsXML() {

	}

	/**
	 * Method to test the saveGoalTypeXML method in class MainApp.
	 */
	@Test
	public void testSaveGoalTypeXML() {

	}

	/**
	 * Method to test the setActiveUser method in class MainApp.
	 */
	@Test
	public void testSetActiveUser() {
		assertEquals(null, mainApp.getActiveUser());

		// mainApp.setActiveUser(activeUser);
		// assertEquals(activeUser, mainApp.getActiveUser());
	}

	/**
	 * Method to test the getActiveUser method in class MainApp.
	 */
	@Test
	public void testGetActiveUser() {
		assertEquals(null, mainApp.getActiveUser());

		// setUser
		// assertEquals
	}

	/**
	 * Method to test the getPrimaryStage method in class MainApp.
	 */
	@Test
	public void testGetPrimaryStage() {

	}

	/**
	 * Method to test the getUserData method in class MainApp.
	 */
	@Test
	public void testGetUserData() {

	}

	/**
	 * Method to test the getUserActivity method in class MainApp.
	 */
	@Test
	public void testGetUserActivity() {

	}

	/**
	 * Method to test the getGoalType method in class MainApp.
	 */
	@Test
	public void testGetGoalType() {

	}

	/**
	 * Method to test the getUserWeight method in class MainApp.
	 */
	@Test
	public void testGetUserWeight() {

	}

	/**
	 * Method to test the getTrainingGoals method in class MainApp.
	 */
	@Test
	public void testGetTrainingGoals() {

	}

	/**
	 * Method to test the getActivityData method in class MainApp.
	 */
	@Test
	public void testGetActivityData() {

	}

	/**
	 * Method to test the getWorkoutData method in class MainApp.
	 */
	@Test
	public void testGetWorkoutData() {

	}
}