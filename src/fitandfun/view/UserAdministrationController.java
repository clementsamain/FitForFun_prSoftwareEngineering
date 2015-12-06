package fitandfun.view;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.io.File;
import java.util.Optional;

import com.sun.javafx.css.converters.StringConverter;

import fitandfun.MainApp;
import fitandfun.Sex;
import fitandfun.model.User;

public class UserAdministrationController {

    // Reference to the main application.
    private MainApp mainApp;

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

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
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
    	
    	userList.setCellFactory(new Callback<ListView<User>, ListCell<User>>(){
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
    	userList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showUser(oldValue, newValue));
    	
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
    }
    
    @FXML
    private void showHomepage() {
    	mainApp.showHomepage();
    }
    
    @FXML
    private void createNewUser() {
    	User u = new User("Neuer Benutzer");
    	mainApp.getUserData().add(u);
    	userList.getSelectionModel().select(u);
    	
    }
    
    @FXML
    private void deleteSelectedUser()
    {
    	User u = userList.getSelectionModel().getSelectedItem();
    	
    	if(u != null)
    	{
    		Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Ausgewählten Benutzer löschen");
        	alert.setHeaderText("Wollen Sie den ausgewählten Benutzer "+ u.getUsername() +" wirklich löschen?");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        		mainApp.getUserData().remove(u);
        		SaveUsers();
        	
        		if(!u.getIsNew())
        		{
        			File f = new File("XML\\" + u.getUsername());
        			deleteDir(f);
        		}
        	}
    	}
    }
    
    private boolean deleteDir(File dir) 
    { 
	    if (dir.isDirectory()) 
	    { 
		    // get the names of the child files and directories into an array of String 
		    String[] children = dir.list(); 
		
		    // for each child file or directory 
		    for (int i = 0; i < children.length; i++) 
			    { 
			    // recursively delete 
			    deleteDir(new File(dir, children[i])); 
			    } 
	    } 
	    return dir.delete(); 
    }
    
    private void showUser(User oldUser, User newUser)
    {
    	if(oldUser != null)
    	{
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
		
		if (newUser != null)
    	{
    		gridPaneEdit.setDisable(false);
    		newUser.updateBMI();
    		txtUserName.textProperty().bindBidirectional(newUser.usernameProperty());
    		cboSex.valueProperty().bindBidirectional(newUser.sexProperty());
    		txtBirthday.valueProperty().bindBidirectional(newUser.birthdayProperty());
    		txtWeight.textProperty().bindBidirectional(newUser.weightProperty(), new NumberStringConverter());
    		txtHeight.textProperty().bindBidirectional(newUser.heightProperty(), new NumberStringConverter());
    		lblBMI.textProperty().bind(newUser.bmiProperty().asString("%.1f"));
    		if(newUser.getIsNew())
    		{
    			txtUserName.setDisable(false);
    		}
    	}
    	else
    	{
    		gridPaneEdit.setDisable(true);
    	}
    }
    
    @FXML
    private void SaveUsers()
    {
    	boolean err = false;
    	for(User u: mainApp.getUserData())
    	{
    		if(u.getIsNew()){
		    	File newDir = new File("XML\\"+u.getUsername());
		    	
		    	// if the directory does not exist, create it
		    	if (!newDir.exists()) {
		    	    System.out.println("creating directory: " + u.getUsername());
		    	    boolean result = false;
		
		    	    try{
		    	    	newDir.mkdir();
		    	        result = true;
		    	    } 
		    	    catch(SecurityException se){
		    	        //handle it
		    	    }        
		    	    if(result) {    
		    	        System.out.println("DIR created"); 
		    	        u.setIsNew(false);
		    	    }
		    	}else
		    	{
		    		err = true;
		    		Alert alert = new Alert(AlertType.ERROR);
		        	alert.setTitle("Fehler!");
		        	alert.setHeaderText("Der angegebene Benutzername " + u.getUsername() + " existiert bereits! Bitte wähle einen anderen!");
		        	alert.showAndWait();
		    	}
	    	}
    	}
    	if(!err)
    	{
    		txtUserName.setDisable(true);
    	}
    	
    	mainApp.saveUserXml();
    	//checkFolderName();
    }
}
