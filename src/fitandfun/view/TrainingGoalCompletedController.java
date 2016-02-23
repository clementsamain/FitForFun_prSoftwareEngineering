package fitandfun.view;

import javafx.fxml.FXML;
import fitandfun.MainApp;

/**
 * 
 * @author Viktoria Jechsmayr
 * @version 1.0
 *
 */
public class TrainingGoalCompletedController {

	/**
	 * Reference to the main Application
	 */
	private MainApp mainApp;


	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public TrainingGoalCompletedController() {
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

	/**
	 * Method to navigate to the Homepage in FXML
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

	/**
	 * Method to navigate to the InputTrainingGoal in FXML
	 */
	@FXML
	private void showInputTrainingGoal() {
		mainApp.showInputTrainingGoalController();
	}
}
