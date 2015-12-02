package fitandfun;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import fitandfun.model.*;
import fitandfun.view.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainApp extends Application {

	 private Stage primaryStage;
	 private BorderPane rootLayout;
	/**
     * The data as an observable list of Users.
     */
    private ObservableList<User> userData = FXCollections.observableArrayList();


    public MainApp()
    {
    	userData.add(new User("Viki", "w"));
    	userData.add(new User("Stefan", "m"));
    	userData.add(new User("Simone", "w"));
    	
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("FitAndFun");

        initRootLayout();

        showHomepage();
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
     * Shows the person overview inside the root layout.
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
    }
    
    /**
     * Shows the person overview inside the root layout.
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
    
    public void showCreateNewActivity() {
        try {
            // Load
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CreateNewActivity.fxml"));
            AnchorPane createNewActivity = (AnchorPane) loader.load();
            // Set into the center of root layout
            rootLayout.setCenter(createNewActivity);            
            // Give the controller access to the main app
            CreateNewActivityController controller = loader.getController();
            controller.setMainApp(this);            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showCreateNewTrainingGoal() {
        try {
            // Load
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CreateNewTrainingGoal.fxml"));
            AnchorPane createNewTrainingGoal = (AnchorPane) loader.load();
            // Set into the center of root layout
            rootLayout.setCenter(createNewTrainingGoal);            
            // Give the controller access to the main app
            CreateNewTrainingGoalController controller = loader.getController();
            controller.setMainApp(this);            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showCreateNewUser() {
        try {
            // Load
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CreateNewUser.fxml"));
            AnchorPane createNewUser = (AnchorPane) loader.load();
            // Set into the center of root layout
            rootLayout.setCenter(createNewUser);            
            // Give the controller access to the main app
            CreateNewUserController controller = loader.getController();
            controller.setMainApp(this);            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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
     * Returns the data as an observable list of Users. 
     * @return
     */
    public ObservableList<User> getUserData() {
        return userData;
    }
    
	/**
	 * Load user data from XML file.
	 * The current user data will be replaced
	 */
	public void loadUserData(File file)
	{
		try 
		{
			JAXBContext context = JAXBContext.newInstance(UserWrapper.class);
			Unmarshaller um = context.createUnmarshaller();
			
			UserWrapper wrapper = (UserWrapper) um.unmarshal(file);
			
			userData.clear();
			userData.addAll(wrapper.getUsers());
			
			//Save the file path to the registery
			setUserFilePath(file);
		}catch(Exception e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());
		
			alert.showAndWait();
		}
		
	}
	
	/**
	 * Saves the current user data to the XML File
	 */
	public void saveUserData(File file)
	{
		try
		{
			JAXBContext context = JAXBContext.newInstance(UserWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//Wrapping our user data
			UserWrapper wrapper = new UserWrapper();
			wrapper.setUsers(userData);
			
			//Marshalling and saving XML to the file
			m.marshal(wrapper, file);
			
			//Save the file path to the registery
			setUserFilePath(file);
		}catch(Exception e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());
			
			alert.showAndWait();
		}
	}
	
	private void setUserFilePath(File file) {
		// TODO Auto-generated method stub
		
	}

	
	 /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}

	
}
