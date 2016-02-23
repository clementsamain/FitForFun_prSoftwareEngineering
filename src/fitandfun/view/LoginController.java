package fitandfun.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import sun.applet.Main;

import java.net.URL;

import fitandfun.MainApp;
import fitandfun.model.User;

/**
 *
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
public class LoginController {

	/**
	 * Reference to the mainApplication
	 */
	private MainApp mainApp;
	
	/**
	 * selected User to save and save in HomepageController
	 */
	private User selectedUser;

	/*
	 * FXML Variable to link
	 */
	@FXML
	private ListView<User> userList;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public LoginController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		userList.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
			@Override
			public ListCell<User> call(ListView<User> param) {
				return new ListCell<User>() {
					@Override
					protected void updateItem(User item, boolean empty) {
						super.updateItem(item, empty);
						this.textProperty().unbind();
						this.setText("");
						if (item != null) {
							this.textProperty().bind(item.usernameProperty());
						}
					}
				};
			}
		});

		userList.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent click) {
				if (click.getClickCount() == 2) {
					try
					{
						selectedUser = userList.getSelectionModel().getSelectedItem();
						mainApp.setActiveUser(selectedUser);
						showHomepage();
					}catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				}
			}
		});
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		// userList.setItems(mainApp.getUserData());
		ObservableList<User> oldUsers = FXCollections.observableArrayList();
		for (User u : mainApp.getUserData()) {
			if (!u.getIsNew()) {
				oldUsers.add(u);
			}
		}
		userList.setItems(oldUsers);
		
	}

	/**
	 * Method to navigate to the Homepage in FXML
	 */
	@FXML
	private void showHomepage() {
		mainApp.showHomepage();
	}
}
