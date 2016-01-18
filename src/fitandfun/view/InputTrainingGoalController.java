package fitandfun.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import fitandfun.model.ActivityType;
import fitandfun.model.GoalType;
import fitandfun.model.TrainingGoals;
import fitandfun.model.User;
import fitandfun.model.Weight;

public class InputTrainingGoalController {

    // Reference to the main application.
    private MainApp mainApp;
    
    private User activeUser;
    
    @FXML
    private TextField goalName;
    @FXML
    private ComboBox<GoalType> goalType;
	@FXML
	private DatePicker goalDate;
	@FXML
	private DatePicker goalStartDate;
	@FXML
	private TextField goalValue;
	@FXML
	private Label goalUnit;

	private TrainingGoals tg = new TrainingGoals();
	

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public InputTrainingGoalController() {
    	
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	goalType.setCellFactory(new Callback<ListView<GoalType>, ListCell<GoalType>>() {
			@Override
			public ListCell<GoalType> call(ListView<GoalType> param) {
				return new ListCell<GoalType>() {
					@Override
					protected void updateItem(GoalType item, boolean empty) {
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
    	goalType.setConverter(new StringConverter<GoalType>() {
			@Override
			public String toString(GoalType at) {
				if (at == null) {
					return null;
				} else {
					return at.getName();
				}
			}

			@Override
			public GoalType fromString(String name) {
				return null;
			}
		});
    	
    	goalType.valueProperty().bindBidirectional(tg.goalTypeProperty());
    	
    	goalDate.valueProperty().bindBidirectional(tg.dateProperty());
    	goalStartDate.valueProperty().bindBidirectional(tg.startProperty());
		goalValue.textProperty().bindBidirectional(tg.goalValueProperty(), new NumberStringConverter());
		goalName.textProperty().bindBidirectional(tg.nameProperty());
		
		goalType.valueProperty().addListener(new ChangeListener<GoalType>() {

			@Override
			public void changed(ObservableValue<? extends GoalType> observable, GoalType oldValue, GoalType newValue) {
				if(newValue != null)
				{
					goalUnit.setText(newValue.getActTypeParam().getParamUnit());
				}else
					{
						goalUnit.setText("");
					}
			}
		});
    }
    
    @FXML
	private void saveTrainingGoal() {
    	if(tg.getName()!= null && tg.getType() != null && tg.getDate() != null && tg.getStartDate() != null && tg.getGoalValue() != 0 && tg.getStartDate().isBefore(tg.getDate()))
    	{
    		mainApp.getTrainingGoals().add(tg);
    		mainApp.saveTrainingGoalsXML();
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Trainningsziel eingetragen");
    		alert.setHeaderText(null);
    		alert.setContentText("Das Trainingsziel wurde eingetragen!");

    		alert.showAndWait();

    		showHomepage();
    	}else
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Fehler");
    		alert.setHeaderText(null);
    		alert.setContentText("Bitte wähle ein Zieltyp und Datum aus und trage einen Zielwert ein!");

    		alert.showAndWait();
    	}
		
	}
    
    @FXML
	private void reset() {
    	showTrainingGoalsController();
	}

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        goalType.getItems().addAll(mainApp.getGoalType());
    }
    
    @FXML
    private void showHomepage() {
    	mainApp.showHomepage();
    }
    
    @FXML
    private void showTrainingGoalsController() {
    	mainApp.showTrainingGoals();
    }
    
    @FXML
    private void showInputGoalTypeController() {
    	mainApp.showInputGoalType();
    }
}
