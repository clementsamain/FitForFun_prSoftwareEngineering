package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.io.File;
import java.util.Optional;

import fitandfun.MainApp;
import fitandfun.Sex;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;
import fitandfun.model.User;


public class OverviewActivityController {

    // Reference to the main application.
    private MainApp mainApp;
    
    @FXML
    private ListView<ActivityType> activityList;
    @FXML
    private GridPane gridPaneEdit;
    @FXML
    private TextField actName;
    @FXML
    private CheckBox date;
    @FXML
    private CheckBox startTime;
    @FXML
    private CheckBox endTime;
    @FXML
    private CheckBox distance;
    @FXML
    private CheckBox hmeter;
    @FXML
    private Button saveAct;

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
    	showActivity(null, null);
    	
    	activityList.setCellFactory(new Callback<ListView<ActivityType>, ListCell<ActivityType>>(){
    		@Override
    		public ListCell<ActivityType> call(ListView<ActivityType> param) {
    			return new ListCell<ActivityType>() {
    				@Override
    				protected void updateItem(ActivityType item, boolean empty) {
    					super.updateItem(item, empty);
    					this.textProperty().unbind();
    					this.setText("");
    					if (item != null) {
    						this.textProperty().bind(item.nameProperty());
    					}
    				}
    			};
    		}
    	});
    	activityList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showActivity(oldValue, newValue));
    	saveAct.setVisible(false);
    }

    @FXML
    private void createNewActivity() {
    	ActivityType a = new ActivityType("Neue Aktivität");
    	mainApp.getActivityData().add(a);
    	activityList.getSelectionModel().select(a);
    	saveAct.setVisible(true);
    	date.setDisable(false);
		startTime.setDisable(false);
		endTime.setDisable(false);
		distance.setDisable(false);
		hmeter.setDisable(false);
    }
    
    @FXML
    private void SaveActivity()
    {
    	mainApp.saveActivityXml();
    	saveAct.setVisible(false);
    	date.setDisable(true);
		startTime.setDisable(true);
		endTime.setDisable(true);
		distance.setDisable(true);
		hmeter.setDisable(true);
    }
    
    private void showActivity(ActivityType oldAT, ActivityType newAT)
    {
    	if(oldAT != null)
    	{
	    	actName.textProperty().unbindBidirectional(oldAT.nameProperty());
    		date.selectedProperty().unbindBidirectional(oldAT.dateProperty());
    		startTime.selectedProperty().unbindBidirectional(oldAT.startProperty());
    		endTime.selectedProperty().unbindBidirectional(oldAT.endProperty());
    		distance.selectedProperty().unbindBidirectional(oldAT.distanceProperty());
    		hmeter.selectedProperty().unbindBidirectional(oldAT.hmeterProperty());
    	}
    	
    	actName.setText("");
		date.setSelected(true);
		startTime.setSelected(true);
		endTime.setSelected(true);
		distance.setSelected(false);
		hmeter.setSelected(false);
		
		if (newAT != null)
    	{
    		gridPaneEdit.setDisable(false);
    		actName.textProperty().bindBidirectional(newAT.nameProperty());
    		date.selectedProperty().bindBidirectional(newAT.dateProperty());
    		startTime.selectedProperty().bindBidirectional(newAT.startProperty());
    		endTime.selectedProperty().bindBidirectional(newAT.endProperty());
    		distance.selectedProperty().bindBidirectional(newAT.distanceProperty());
    		hmeter.selectedProperty().bindBidirectional(newAT.hmeterProperty());
    	}
    	else
    	{
    		gridPaneEdit.setDisable(true);
    	}
		//actName.setDisable(true);
		date.setDisable(true);
		startTime.setDisable(true);
		endTime.setDisable(true);
		distance.setDisable(true);
		hmeter.setDisable(true);
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
    	this.mainApp = mainApp;
        activityList.setItems(mainApp.getActivityData());
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
