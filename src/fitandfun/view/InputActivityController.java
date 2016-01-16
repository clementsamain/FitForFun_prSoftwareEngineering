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

/**
 *
 * @author Viki
 * @version 0.1
 */
public class InputActivityController {

	// Reference to the main application.
	private MainApp mainApp;

	private User activeUser;

	@FXML
	private ComboBox<ActivityType> actName;
	@FXML
	private DatePicker date;
	@FXML
	// private Spinner<LocalTime> start;
	private TimeSpinner start; // CODE OKAY KANN ABER VOM SCENEBUILDER NICHT
								// ERKANNT WERDEN -> WENN DESIGN FERTIG AUF DAS
								// ÄNDERN!

	@FXML
	//private Spinner<LocalTime> end;
	private TimeSpinner end;
	@FXML
	private TextField distance;
	@FXML
	private TextField hmeter;
	@FXML
	private Label duration;
	@FXML
	private Label avgspeed;
	@FXML
	private Label calories;

	private Activity activity = new Activity();

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public InputActivityController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
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

		actName.valueProperty().bindBidirectional(activity.activityTypeProperty());
		date.valueProperty().bindBidirectional(activity.dateProperty());

		start.valueProperty().addListener((obs, oVal, nVal) -> activity.setStart(nVal));
		end.valueProperty().addListener((obs, oVal, nVal) -> activity.setEnd(nVal));

		distance.textProperty().bindBidirectional(activity.distanceProperty(), new NumberStringConverter());
		hmeter.textProperty().bindBidirectional(activity.hmeterProperty(), new NumberStringConverter());

		duration.textProperty().bind(activity.durationProperty().asString());
		avgspeed.textProperty().bind(activity.avgSpeedProperty().asString());
		calories.textProperty().bind(activity.calorieProperty().asString());

		activity.setStart(start.getValue());
		activity.setEnd(end.getValue());
	}

	@FXML
	private void saveActivity() {
		mainApp.getUserActivity().add(activity);
		mainApp.saveUserActivityXml();

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aktivität eingetragen");
		alert.setHeaderText(null);
		alert.setContentText("Die Aktivität wurde eingetragen!");

		alert.showAndWait();

		showHomepage();
	}

	@FXML
	private void reset() {
		// TODO
	}

	/**
	 * GPX-Import (work in progress...)
	 */
	@FXML
	private void importActivity() {
		ArrayList<Track> tracks = new ArrayList<Track>();
		GPX gpx = new GPX();
		JDOM p = new JDOM();
		FileChooser fc = new FileChooser();
		File selFile = fc.showOpenDialog(null);
		double tempDist = 0;
		int tempAsc = 0;
		Date tempStart = null;
		Date tempEnd = null;

		if (selFile != null) {
			try {
				gpx = p.parse(selFile);
			} catch (ParsingException e) {
				e.printStackTrace();
			}

			tracks = gpx.getTracks();

			for(Track t : tracks){
				tempDist = tempDist + (t.length()/1000);
				tempAsc = tempAsc + (int)t.cumulativeAscent();
				tempStart = t.startingTime();
				tempEnd = t.endTime();
			}
			NumberFormat tDR = NumberFormat.getInstance();
			tDR.setMaximumFractionDigits(2);
			distance.setText(tDR.format(tempDist));
			hmeter.setText(String.valueOf(tempAsc));
			start.setUserData(tempStart);
			end.setUserData(tempEnd);
		}


	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		actName.getItems().addAll(mainApp.getActivityData());
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