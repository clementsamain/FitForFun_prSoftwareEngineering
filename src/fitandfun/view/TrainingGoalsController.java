package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import fitandfun.MainApp;
import fitandfun.model.TrainingGoals;

public class TrainingGoalsController {

	// Reference to the main application.
	private MainApp mainApp;
	
	@FXML
	private PieChart pie;
	
	@FXML
	private LineChart line;
	
	@FXML
	private ComboBox<TrainingGoals> trainingGoals;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public TrainingGoalsController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		pie.setVisible(false);
		line.setVisible(false);
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
	private void showInputTrainingGoal() {
		mainApp.showInputTrainingGoalController();
	}
}
