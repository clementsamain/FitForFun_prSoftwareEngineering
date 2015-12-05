package fitandfun.view;

import javafx.fxml.FXML;
import fitandfun.MainApp;

public class HomepageController {

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public HomepageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }
    
    @FXML
    private void showOverviewActivity() {
    	mainApp.showOverviewActivity();
    }
    
    @FXML
    private void showStatistics() {
    	mainApp.showStatistics();
    }
    
    @FXML
    private void showTrainingGoals() {
    	mainApp.showTrainingGoals();
    }
    
    @FXML
    private void showWorkouts() {
    	mainApp.showWorkouts();
    }
    
    @FXML
    private void showUserAdministration() {
    	mainApp.showUserAdministration();
    }
    
    @FXML
    private void showInputActivityController() {
    	mainApp.showInputActivityController();
    }
}
