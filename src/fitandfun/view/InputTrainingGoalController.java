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
    private ComboBox<GoalType> goalType;
	@FXML
	private DatePicker goalDate;
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
    	/*goalType.setCellFactory(new Callback<ListView<GoalType>, ListCell<GoalType>>() {
			@Override
			public ListCell<GoalType> call(ListView<GoalType> param) {
				return new ListCell<GoalType>() {
					@Override
					protected void updateItem(GoalType item, boolean empty) {
						super.updateItem(item, empty);
						this.textProperty().unbind();
						this.setText("");
						if (item != null) {
							this.textProperty().bind(item.getDeclaringClass().getEnumConstants().toString());
						}
					}
				};
			}
		});*/
    	
    	goalDate.valueProperty().bindBidirectional(tg.dateProperty());
		goalValue.textProperty().bindBidirectional(tg.goalValueProperty(), new NumberStringConverter());
		
		/*switch(tg.getType())
		{
		case KCAL:
			goalUnit.setText(" kcal");
			break;
		case WEIGHT:
			goalUnit.setText(" kg");
			break;
		case STEPS:
			goalUnit.setText(" Schritte");
			break;
		case RUNDIST:
			goalUnit.setText(" km");
			break;
		case WALKDIST:
			goalUnit.setText(" km");
			break;
		case BIKEDIST:
			goalUnit.setText(" km");
			break;
		case SWIMDIST:
			goalUnit.setText(" m");
			break;
		case HIKEDIST:
			goalUnit.setText(" km");
			break;
		}*/

    }
    
    @FXML
	private void saveTrainingGoal() {
    	if(goalType != null && goalDate != null && !goalValue.equals("") && goalValue != null)
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
		/*goalType.setValue(null);
		goalDate.setValue(null);
		goalValue.setText("");
		goalUnit.setText("");*/
    	showTrainingGoalsController();
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
    private void showTrainingGoalsController() {
    	mainApp.returnToTrainingGoals();
    }
}
