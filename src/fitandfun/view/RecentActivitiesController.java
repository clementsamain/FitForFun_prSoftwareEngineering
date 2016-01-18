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

public class RecentActivitiesController {

	// Reference to the main application.
	private MainApp mainApp;
	private String username;
	private ObservableList<Activity> activityList;

	@FXML
	private Label actUserLabel;

	@FXML
	private VBox vbox;
	
	private ObservableList<Activity> activityList_sorted;

	public RecentActivitiesController() {
	}

	@FXML
	private void initialize() {

	}

	public void showRecentAct() {
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
				lbl.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
				//lbl.setText(print.format(date) + ": " + act.getTypeString());
				lbl.setText(act.getDateString() + ": " + act.getTypeString());
		    } catch (ParseException e) {
		      e.printStackTrace();
		    }
		    
			detaillbl.setText("(" + act.getDistance() + " km, " + act.getHMeter() + " hm, " + act.getDurationString() + ")");
			lbl.setPrefWidth(800);
			detaillbl.setPrefWidth(800);
			vbox.getChildren().add(lbl);
			vbox.getChildren().add(detaillbl);
			vbox.setPadding(new Insets(5, 10, 10, 10));
			vbox.setSpacing(5);
		}
	}


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		username = mainApp.getActiveUser().getUsername();
		actUserLabel.setText(username);
		activityList = mainApp.getUserActivity();
		showRecentAct();
	}



	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}

}