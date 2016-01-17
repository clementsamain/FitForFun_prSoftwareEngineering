package fitandfun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import fitandfun.model.*;
import fitandfun.view.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

	/**
	 * XML File to load and save Users
	 */
	private final String FILE_USERS = "XML\\Users.xml";
	/**
	 * XML File to load and save Activities (Types)
	 */
	private final String FILE_ACTIVITY = "XML\\Activities.xml";
	
	private String FILE_GOALTYPES = "XML\\GoalTypes.xml";
	
	private String FILE_WORKOUTS;
	private String FILE_USERACTIVITY;
	private String FILE_WEIGHT;
	private String FILE_USERGOALS;
	

	private User activeUser;
	private Stage primaryStage;
	private BorderPane rootLayout;

	/**
	 * The data as an observable list of Users.
	 */
	private ObservableList<User> userData = FXCollections.observableArrayList();

	/**
	 * The data as an observable list of ActivityTypes.
	 */
	private ObservableList<ActivityType> activityData = FXCollections.observableArrayList();

	/**
	 * The data as an observable list of User-Activities.
	 */
	private ObservableList<Activity> userActivityData = FXCollections.observableArrayList();
	/**
	 * The data as an observable list of User-Workouts.
	 */
	private ObservableList<WorkoutType> workoutData = FXCollections.observableArrayList();
	
	private ObservableList<Weight> userWeightData = FXCollections.observableArrayList();
	
	private ObservableList<TrainingGoals> userGoalData = FXCollections.observableArrayList();
	private ObservableList<GoalType> goalTypeData = FXCollections.observableArrayList();
	

	public MainApp() {

	}

	/**
	 * The main entry point for all JavaFX applications.
	 *
	 * @params primaryStage - the primary stage for this application, onto which
	 *         the application scene can be set.
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("FitAndFun");

		initRootLayout();
		showLogin();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loading the LoginController and give the Controller access to the MainApp
	 *
	 * @see LoginController.java
	 */
	public void showLogin() {
		try {
			loadUserXML();
			loadActivityXML();
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Login.fxml"));
			AnchorPane userOverview = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(userOverview);
			// Give the controller access to the main app
			LoginController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loading the HomepageController and give the Controller access to the
	 * MainApp Shows the selected User from the LoginController
	 *
	 * @see HomepageController.java
	 */
	public void showHomepage() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Homepage.fxml"));
			AnchorPane userOverview = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(userOverview);
			// Give the controller access to the main app
			HomepageController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadUserXML();
		loadActivityXML();
		loadGoalTypeXML();
	}

	/**
	 * Loading the OverviewActivityController and give the Controller access to
	 * the MainApp
	 *
	 * @see OverviewActivityController.java
	 */
	public void showOverviewActivity() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/OverviewActivity.fxml"));
			AnchorPane overviewActivity = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(overviewActivity);
			// Give the controller access to the main app
			OverviewActivityController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loading the StatisticsController and give the Controller access to the
	 * MainApp
	 *
	 * @see StatisticsController.java
	 */
	public void showStatistics() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Statistics.fxml"));
			AnchorPane statistics = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(statistics);
			// Give the controller access to the main app
			StatisticsController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loading the TrainingGoalsController and give the Controller access to the
	 * MainApp
	 *
	 * @see TrainingGoalsController.java
	 */
	public void showTrainingGoals() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/TrainingGoals.fxml"));
			AnchorPane trainingGoals = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(trainingGoals);
			// Give the controller access to the main app
			TrainingGoalsController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void returnToTrainingGoals() {
		showTrainingGoals();
	}

	/**
	 * Loading the InputActivityController and give the Controller access to the
	 * MainApp
	 *
	 * @see InputActivityController.java
	 */
	public void showInputActivityController() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/InputActivity.fxml"));
			AnchorPane inputActivity = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(inputActivity);
			// Give the controller access to the main app
			InputActivityController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loading the WorkoutsController and give the Controller access to the
	 * MainApp
	 *
	 * @see WorkoutsController.java
	 */
	public void showWorkouts() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Workouts.fxml"));
			AnchorPane workouts = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(workouts);
			// Give the controller access to the main app
			WorkoutsController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loading the UserAdministrationController and give the Controller access
	 * to the MainApp
	 *
	 * @see UserAdministrationController.java
	 */
	public void showUserAdministration() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/UserAdministration.fxml"));
			AnchorPane userAdministration = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(userAdministration);
			// Give the controller access to the main app
			UserAdministrationController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loading the CreateNewWorkoutController and give the Controller access to
	 * the MainApp
	 *
	 * @see CreateNewWorkoutController.java
	 */
	public void showCreateNewWorkout() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/CreateNewWorkout.fxml"));
			AnchorPane createNewWorkout = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(createNewWorkout);
			// Give the controller access to the main app
			CreateNewWorkoutController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loading the InputWeightController and give the Controller access to
	 * the MainApp
	 *
	 * @see InputWeightController.java
	 */
	public void showWeightController() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/InputWeight.fxml"));
			AnchorPane inputWeight = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(inputWeight);
			// Give the controller access to the main app
			InputWeightController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loading the showInputTrainingGoalController and give the Controller access to
	 * the MainApp
	 *
	 * @see showInputTrainingGoalController.java
	 */
	public void showInputTrainingGoalController() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/InputTrainingGoal.fxml"));
			AnchorPane inputTrainingGoal = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(inputTrainingGoal);
			// Give the controller access to the main app
			InputTrainingGoalController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loading the showInputGoalTypeController and give the Controller access to
	 * the MainApp
	 *
	 * @see showInputGoalTypeController.java
	 */
	public void showInputGoalType() {
		try {
			// Load
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/InputGoalType.fxml"));
			AnchorPane inputGoalType = (AnchorPane) loader.load();
			// Set into the center of root layout
			rootLayout.setCenter(inputGoalType);
			// Give the controller access to the main app
			InputGoalTypeController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Loading all Users from the XML-File used to Login and in
	 * UserAdministration to add, delete and edit Users.
	 *
	 * @see UserAdministrationController.java
	 * @see LoginController.java
	 */
	private void loadUserXML() {
		File temp = new File(FILE_USERS);
		if (temp.exists()) {
			try {
				UserWrapper wrapper = XMLHelper.load(UserWrapper.class, FILE_USERS);
				userData.clear();
				userData.addAll(wrapper.getUsers());
			} catch (Exception e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Beim Laden der Benutzer ist ein Fehler aufgetreten!");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("XML File " + temp.getAbsolutePath() + " existiert nicht!");
			alert.showAndWait();
		}

	}

	/**
	 * Method to save the Users in the XML-File
	 */
	public void saveUserXml() {
		UserWrapper wrapper = new UserWrapper();
		wrapper.setUsers(userData);
		try {
			XMLHelper.save(wrapper, FILE_USERS);
		} catch (JAXBException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Beim Speichern der Benutzer ist ein Fehler aufgetreten!");
			alert.showAndWait();
		}
	}

	/**
	 * Loading all ActivityTypes from the XML-File used to create a new
	 * UserActivity and create TrainingGoals
	 *
	 * @see CreateNewTrainingGoalController.java
	 * @see InputActivity.java
	 */
	private void loadActivityXML() {

		File temp = new File(FILE_ACTIVITY);
		if (temp.exists()) {
			try {
				ActivityWrapper wrapper = XMLHelper.load(ActivityWrapper.class, FILE_ACTIVITY);
				activityData.clear();
				activityData.addAll(wrapper.getActivities());
			} catch (Exception e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Beim Laden der Aktivität ist ein Fehler aufgetreten!");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("XML File " + temp.getAbsolutePath() + " existiert nicht!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to save the ActivityTypes in the XML-File
	 */
	public void saveActivityXml() {
		ActivityWrapper wrapper = new ActivityWrapper();
		wrapper.setActivities(activityData);
		try {
			XMLHelper.save(wrapper, FILE_ACTIVITY);
		} catch (JAXBException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Beim Speichern der Aktivität ist ein Fehler aufgetreten!");
			alert.showAndWait();
		}
	}

	/**
	 * Loading all UserActivities from the XML-File used to save a new
	 * UserActivity.
	 *
	 * @see InputActivity.java
	 * @see StatisticsController.java
	 */
	private void loadUserActivityXML() {
		File temp = new File(FILE_USERACTIVITY);
		if (temp.exists()) {
			try {
				UserActivityWrapper wrapper = XMLHelper.load(UserActivityWrapper.class, FILE_USERACTIVITY);
				userActivityData.clear();
				userActivityData.addAll(wrapper.getUserActivities());
			} catch (Exception e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Beim Laden der Aktivität ist ein Fehler aufgetreten!");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("XML File " + temp.getAbsolutePath() + " existiert nicht!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to save the UserActivities in the XML-File
	 */
	public void saveUserActivityXml() {
		UserActivityWrapper wrapper = new UserActivityWrapper();
		wrapper.setUserActivities(userActivityData);
		try {
			XMLHelper.save(wrapper, FILE_USERACTIVITY);
		} catch (JAXBException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Beim Speichern der Aktivität ist ein Fehler aufgetreten!");
			alert.showAndWait();
		}
	}
	
	/**
	 * Loading all UserActivities from the XML-File used to save a new
	 * UserActivity.
	 *
	 * @see InputActivity.java
	 * @see StatisticsController.java
	 */
	private void loadWeightXML() {
		File temp = new File(FILE_WEIGHT);
		if (temp.exists()) {
			try {
				WeightWrapper wrapper = XMLHelper.load(WeightWrapper.class, FILE_WEIGHT);
				userWeightData.clear();
				userWeightData.addAll(wrapper.getWeight());
			} catch (Exception e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Beim Laden der Gewichts-XML ist ein Fehler aufgetreten!");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("XML File " + temp.getAbsolutePath() + " existiert nicht!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to save the UserActivities in the XML-File
	 */
	public void saveWeightXML() {
		WeightWrapper wrapper = new WeightWrapper();
		wrapper.setWeight(userWeightData);
		try {
			XMLHelper.save(wrapper, FILE_WEIGHT);
		} catch (JAXBException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Beim Speichern der Aktivität ist ein Fehler aufgetreten!");
			alert.showAndWait();
		}
	}
	
	/**
	 * Loading all UserActivities from the XML-File used to save a new
	 * UserActivity.
	 *
	 * @see InputActivity.java
	 * @see StatisticsController.java
	 */
	private void loadTrainingGoalsXML() {
		File temp = new File(FILE_USERGOALS);
		if (temp.exists()) {
			try {
				TrainingGoalsWrapper wrapper = XMLHelper.load(TrainingGoalsWrapper.class, FILE_USERGOALS);
				userGoalData.clear();
				userGoalData.addAll(wrapper.getGoals());
			} catch (Exception e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Beim Laden der Trainingsziele-XML ist ein Fehler aufgetreten!");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("XML File " + temp.getAbsolutePath() + " existiert nicht!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to save the UserActivities in the XML-File
	 */
	public void saveTrainingGoalsXML() {
		TrainingGoalsWrapper wrapper = new TrainingGoalsWrapper();
		wrapper.setGoals(userGoalData);
		try {
			XMLHelper.save(wrapper, FILE_USERGOALS);
		} catch (JAXBException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Beim Speichern der Aktivität ist ein Fehler aufgetreten!");
			alert.showAndWait();
		}
	}
	
	private void loadWorkoutsXML() {
		File temp = new File(FILE_WORKOUTS);
		if (temp.exists()) {
			try {
				WorkoutWrapper wrapper = XMLHelper.load(WorkoutWrapper.class, FILE_WORKOUTS);
				workoutData.clear();
				workoutData.addAll(wrapper.getWorkouts());
			} catch (Exception e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Beim Laden der Workouts ist ein Fehler aufgetreten!");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("XML File " + temp.getAbsolutePath() + " existiert nicht!");
			alert.showAndWait();
		}
	}

	public void saveWorkoutXml() {
		WorkoutWrapper wrapper = new WorkoutWrapper();
		wrapper.setWorkouts(workoutData);
		try {
			XMLHelper.save(wrapper, FILE_WORKOUTS);
		} catch (JAXBException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Beim Speichern des Workouts ist ein Fehler aufgetreten!");
			alert.showAndWait();
		}
	}
	
	/**
	 * Loading all UserActivities from the XML-File used to save a new
	 * UserActivity.
	 *
	 * @see InputActivity.java
	 * @see StatisticsController.java
	 */
	private void loadGoalTypeXML() {
		File temp = new File(FILE_GOALTYPES);
		if (temp.exists()) {
			try {
				GoalTypeWrapper wrapper = XMLHelper.load(GoalTypeWrapper.class, FILE_GOALTYPES);
				goalTypeData.clear();
				goalTypeData.addAll(wrapper.getGoalTypes());
			} catch (Exception e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Fehler");
				alert.setHeaderText(null);
				alert.setContentText("Beim Laden der GoalTypes ist ein Fehler aufgetreten!");
				alert.showAndWait();
			}
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("XML File " + temp.getAbsolutePath() + " existiert nicht!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to save the UserActivities in the XML-File
	 */
	public void saveGoalTypeXml() {
		GoalTypeWrapper wrapper = new GoalTypeWrapper();
		wrapper.setGoalTypes(goalTypeData);
		try {
			XMLHelper.save(wrapper, FILE_GOALTYPES);
		} catch (JAXBException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText(null);
			alert.setContentText("Beim Speichern der GoalTypes ist ein Fehler aufgetreten!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to set the activeUser selected at LoginController This Methods
	 * also sets the User-specific Filepath for the userActivities.xml and
	 * userTrainingsGoals.xml
	 *
	 * @param user
	 *            - User to set as active User
	 * @see LoginController.java
	 */
	public void setActiveUser(User user) {
		this.activeUser = user;
		FILE_USERACTIVITY = "XML\\" + activeUser.getUsername() + "\\UserActivities.xml";
		FILE_USERGOALS = "XML\\" + activeUser.getUsername() + "\\TrainingGoals.xml";
		FILE_WEIGHT = "XML\\" + activeUser.getUsername() + "\\UserWeight.xml";
		FILE_WORKOUTS = "XML\\" + activeUser.getUsername() + "\\UserWorkouts.xml";
		loadUserActivityXML();
		loadWeightXML();
		loadTrainingGoalsXML();
		loadWorkoutsXML();
	}

	/**
	 * Returns the activeUser which was selected at the Login
	 *
	 * @return activeUser
	 */
	public User getActiveUser() {
		return activeUser;
	}

	/**
	 * Returns the main stage
	 *
	 * @return primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * The main-App for launching the App
	 *
	 * @param args
	 *            Consoleparameter
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Returns the data as an ObservableList of Users
	 *
	 * @return userData
	 */
	public ObservableList<User> getUserData() {
		return userData;
	}

	/**
	 * Returns the data as an ObservableList of Activity for userActivitys
	 *
	 * @return userActivityData
	 */
	public ObservableList<Activity> getUserActivity() {
		return userActivityData;
	}
	
	public ObservableList<GoalType> getGoalType() {
		return goalTypeData;
	}
	
	public ObservableList<Weight> getUserWeight() {
		return userWeightData;
	}
	
	public ObservableList<TrainingGoals> getTrainingGoals() {
		return userGoalData;
	}

	/**
	 * Returns the data as an ObservableList of ActivityTypes
	 *
	 * @return activityData
	 */
	public ObservableList<ActivityType> getActivityData() {
		return activityData;
	}

	

	public ObservableList<WorkoutType> getWorkoutData() {
		return workoutData;
	}
	
	
}
