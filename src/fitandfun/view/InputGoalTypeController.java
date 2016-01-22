package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import fitandfun.MainApp;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;
import fitandfun.model.ActivityTypeParameter;
import fitandfun.model.GoalType;
import fitandfun.model.TrainingGoals;
import fitandfun.model.User;
import fitandfun.model.Weight;

/**
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
public class InputGoalTypeController {

	/**
	 * Reference to the main Application
	 */
    private MainApp mainApp;
    
    /**
     * Reference to the activeUser from main Application
     */
    private User activeUser;
    
    /**
     * Reference to the goalType
     */
  	private GoalType goalType = new GoalType();
  	
  	/*
	 * FXML Variables to link
	 */
    @FXML
    private TextField goalName;
    
	@FXML
	private ComboBox<ActivityType> actName;
	
	@FXML
	private ComboBox<ActivityTypeParameter> activityParam;
	
	@FXML
	private Label activeUserLabel;
	
	/**
	 * Constructor
	 */
    public InputGoalTypeController() {
    	
    }

    /**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 * 
	 * Binding all Variables to save/load in the XML-File
	 */
    @FXML
    private void initialize() {
    	actName.setCellFactory(new Callback<ListView<ActivityType>, ListCell<ActivityType>>() {
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
		actName.setConverter(new StringConverter<ActivityType>() {
			@Override
			public String toString(ActivityType at) {
				if (at == null) {
					return null;
				} else {
					return at.getName();
				}
			}

			@Override
			public ActivityType fromString(String name) {
				return null;
			}
		});
		
		activityParam.setCellFactory(new Callback<ListView<ActivityTypeParameter>, ListCell<ActivityTypeParameter>>() {
			@Override
			public ListCell<ActivityTypeParameter> call(ListView<ActivityTypeParameter> param) {
				return new ListCell<ActivityTypeParameter>() {
					@Override
					protected void updateItem(ActivityTypeParameter item, boolean empty) {
						super.updateItem(item, empty);
						if (item != null) {
							this.setText(item.getParamName());
						}
					}
				};
			}
		});
		activityParam.setConverter(new StringConverter<ActivityTypeParameter>() {
			@Override
			public String toString(ActivityTypeParameter at) {
				if (at == null) {
					return null;
				} else {
					return at.getParamName();
				}
			}

			@Override
			public ActivityTypeParameter fromString(String name) {
				return null;
			}
		});

		actName.valueProperty().bindBidirectional(goalType.actTypeProperty());
		activityParam.valueProperty().bindBidirectional(goalType.actTypeParamProperty());
		goalName.textProperty().bindBidirectional(goalType.nameProperty());

    }
    
    /**
	 * Method used in FXML to save the GoalType and return to the InputTrainingGoalController()
	 */
    @FXML
	private void saveGoalType() {
    	
    	if(goalType.getName().equals(""))
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("GoalType-Name eintragen!");
    		alert.setHeaderText(null);
    		alert.setContentText("Bitte gib einen Namen für den GoalType ein!");

    		alert.showAndWait();
    	}else if(goalType.getActType() == null)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("GoalType-Aktivität auswählen!");
    		alert.setHeaderText(null);
    		alert.setContentText("Bitte wähle eine Aktivität aus!");

    		alert.showAndWait();
    	}else if(goalType.getActTypeParam() == null)
    	{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("GoalType-Parameter auswählen!");
    		alert.setHeaderText(null);
    		alert.setContentText("Bitte wähle einen Parameter aus!");

    		alert.showAndWait();
    	}else
    	{
    		mainApp.getGoalType().add(goalType);
    		mainApp.saveGoalTypeXml();

    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("GoalType eingetragen");
    		alert.setHeaderText(null);
    		alert.setContentText("Der GoalType wurde eingetragen!");

    		alert.showAndWait();

    		mainApp.showInputTrainingGoalController();
    	}
	}
    
    /**
	 * Method to return to the InputTrainingGoalController when "Abbrechen"-Button clicked in FXML
	 */
    @FXML
	private void reset() {
    	mainApp.showInputTrainingGoalController();
	}

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        actName.getItems().addAll(mainApp.getActivityData());
        activityParam.getItems().add(new ActivityTypeParameter("Dauer", "hh:mm"));
        activityParam.getItems().add(new ActivityTypeParameter("Distanz", "km"));
        activityParam.getItems().add(new ActivityTypeParameter("Verbrauchte kcal", "kcal"));
        activityParam.getItems().add(new ActivityTypeParameter("Höhenmeter", "m"));
        activityParam.getItems().add(new ActivityTypeParameter("Durchschnittsgeschwindigkeit", "km/h"));
        
		activeUser = mainApp.getActiveUser();
		activeUserLabel.setText(activeUser.getUsername());
    }
    
    /**
	 * Method to navigate to the Homepage in FXML
	 */
    @FXML
    private void showHomepage() {
    	mainApp.showHomepage();
    }
}
