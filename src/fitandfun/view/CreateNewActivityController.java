/**
 * LÖSCHEN WIRD NICHT MEHR BENÖTIGT!!
 */

package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import fitandfun.MainApp;
import fitandfun.model.ActivityType;

public class CreateNewActivityController {

    // Reference to the main application.
    private MainApp mainApp;
    
    @FXML
    private Button importGpx;
    @FXML
    private ComboBox<ActivityType> actType;
    @FXML
    private TextField startTime;
    @FXML
    private TextField endTime;
    @FXML
    private TextField distance;
    @FXML
    private TextField hMeter;
    @FXML
    private Label duration;
    @FXML
    private Label avgSpeed;
    @FXML
    private Label caloriesUsed;
    @FXML
    private Button abort;
    @FXML
    private Button save;
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CreateNewActivityController() {
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
    private void showHomepage() {
    	mainApp.showHomepage();
    }
}
