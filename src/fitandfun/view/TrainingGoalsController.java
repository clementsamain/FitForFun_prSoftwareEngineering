package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import fitandfun.MainApp;

public class TrainingGoalsController {

	// Reference to the main application.
	private MainApp mainApp;
	
	@FXML
	private PieChart pie;
	
	@FXML
	private LineChart line;

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
		pie.setVisible(false);
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
