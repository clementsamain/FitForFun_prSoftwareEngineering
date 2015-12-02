package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import fitandfun.MainApp;

public class OverviewActivityController {

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public OverviewActivityController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }
    
    @FXML
    private void activityClicked()
    {
    	
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
    private void showHomepage() {
    	mainApp.showHomepage();
    }
    
    @FXML
    private void showCreateNewActivity() {
    	mainApp.showCreateNewActivity();
    }
}
