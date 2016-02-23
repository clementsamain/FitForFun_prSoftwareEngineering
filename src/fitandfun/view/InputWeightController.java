package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.util.converter.NumberStringConverter;
import fitandfun.MainApp;
import fitandfun.model.User;
import fitandfun.model.Weight;

/**
 *
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
public class InputWeightController {

	/**
	 * Reference to the main Application
	 */
	private MainApp mainApp;

	/**
	 * Reference to the activeUser from mainApp
	 */
	@SuppressWarnings("unused")
	private User activeUser;
	
	/**
	 * Reference to the weight
	 */
	private Weight weight = new Weight();

	/*
	 * FXML Variables to link
	 */
	@FXML
	private DatePicker date;

	@FXML
	private TextField weightField;
	
	@FXML
	private Label activeUserLabel;
	

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public InputWeightController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		date.valueProperty().bindBidirectional(weight.dateProperty());
		weightField.textProperty().bindBidirectional(weight.weightProperty(), new NumberStringConverter());
	}

	/**
	 * Method used in FXML to save the Weight and return to the Homepage
	 */
	@FXML
	private void saveWeight() {
		mainApp.getUserWeight().add(weight);
		mainApp.saveWeightXML();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Gewichtseintrag eingetragen");
		alert.setHeaderText(null);
		alert.setContentText("Das Gewicht wurde eingetragen!");
		alert.showAndWait();

		showHomepage();
	}

	/**
	 * Method to reset date and weight
	 */
	@FXML
	private void reset() {
		date.setValue(null);
		weightField.setText("");
	}


	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		activeUser = mainApp.getActiveUser();
		activeUserLabel.setText(mainApp.getActiveUser().getUsername());
	}

	/**
	 * Method to navigate to the Homepage in FXML
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

	/**
	 * Method to navigate to the InputActivityController in FXML
	 */
	@FXML
	private void showInputActivityController() {
		mainApp.showInputActivityController();
	}
}