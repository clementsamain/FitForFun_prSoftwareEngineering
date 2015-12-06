package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import fitandfun.MainApp;
import fitandfun.model.ActivityType;
import fitandfun.model.User;

public class InputActivityController {

    // Reference to the main application.
    private MainApp mainApp;

    @FXML
    private ComboBox<ActivityType> actName;
    @FXML
    private DatePicker date;
    @FXML
    private TextField start;
    @FXML
    private TextField end;
    @FXML
    private TextField distance;
    @FXML
    private TextField hmeter;
    @FXML
    private Label duration;
    @FXML
    private Label avgspeed;
    @FXML
    private Label calories;
    @FXML
    private ListView<ActivityType> activityList;
    
    
    
    
    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public InputActivityController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() 
    {
    	//TODO
    }

    @FXML
    private void saveActivity()
    {
    	//TODO
    }
    
    @FXML
    private void reset()
    {
    	//TODO
    }
    
     @FXML
     private void importActivit()
     {
    	 //TODO
     }
     
    private void updateDuration()
    {
    	//TODO
    }
    
    private void updateAVGSpeed()
    {
    	//TODO
    }
    
    private void updateCalories()
    {
    	//TODO
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
    private void showInputActivityController() {
    	mainApp.showInputActivityController();
    }
}

