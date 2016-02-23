package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.util.Callback;
import javafx.util.StringConverter;
import fitandfun.MainApp;
import fitandfun.model.User;
import fitandfun.model.WorkoutType;

/**
*
* @author Marion Lackner, Sabrina Füreder, Kerstin Sachsenhofer
* 
* @version 1.0 
*/

public class WorkoutsDoneController {

	/**
	 * Reference to the MainApplication
	 */
	private MainApp mainApp;

	/**
	 * Reference to the activeUser from mainApp
	 */
	@SuppressWarnings("unused")
	private User activeUser;

	/**
	 * FXML Variables to link
	 */
	@FXML
	private ComboBox<WorkoutType> actName;
	
	@FXML
	private GridPane gridPaneEdit;
	@FXML
	private Label activeUserLabel;
	@FXML
	private Label lblCompletedCounts;	
	@FXML
	private Label lblCountsToGo;

	@FXML
	private Label lblExercise1;
	@FXML
	private Label lblExercise2;
	@FXML
	private Label lblExercise3;
	@FXML
	private Label lblExercise4;
	@FXML
	private Label lblExercise5;
	@FXML
	private Label lblExercise6;
	@FXML
	private Label lblRepeat1;
	@FXML
	private Label lblRepeat2;
	@FXML
	private Label lblRepeat3;
	@FXML
	private Label lblRepeat4;
	@FXML
	private Label lblRepeat5;
	@FXML
	private Label lblRepeat6;
	
	@FXML
	private Button buttonWorkoutDone;
		
	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public WorkoutsDoneController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 *
	 * Binding all Variables to save/load in the XML-File
	 */
	@FXML
	private void initialize() {
		actName.setCellFactory(new Callback<ListView<WorkoutType>, ListCell<WorkoutType>>() {
			@Override
			public ListCell<WorkoutType> call(ListView<WorkoutType> param) {
				return new ListCell<WorkoutType>() {
					@Override
					protected void updateItem(WorkoutType item, boolean empty) {
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
		
		buttonWorkoutDone.setVisible(false);
		gridPaneEdit.setVisible(false);

		actName.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showWorkoutDone(oldValue, newValue));
		
		actName.setConverter(new StringConverter<WorkoutType>() {
			@Override
			public String toString(WorkoutType w) {
				if (w == null) {
					return null;
				} else {
					return w.getName();
				}
			}

			@Override
			public WorkoutType fromString(String name) {
				return null;
			}
		});
	}

	/**
	 * show Workout Details when selected in the ComboBox
	 * @param oldWorkout
	 * @param newWorkout
	 */
	private void showWorkoutDone(WorkoutType oldWorkout, WorkoutType newWorkout) {
			if (oldWorkout != null) {
				lblExercise1.textProperty().unbindBidirectional(oldWorkout.getExercise1Property());
				lblExercise2.textProperty().unbindBidirectional(oldWorkout.getExercise2Property());
				lblExercise3.textProperty().unbindBidirectional(oldWorkout.getExercise3Property());
				lblExercise4.textProperty().unbindBidirectional(oldWorkout.getExercise4Property());
				lblExercise5.textProperty().unbindBidirectional(oldWorkout.getExercise5Property());
				lblExercise6.textProperty().unbindBidirectional(oldWorkout.getExercise6Property());

				lblRepeat1.textProperty().unbindBidirectional(oldWorkout.getRepeat1Property());
				lblRepeat2.textProperty().unbindBidirectional(oldWorkout.getRepeat2Property());
				lblRepeat3.textProperty().unbindBidirectional(oldWorkout.getRepeat3Property());
				lblRepeat4.textProperty().unbindBidirectional(oldWorkout.getRepeat4Property());
				lblRepeat5.textProperty().unbindBidirectional(oldWorkout.getRepeat5Property());
				lblRepeat6.textProperty().unbindBidirectional(oldWorkout.getRepeat6Property());

				lblCountsToGo.textProperty().unbindBidirectional(oldWorkout.getCountsToGoProperty());
				
				buttonWorkoutDone.setVisible(true);
				gridPaneEdit.setVisible(true);
			}

			lblExercise1.setText("");
			lblExercise2.setText("");
			lblExercise3.setText("");
			lblExercise4.setText("");
			lblExercise5.setText("");
			lblExercise6.setText("");

			lblRepeat1.setText("");
			lblRepeat2.setText("");
			lblRepeat3.setText("");
			lblRepeat4.setText("");
			lblRepeat5.setText("");
			lblRepeat6.setText("");

			lblCountsToGo.setText("");
			lblCompletedCounts.setText("0");
						
			if (newWorkout != null) {
				lblExercise1.textProperty().bindBidirectional(newWorkout.getExercise1Property());
				lblExercise2.textProperty().bindBidirectional(newWorkout.getExercise2Property());
				lblExercise3.textProperty().bindBidirectional(newWorkout.getExercise3Property());
				lblExercise4.textProperty().bindBidirectional(newWorkout.getExercise4Property());
				lblExercise5.textProperty().bindBidirectional(newWorkout.getExercise5Property());
				lblExercise6.textProperty().bindBidirectional(newWorkout.getExercise6Property());

				lblRepeat1.textProperty().bindBidirectional(newWorkout.getRepeat1Property());
				lblRepeat2.textProperty().bindBidirectional(newWorkout.getRepeat2Property());
				lblRepeat3.textProperty().bindBidirectional(newWorkout.getRepeat3Property());
				lblRepeat4.textProperty().bindBidirectional(newWorkout.getRepeat4Property());
				lblRepeat5.textProperty().bindBidirectional(newWorkout.getRepeat5Property());
				lblRepeat6.textProperty().bindBidirectional(newWorkout.getRepeat6Property());

				lblCountsToGo.textProperty().bindBidirectional(newWorkout.getCountsToGoProperty());
				
				buttonWorkoutDone.setVisible(true);
				gridPaneEdit.setVisible(true);
			}
	}

	@FXML
	private void reset() {
		// TODO in Version 2.0
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		actName.getItems().addAll(mainApp.getWorkoutData());
        activeUserLabel.setText(mainApp.getActiveUser().getUsername());
		activeUser = mainApp.getActiveUser();
	}

	/**
	 * Method to navigate to the Homepage in FXML
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

	/**
	 * Method to navigate to the WorkoutsDone in FXML
	 */
	@FXML
	private void showWorkoutsDoneController() {
		mainApp.showWorkoutsDoneController();
	}
	
	/**
	 * Method to raise the counts to complete a workout
	 */
	@FXML
	private void raiseCompletedCounts() {
		int count = Integer.parseInt(lblCompletedCounts.getText());
		count = count + 1;
		lblCompletedCounts.setText(String.valueOf(count));
		
		if (((Integer.parseInt(lblCompletedCounts.getText())) % 3 == 0) && 
				(Integer.parseInt(lblCompletedCounts.getText()) != Integer.parseInt(lblCountsToGo.getText()))) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Pause einlegen");
			alert.setHeaderText(null);
			alert.setContentText("Mach' mal Pause! :-)");
			alert.showAndWait();
		}
		
		if (Integer.parseInt(lblCompletedCounts.getText()) == (Integer.parseInt(lblCountsToGo.getText()))) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Workout erledigt");
			alert.setHeaderText(null);
			alert.setContentText("Herzlichen Glückwunsch! Sie haben Ihr Workout erledigt.");
			alert.showAndWait();
						
			showWorkoutsDoneController();
		}
	}
}