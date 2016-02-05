package fitandfun.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;
import java.io.File;
import java.util.Optional;
import fitandfun.MainApp;
import fitandfun.Sex;
import fitandfun.model.User;

/**
 *
 * @author Viktoria Jechsmayr
 * @version 1.0
 * 
 */
public class UserAdministrationController {

	/**
	 * Reference to the main application
	 */
	private MainApp mainApp;

	/*
	 * FXML Variables to link
	 */
	@FXML
	private ListView<User> userList;
	
	@FXML
	private GridPane gridPaneEdit;
	
	@FXML
	private TextField txtUserName;
	
	@FXML
	private ComboBox<Sex> cboSex;
	
	@FXML
	private DatePicker txtBirthday;
	
	@FXML
	private TextField txtWeight;
	
	@FXML
	private TextField txtHeight;
	
	@FXML
	private Label lblBMI;
	
	@FXML
	private Label activeUserLabel;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public UserAdministrationController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		showUser(null, null);

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
		userList.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showUser(oldValue, newValue));

		cboSex.getItems().addAll(Sex.values());
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		userList.setItems(mainApp.getUserData());
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
	 * Creates a new Default User and add it to the userData in MainApp and show
	 * it in userList (ListView)
	 */
	@FXML
	private void createNewUser() {
		User u = new User("Neuer Benutzer");
		mainApp.getUserData().add(u);
		userList.getSelectionModel().select(u);
	}

	/**
	 * Delete the Selected User from the ListView and delete it from XML, also
	 * deletes the DIR and all Files
	 */
	@FXML
	private void deleteSelectedUser() {
		User u = userList.getSelectionModel().getSelectedItem();

		if (u != null && userList.getItems().size() > 1) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Ausgewählten Benutzer löschen");
			alert.setHeaderText("Wollen Sie den ausgewählten Benutzer " + u.getUsername() + " wirklich löschen?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				mainApp.getUserData().remove(u);
				SaveUsers();

				if (!u.getIsNew()) {
					File f = new File("XML\\" + u.getUsername());
					deleteDir(f);
				}
			}
		}else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Benutzer kann nicht gelöscht werden");
			alert.setHeaderText("Der letze Benutzer kann nicht gelöscht werden!");

			alert.showAndWait();
		}
	}

	/**
	 * Recursive delete DIR and all Files below
	 * 
	 * @param dir
	 *            - to delete
	 * @return boolean
	 */
	private boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			// get the names of the child files and directories into an array of
			// String
			String[] children = dir.list();

			// for each child file or directory
			for (int i = 0; i < children.length; i++) {
				// recursively delete
				deleteDir(new File(dir, children[i]));
			}
		}
		return dir.delete();
	}

	/**
	 * Shows User in ListView loaded from the XML and new User added
	 * @param oldUser
	 * @param newUser
	 */
	private void showUser(User oldUser, User newUser) {
		if (oldUser != null) {
			txtUserName.textProperty().unbindBidirectional(oldUser.usernameProperty());
			cboSex.valueProperty().unbindBidirectional(oldUser.sexProperty());
			txtBirthday.valueProperty().unbindBidirectional(oldUser.birthdayProperty());
			txtWeight.textProperty().unbindBidirectional(oldUser.weightProperty());
			txtHeight.textProperty().unbindBidirectional(oldUser.heightProperty());
			lblBMI.textProperty().unbind();
		}

		txtUserName.setText("");
		txtUserName.setDisable(true);
		cboSex.getSelectionModel().select(Sex.None);
		txtBirthday.setValue(null);
		txtWeight.setText("");
		txtHeight.setText("");
		lblBMI.setText("");

		if (newUser != null) {
			gridPaneEdit.setDisable(false);
			newUser.updateBMI();
			txtUserName.textProperty().bindBidirectional(newUser.usernameProperty());
			cboSex.valueProperty().bindBidirectional(newUser.sexProperty());
			txtBirthday.valueProperty().bindBidirectional(newUser.birthdayProperty());
			txtWeight.textProperty().bindBidirectional(newUser.weightProperty(), new NumberStringConverter());
			txtHeight.textProperty().bindBidirectional(newUser.heightProperty(), new NumberStringConverter());
			lblBMI.textProperty().bind(newUser.bmiProperty().asString("%.1f"));
			if (newUser.getIsNew()) {
				txtUserName.setDisable(false);
			}
		} else {
			gridPaneEdit.setDisable(true);
		}
	}

	/**
	 * Saves the UserData (oldUsers and new added Users)
	 * Create a DIR for new User is the Directory didn't exists and when the User is marked as NEW
	 */
	@FXML
	private void SaveUsers() {
		boolean err = false;
		for (User u : mainApp.getUserData()) {
			if (u.getIsNew()) {
				if(u.getHeight() >=50 && u.getHeight() <=300 && u.getWeight() >= 5 && u.getWeight() <=500){
				File newDir = new File("XML\\" + u.getUsername());

				// if the directory does not exist, create it
				if (!newDir.exists()) {
					System.out.println("creating directory: " + u.getUsername());
					boolean result = false;

					try {
						newDir.mkdir();
						result = true;
					} catch (SecurityException se) {
						// handle it
					}
					if (result) {
						System.out.println("DIR created");
						u.setIsNew(false);
					}
				} else {
					err = true;
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Fehler!");
					alert.setHeaderText("Der angegebene Benutzername " + u.getUsername()
							+ " existiert bereits! Bitte wähle einen anderen!");
					alert.showAndWait();
				}
				
				}else
				{
					err = true;
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Fehler!");
					alert.setHeaderText("Bitte kontrolliere deine eingegebenen Daten!");
					alert.showAndWait();
				}
			}
		}
		if (!err) {
			txtUserName.setDisable(true);
		}
		mainApp.saveUserXml();
	}
}
