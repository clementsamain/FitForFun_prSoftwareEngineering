package fitandfun.view;

import fitandfun.MainApp;
import javafx.fxml.FXML;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import fitandfun.model.Activity;
import fitandfun.model.ActivityComparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

/**
 * Controller Class for the MapMenu, shows a list with activities where a card
 * is available link to the map
 * 
 * @author Marco Maihofer
 * @version 1.0
 *
 */
public class MapMenuController {

	private MainApp mainApp;

	private ObservableList<Activity> activityList;
	private ObservableList<Activity> activityList_sorted;
	private String username;

	@FXML
	private Label actUserLabel;
	@FXML
	private VBox vbox;

	@FXML
	private void initialize() {

	}

	/**
	 * shows recent activities with gpx File
	 */

	public void showRecentAct() {

		activityList_sorted = FXCollections.observableArrayList();
		for (Activity act : activityList) {
			activityList_sorted.add(act);
		}
		Collections.sort(activityList_sorted, new ActivityComparator());

		for (Activity act : activityList_sorted) {

			if (act.getgpxName() != null) {

				Label lbl = new Label();
				Label detaillbl = new Label();
				Button button = new Button();
				Date date;

				String pattern = "yyyy-MM-dd";
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				SimpleDateFormat print = new SimpleDateFormat("dd.MM.yyyy");
				try {
					date = format.parse(act.getDateString());
					lbl.setFont(Font.font("Amble CN", 16));
					lbl.setBackground(
							new Background(new BackgroundFill(Color.GREY, CornerRadii.EMPTY, Insets.EMPTY)));
					lbl.setText(print.format(date) + ": " + act.getTypeString());
				} catch (ParseException e) {
					e.printStackTrace();
				}

				detaillbl.setText("Distanz: " + act.getDistance() + " km / Höhenmeter: " + act.getHMeter()
						+ " hm / Dauer: " + act.getDurationString());
				lbl.setPrefWidth(800);
				button.setText("Karte anzeigen");
				detaillbl.setPrefWidth(800);
				vbox.getChildren().add(lbl);
				vbox.getChildren().add(detaillbl);
				vbox.getChildren().add(button);
				vbox.setPadding(new Insets(5, 10, 10, 10));
				vbox.setSpacing(5);

				button.setOnMouseClicked(e -> {
					mainApp.setGPXName(act.getgpxName());
					mainApp.showMapController();
				});

			}
		}
	}

	/**
	 * Sets up the mainApp and gets the active user information and the users
	 * activities (as an observable list) from the main app.
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
	 * import a gpx to show the card, file is not saved
	 */
	@FXML
	public void importMap() {

		FileChooser fc = new FileChooser();
		File selFile = fc.showOpenDialog(null);
		//mainApp.showMap(selFile.getAbsolutePath());
		mainApp.setGPXName(selFile.getAbsolutePath());
		mainApp.showMapController();
	}

	/**
	 * Handles the navigation back to the main screen of the app.
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}
}
