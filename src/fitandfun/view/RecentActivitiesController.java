package fitandfun.view;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import fitandfun.MainApp;
import fitandfun.model.Activity;
import fitandfun.model.ActivityComparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * RecentActivitiesController shows the completed activities of the
 * active user sorted by date (newest first), and the related data like
 * activity-type, kilometers, altitude and time.
 *
 * @author Stefan Kaindlbinder
 * @version 1.0
 *
 */
public class RecentActivitiesController {
	// Reference to the main application.
	private MainApp mainApp;
	private String username;
	private ObservableList<Activity> activityList;
	private ObservableList<Activity> activityList_sorted;

	@FXML
	private Label actUserLabel;
	@FXML
	private VBox vbox;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public RecentActivitiesController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * Sorts the list of activities from the main app and creates
	 * the labels used to show the activities in the UI.
	 */
	private void showRecentAct() {
		activityList_sorted = FXCollections.observableArrayList();
		for (Activity act : activityList) {
			activityList_sorted.add(act);
		}
		Collections.sort(activityList_sorted, new ActivityComparator());

		for (Activity act : activityList_sorted) {
			Label lbl = new Label();
			Label detaillbl = new Label();
			Date date;

			String pattern = "yyyy-MM-dd";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    SimpleDateFormat print = new SimpleDateFormat("dd.MM.yyyy");
		    try {
		        date = format.parse(act.getDateString());
			    lbl.setFont(Font.font("Amble CN", 16));
				lbl.setBackground(new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
				lbl.setText(print.format(date) + ": " + act.getTypeString());
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }

			detaillbl.setText("Distanz: " + act.getDistance() + " km / Höhenmeter: " + act.getHMeter() + " hm / Dauer: " + act.getDurationString());
		    lbl.setPrefWidth(800);
			detaillbl.setPrefWidth(800);
			vbox.getChildren().add(lbl);
			vbox.getChildren().add(detaillbl);
			vbox.setPadding(new Insets(5, 10, 10, 10));
			vbox.setSpacing(5);
		}
	}

	/**
	 * Sets up the mainApp and gets the active user information and
	 * the users activities (as an observable list) from the main app.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		username = mainApp.getActiveUser().getUsername();
		actUserLabel.setText(username);
		activityList = mainApp.getUserActivity();
		showRecentAct();
	}

	/**
	 * Handles the navigation back to the main screen of the app.
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

}
