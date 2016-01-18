package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.util.Optional;

import fitandfun.MainApp;
import fitandfun.model.WorkoutType;

/**
 * WorkoutsController
 * 
 * @author Sabrina, Marion, Kerstin
 * @version 0.1
 * 
 */
public class WorkoutsController {

	private MainApp mainApp;

	@FXML
	private ListView<WorkoutType> workoutList;
	@FXML
	private GridPane gridPaneEdit;

	@FXML
	private TextField actName;

	@FXML
	private TextField txtExercise1;
	@FXML
	private TextField txtExercise2;
	@FXML
	private TextField txtExercise3;
	@FXML
	private TextField txtExercise4;
	@FXML
	private TextField txtExercise5;
	@FXML
	private TextField txtExercise6;

	@FXML
	private TextField txtRepeat1;
	@FXML
	private TextField txtRepeat2;
	@FXML
	private TextField txtRepeat3;
	@FXML
	private TextField txtRepeat4;
	@FXML
	private TextField txtRepeat5;
	@FXML
	private TextField txtRepeat6;

	@FXML
	private Label lblCompletedCounts;

	@FXML
	private TextField txtCountsToGo;

	@FXML
	private Button buttonDone;

	@FXML
	private Button buttonSave;
	@FXML
	private Button buttonDelete;
	@FXML
	private Button plusButton;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public WorkoutsController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */

	@FXML
	private void initialize() {
		showWorkout(null, null);

		workoutList.setCellFactory(new Callback<ListView<WorkoutType>, ListCell<WorkoutType>>() {
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
		workoutList.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showWorkout(oldValue, newValue));
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		workoutList.setItems(mainApp.getWorkoutData());
	}

	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

	@FXML
	private void createNewWorkout() {
		WorkoutType w = new WorkoutType("Neues Workout");
		mainApp.getWorkoutData().add(w);
		workoutList.getSelectionModel().select(w);
		//buttonSave.setVisible(true);
	}

	@FXML
	private void saveWorkout() {
		mainApp.saveWorkoutXml();

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Workout erstellt");
		alert.setHeaderText(null);
		alert.setContentText("Workout wurde angelegt.");
		alert.showAndWait();
	}

	@FXML
	private void deleteWorkout() {
		WorkoutType w = workoutList.getSelectionModel().getSelectedItem();

		if (w != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Ausgewähltes Workout löschen");
			alert.setHeaderText("Wollen Sie das ausgeählte Workout " + w.getName() + " wirklich löschen?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainApp.getWorkoutData().remove(w);
				mainApp.saveWorkoutXml();
			}
		}
	}

	private void showWorkout(WorkoutType oldWorkout, WorkoutType newWorkout) {
		if (oldWorkout != null) {
			actName.textProperty().unbindBidirectional(oldWorkout.nameProperty());

			txtExercise1.textProperty().unbindBidirectional(oldWorkout.getExercise1Property());
			txtExercise2.textProperty().unbindBidirectional(oldWorkout.getExercise2Property());
			txtExercise3.textProperty().unbindBidirectional(oldWorkout.getExercise3Property());
			txtExercise4.textProperty().unbindBidirectional(oldWorkout.getExercise4Property());
			txtExercise5.textProperty().unbindBidirectional(oldWorkout.getExercise5Property());
			txtExercise6.textProperty().unbindBidirectional(oldWorkout.getExercise6Property());

			txtRepeat1.textProperty().unbindBidirectional(oldWorkout.getRepeat1Property());
			txtRepeat2.textProperty().unbindBidirectional(oldWorkout.getRepeat2Property());
			txtRepeat3.textProperty().unbindBidirectional(oldWorkout.getRepeat3Property());
			txtRepeat4.textProperty().unbindBidirectional(oldWorkout.getRepeat4Property());
			txtRepeat5.textProperty().unbindBidirectional(oldWorkout.getRepeat5Property());
			txtRepeat6.textProperty().unbindBidirectional(oldWorkout.getRepeat6Property());

			txtCountsToGo.textProperty().unbindBidirectional(oldWorkout.getCountsToGoProperty());
			lblCompletedCounts.textProperty().unbindBidirectional(oldWorkout.getCompletedCountsProperty());
		}

		actName.setText("");

		txtExercise1.setText("");
		txtExercise2.setText("");
		txtExercise3.setText("");
		txtExercise4.setText("");
		txtExercise5.setText("");
		txtExercise6.setText("");

		txtRepeat1.setText("");
		txtRepeat2.setText("");
		txtRepeat3.setText("");
		txtRepeat4.setText("");
		txtRepeat5.setText("");
		txtRepeat6.setText("");

		txtCountsToGo.setText("");

		lblCompletedCounts.setText("0");

		if (newWorkout != null) {
			gridPaneEdit.setDisable(false);

			actName.textProperty().bindBidirectional(newWorkout.nameProperty());

			txtExercise1.textProperty().bindBidirectional(newWorkout.getExercise1Property());
			txtExercise2.textProperty().bindBidirectional(newWorkout.getExercise2Property());
			txtExercise3.textProperty().bindBidirectional(newWorkout.getExercise3Property());
			txtExercise4.textProperty().bindBidirectional(newWorkout.getExercise4Property());
			txtExercise5.textProperty().bindBidirectional(newWorkout.getExercise5Property());
			txtExercise6.textProperty().bindBidirectional(newWorkout.getExercise6Property());

			txtRepeat1.textProperty().bindBidirectional(newWorkout.getRepeat1Property());
			txtRepeat2.textProperty().bindBidirectional(newWorkout.getRepeat2Property());
			txtRepeat3.textProperty().bindBidirectional(newWorkout.getRepeat3Property());
			txtRepeat4.textProperty().bindBidirectional(newWorkout.getRepeat4Property());
			txtRepeat5.textProperty().bindBidirectional(newWorkout.getRepeat5Property());
			txtRepeat6.textProperty().bindBidirectional(newWorkout.getRepeat6Property());

			txtCountsToGo.textProperty().bindBidirectional(newWorkout.getCountsToGoProperty());

			lblCompletedCounts.textProperty().bindBidirectional(newWorkout.getCompletedCountsProperty());
		} else {
			gridPaneEdit.setDisable(true);
		}
	}

	public void clickButtonDone() {
		int count = Integer.parseInt(lblCompletedCounts.getText());
		count = count + 1;
		lblCompletedCounts.setText(String.valueOf(count));

		if (Integer.parseInt(lblCompletedCounts.getText()) == (Integer.parseInt(txtCountsToGo.getText()))) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Workout erledigt");
			alert.setHeaderText(null);
			alert.setContentText("Herzlichen Glückwunsch! Sie haben Ihr Workout erledigt.");
			alert.showAndWait();
			showHomepage();
		}
	}
}