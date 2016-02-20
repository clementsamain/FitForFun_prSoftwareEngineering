package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import fitandfun.MainApp;
import fitandfun.TimeSpinner;
import fitandfun.model.Activity;
import fitandfun.model.ActivityType;
import fitandfun.model.User;

/**
 *
 * @author Viktoria Jechsmayr
 * @version 1.0
 */
public class InputActivityController {

	/**
	 * Reference to the MainApplication
	 */
	private MainApp mainApp;

	/**
	 * Reference to the activeUser from mainApp
	 */
	private User activeUser;

	/**
	 * Reference to the activities loaded from XML in mainApp
	 */
	private Activity activity = new Activity();

	/*
	 * FXML Variables to link
	 */
	@FXML
	private ComboBox<ActivityType> actName;

	@FXML
	private DatePicker date;

	@FXML
	private TimeSpinner start;

	@FXML
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

	@FXML
	private Label activeUserLabel;


	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public InputActivityController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 *
	 * Binding all Variables to save/load in the XML-File
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

	/**
	 * Method used in FXML to save the Activity and return to the Homepage
	 */
	@FXML
	private void saveActivity() {
		if(actName.getSelectionModel().getSelectedItem() != null && date.getValue() != null && end.getValue().isAfter(start.getValue())){
			mainApp.getUserActivity().add(activity);
			mainApp.saveUserActivityXml();

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aktivität eingetragen");
			alert.setHeaderText(null);
			alert.setContentText("Die Aktivität wurde eingetragen!");
			alert.showAndWait();

			showHomepage();
		}else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aktivität nicht eingetragen");
			alert.setHeaderText(null);
			alert.setContentText("Bitte kontrollieren Sie ob Sie alle notwendigen Daten eingegeben haben!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to return to the Homepage when "Abbrechen"-Button clicked in FXML
	 */
	@FXML
	private void reset() {
		showHomepage();
	}

	/**
	 * GPX-Import
	 *
	 */
	@SuppressWarnings("deprecation")
	@FXML
	private void importActivity() {
		ArrayList<Track> tracks = new ArrayList<Track>();
		GPX gpx = new GPX();
		JDOM p = new JDOM();
		FileChooser fc = new FileChooser();
		File selFile = fc.showOpenDialog(null);

		activity.setGpxName(selFile.getAbsolutePath());

		double tempDist = 0;
		int tempAsc = 0;
		Date tempStart = null;
		Date tempEnd = null;
		LocalTime e = null;
		LocalTime s = null;


		if (selFile != null) {
			try {
				gpx = p.parse(selFile);
			} catch (ParsingException en) {
				en.printStackTrace();
			}

			tracks = gpx.getTracks();

			if (tracks.get(0) != null) {
				if (tracks.get(0).startingTime() != null) {
					Track tmp = tracks.get(0);
					tempStart = tmp.startingTime();
					Instant instant = Instant.ofEpochMilli(tempStart.getTime());
					s = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
					start.getValueFactory().setValue(s);
				}
				for(Track t : tracks){
					tempDist = tempDist + (t.length()/1000);
					tempAsc = tempAsc + (int)t.cumulativeAscent();
					if (t.startingTime() != null) {
						tempStart = t.startingTime();
						tempEnd = t.endTime();
					}
				}
				if(tempEnd != null){
					Instant instant = Instant.ofEpochMilli(tempEnd.getTime());
					e = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
					end.getValueFactory().setValue(e);
				}
				NumberFormat tDR = NumberFormat.getInstance();
				tDR.setMaximumFractionDigits(2);
				distance.setText(tDR.format(tempDist));
				hmeter.setText(String.valueOf(tempAsc));
			}
		}
	}

	/**
	 * setMainApp() is called by the main application to give a reference back to itself.
	 * <br> activeUser is loaded from the mainApp
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		actName.getItems().addAll(mainApp.getActivityData());
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
}