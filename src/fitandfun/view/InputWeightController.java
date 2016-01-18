package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import net.divbyzero.gpx.GPX;
import net.divbyzero.gpx.Track;
import net.divbyzero.gpx.parser.JDOM;
import net.divbyzero.gpx.parser.ParsingException;

import java.io.File;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import fitandfun.MainApp;
import fitandfun.TimeSpinner;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;
import fitandfun.model.User;
import fitandfun.model.Weight;

/**
 *
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
public class InputWeightController {

	// Reference to the main application.
	private MainApp mainApp;

	private User activeUser;

	@FXML
	private DatePicker date;

	@FXML
	private TextField weightField;
	
	private Weight weight = new Weight();
	

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
	}

	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

	@FXML
	private void showInputActivityController() {
		mainApp.showInputActivityController();
	}
}