package BankingApplication;
/*Folder/Project Name	: Project8
 * Programmer Name		: 
 * Date					:
 * Class Name			: BankingApplication
 * Project Description	: 
  */

import javafx.application.*;
import javafx.event.ActionEvent; //action for the button, textfield
import javafx.event.EventHandler; //handler for the listener
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.Scene;
import javafx.scene.control.*; //components from Javafx

import javafx.scene.text.*;

import javafx.scene.layout.*; //layout

import javafx.stage.Stage; // show the scene

import java.util.*;

import BankingApplication.BankingSystem.Account;
import BankingApplication.BankingSystem.CheckingAccount;
import BankingApplication.BankingSystem.SavingsAccount; 

public class BankingApplication extends Application implements EventHandler<ActionEvent>
{
	String bankName = "Friendly Neighborhood Bank";
	String authorName = "Daniel Zelfo";
	/********************************************************************************
	 * STRING ARRAY to POPULATE THE COMBOBOXES
	 ********************************************************************************/
	String choiceString [] = {"Create Account","Withdraw or Deposit","Show all Accounts"};	
	/********************************************************************************
	 * OBJECTS to enter on a  CHOICE PANE
	 ********************************************************************************/
	Label companyLabel = new Label ("  "+bankName+"   ");
	Label selectLabel = new Label ("Please Select an Action: ");
	ComboBox <String> selectComboBox = new ComboBox<>();
	Button goButton = new Button("Go");
	Label programmerNameLabel = new Label ("programmed by " + authorName);
	
	/********************************************************************************
	 * OBJECTS to enter on a  ACCOUNT PANE
	 ********************************************************************************/
	Label companyLabel2 = new Label ("     "+bankName+"      ");
	VBox newAccountInformationForm = new VBox();
	HBox newFirstNameHBox = new HBox();
	Label firstNameLabel = new Label ("  First name ");
	TextField firstNameTextField = new TextField();
	HBox newLastNameHBox = new HBox();
	Label lastNameLabel = new Label ("  Last name ");
	TextField lastNameTextField = new TextField();
	HBox newPinHBox = new HBox();
	Label newPinLabel = new Label ("  PIN           ");
	TextField newPinTextField = new TextField();
	Button processNewAccountButton = new Button("Process");
	String typeAccountString [] = {"Accounts", "Checking", "Savings"};
	ComboBox<String> typeAccountComboBox = new <String> ComboBox();
	Button backFromNewAccountButton = new Button("Back");
	TextArea accountOutputTextArea = new TextArea();
	ScrollPane accountScrollPane = new ScrollPane();
	
	/********************************************************************************
	 * OBJECTS to enter on a  TRANSACTION PANE
	 ********************************************************************************/
	Label companyLabel3 = new Label ("       "+bankName+"        ");
	VBox accountTransactionForm = new VBox();
	HBox transactionTypeHBox = new HBox();
	RadioButton withdrawRadioButton = new RadioButton("  Withdraw  ");
	RadioButton depositRadioButton = new RadioButton("  Deposit   ");
	ToggleGroup transactionButtonGroup = new ToggleGroup();
	Label confirmPinLabel = new Label(" PIN:                    ");
	TextField confirmPinTextField = new TextField();
	Label amountLabel = new Label(" Enter amount:    ");
	TextField amountTextField = new TextField();
	HBox pinHBox = new HBox();
	HBox amountHBox = new HBox();
	Button processTransactionButton = new Button("Process");
	Button backFromTransactionButton = new Button("Back");
	TextArea transactionOutputTextArea = new TextArea();
	ScrollPane transactionScrollPane = new ScrollPane();
	
	/********************************************************************************
	 * OBJECTS to enter on a  DISPLAY PANE
	 ********************************************************************************/
	TextArea displayAllTextArea = new TextArea();
	ScrollPane displayScrollPane = new ScrollPane();
	Button backFromDisplayButton = new Button("Back");
	
	/********************************************************************************
	 * CREATE THE PANES FOR THE DIFFERENT WINDOWS
	 *********************************************************************************/
	FlowPane enterPane = new FlowPane();
	FlowPane accountPane = new FlowPane();
	FlowPane transactionPane = new FlowPane();
	VBox displayPaneVBox = new VBox();
	StackPane mainStackPane; 
	
	
	
	/******************************************************************************
	 * INSTANCE VARIABLES
	 * myAccount - stores the accounts of the customers
	 * lastAccountInteger - keeps track of the position of the array which have accounts
	 * MAX_ACCOUNTS_INTEGER - highest index of the array
	 *****************************************************************************/
	
	final byte MAX_ACCOUNT_INTEGER = 9, pinLength = 4;
	byte lastAccountInteger = -1;
	
	Account [] myAccount = new Account[MAX_ACCOUNT_INTEGER+1];
	
	String transactionFormat = "%-6s%-17s%-15s%-12s%-10s%-10s%-10s%n", accountFormat = "%-20s%-10s%-15s%-10s%n";
	
	
	Font taFont = Font.font("Courier", FontPosture.REGULAR, 12);
	Font companyFont = Font.font("Sans Serif", FontWeight.BOLD, 20);
	Font programmerNameFont = Font.font("Sans Serif", FontPosture.ITALIC, 10);

	
	
	/******************************************************************************
	 * main METHOD
	 * INSTANTIATES THE CLASS 
	 * launches the Javafx
	 *****************************************************************************/
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		launch(args);
		
	}
	
	/******************************************************************************
	 * BankingApplication METHOD - CONSTRUCTOR
	 * CALLS THE DESIGNENTERPANEL METHOD TO ADD COMPONENTS ON THE ENTER PANE 
	 * CALLS THE DESIGNACCOUNTPANEL METHOD TO ADD COMPONENTS ON THE ACCOUNT PANE
	 * CALLS THE DESIGNTRANSACTIONPANEL METHOD TO ADD COMPONENTS ON THE TRANSACTION PANE
	 * CALLS THE DESIGNDISPLAYPANEL METHOD TO ADD COMPONENTS ON THE DISPLAY PANE
	 * CALLS THE ADDLISTENERS METHOD TO ADD LISTENERS TO THE COMPONENTS
	 *****************************************************************************/
	
	public BankingApplication()
	{
		//constructor 
		//call the methods to add components to the other panels
		
		designEnterPanel();
		designAccountPanel();
		designTransactionPanel();
		designDisplayPanel();
		addListeners();
	}
	
	/******************************************************************************
	 * designEnterPanel METHOD -
	 * ADDS THE COMPONENTS FOR THE ENTERPANE
	 *****************************************************************************/
	
	public void designEnterPanel()
	{
		//add components to the mainPanel
		companyLabel.setFont(companyFont);
		selectComboBox.getItems().addAll(choiceString);
		
		enterPane.getChildren().add(companyLabel);
		enterPane.getChildren().add(selectLabel);
		enterPane.getChildren().add(selectComboBox);
		enterPane.getChildren().add(goButton);
		programmerNameLabel.setFont(programmerNameFont);
		enterPane.getChildren().add(programmerNameLabel);	
	}
	
	/******************************************************************************
	 * designEnterPanel METHOD -
	 * ADDS THE COMPONENTS FOR THE ACCOUNTPANE
	 *****************************************************************************/
	public void designAccountPanel()
	{
		//add components to the 
		
		companyLabel2.setFont(companyFont);
		typeAccountComboBox.getItems().addAll(typeAccountString);
		typeAccountComboBox.getSelectionModel().select(0);
		
		//set the scroll pane to the account text area
		accountScrollPane.setContent(accountOutputTextArea);
		accountScrollPane.setFitToWidth(true);
		accountScrollPane.setPrefWidth(400);
		accountScrollPane.setPrefHeight(180);
		
		
		accountPane.getChildren().add(newAccountInformationForm);
		newAccountInformationForm.getChildren().add(companyLabel2);
		newAccountInformationForm.getChildren().add(newFirstNameHBox);
		newFirstNameHBox.getChildren().add(firstNameLabel);
		newFirstNameHBox.getChildren().add(firstNameTextField);
		newAccountInformationForm.getChildren().add(newLastNameHBox);
		newLastNameHBox.getChildren().add(lastNameLabel);
		newLastNameHBox.getChildren().add(lastNameTextField);
		newAccountInformationForm.getChildren().add(newPinHBox);
		newPinHBox.getChildren().add(newPinLabel);
		newPinHBox.getChildren().add(newPinTextField);
		newAccountInformationForm.getChildren().add(typeAccountComboBox);
		newAccountInformationForm.getChildren().add(processNewAccountButton);
		newAccountInformationForm.getChildren().add(accountScrollPane);
		newAccountInformationForm.getChildren().add(backFromNewAccountButton);
		
		
		accountOutputTextArea.setFont(taFont);
		String formattedTitleString = String.format(accountFormat,
				"Name","PIN", "Account Type", "Balance");
		accountOutputTextArea.setText(formattedTitleString);
	}
	
	/******************************************************************************
	 * designTranactionPanel METHOD -
	 * ADDS THE COMPONENTS FOR THE TRANSACTIONPANE
	 *****************************************************************************/
	public void designTransactionPanel()
	{
		//add the container group to the radio buttons
		depositRadioButton.setToggleGroup(transactionButtonGroup);
		withdrawRadioButton.setToggleGroup(transactionButtonGroup);
		
		//set the scroll pane to the account text area
		transactionScrollPane.setContent(transactionOutputTextArea);
		transactionScrollPane.setFitToWidth(true);
		transactionScrollPane.setPrefWidth(400);
		transactionScrollPane.setPrefHeight(180);
		
		
		transactionOutputTextArea.setFont(taFont);
		String formattedTitleString = String.format(transactionFormat+"%n",
				"PIN","Name","Account Type", "Trans Type", "Trans Amt","Charge","Balance" );
		transactionOutputTextArea.setText(formattedTitleString);
		
		companyLabel3.setFont(companyFont);
		
		transactionPane.getChildren().add(accountTransactionForm);
		accountTransactionForm.getChildren().add(companyLabel3);
		accountTransactionForm.getChildren().add(transactionTypeHBox);
		transactionTypeHBox.getChildren().add(depositRadioButton);
		transactionTypeHBox.getChildren().add(withdrawRadioButton);
		accountTransactionForm.getChildren().add(pinHBox);
		pinHBox.getChildren().add(confirmPinLabel);
		pinHBox.getChildren().add(confirmPinTextField);
		accountTransactionForm.getChildren().add(amountHBox);
		amountHBox.getChildren().add(amountLabel);
		amountHBox.getChildren().add(amountTextField);
		accountTransactionForm.getChildren().add(processTransactionButton);
		accountTransactionForm.getChildren().add(transactionScrollPane);
		accountTransactionForm.getChildren().add(backFromTransactionButton);
		
	}
	/******************************************************************************
	 * designDisplayPanel METHOD -
	 * ADDS THE COMPONENTS FOR THE DISPLAYPANE
	 *****************************************************************************/
	public void designDisplayPanel()
	{
		
		//set the scroll pane to the account text area
		displayScrollPane.setContent(displayAllTextArea);
		displayScrollPane.setFitToWidth(true);
		displayScrollPane.setPrefWidth(400);
		displayScrollPane.setPrefHeight(180);
		
		displayPaneVBox.getChildren().add(new Label("Display All the Accounts"));
		displayPaneVBox.getChildren().add(displayScrollPane);
		displayPaneVBox.getChildren().add(backFromDisplayButton);
		
	}
	
	/******************************************************************************
	 * addListeners METHOD -
	 * ADDS THE ACTIONLISTENER TO THE COMBOBOX, BUTTONS
	 *****************************************************************************/
	
	public void addListeners()
	{
		//add the listeners to the respective components 
		selectComboBox.setOnAction(this);
		goButton.setOnAction(this);
		processNewAccountButton.setOnAction(this);
		backFromNewAccountButton.setOnAction(this);
		processTransactionButton.setOnAction(this);
		backFromTransactionButton.setOnAction(this);
		backFromDisplayButton.setOnAction(this);
	}
	
	//this method assigns the actions and methods to the correct button
	public void handle(ActionEvent evt)
	{
		//buttons fire this event
		Object sourceObject = evt.getSource();
		
		if (sourceObject == goButton)
		{
			if(selectComboBox.getSelectionModel().getSelectedIndex() == 0)  //Add an account option
			{
				mainStackPane.getChildren().remove(enterPane);
				mainStackPane.getChildren().add(accountPane);
			}
			else if (selectComboBox.getSelectionModel().getSelectedIndex() == 1) //Transaction option
			{
				mainStackPane.getChildren().remove(enterPane);
				depositRadioButton.setSelected(false);
				withdrawRadioButton.setSelected(false);
				mainStackPane.getChildren().add(transactionPane);
				
			}
			else if(selectComboBox.getSelectionModel().getSelectedIndex() == 2)  //Display all transactions option
			{	
				mainStackPane.getChildren().remove(enterPane);
				mainStackPane.getChildren().add(displayPaneVBox);
				displayAllAccountInfo();
			}
			else
				AlertDialog("Combo Box","", "Please make a selection in the combo box before pressing Go.");
		}
		
		if(sourceObject == processNewAccountButton)
		{
			if(validationNewAccountFields()) {
				processNewAccount();
			}
		}
		else if(sourceObject == processTransactionButton)
		{
			if(validationTransRadioButtons())
				processTransaction();
			else 
				AlertDialog("Withdraw or Deposit","","Please select either withdraw or deposit");			
		}
		
		else if(sourceObject == backFromNewAccountButton)
		{
			mainStackPane.getChildren().remove(accountPane);
			selectComboBox.getSelectionModel().select(0);
			mainStackPane.getChildren().add(enterPane);
			firstNameTextField.clear();
			lastNameTextField.clear();
			newPinTextField.clear();
			typeAccountComboBox.getSelectionModel().select(0);
			accountOutputTextArea.setText(String.format(accountFormat,
					"Name","PIN", "Account Type", "Balance"));

		}
		else if(sourceObject == backFromTransactionButton)
		{
			mainStackPane.getChildren().remove(transactionPane);
			selectComboBox.getSelectionModel().select(0);
			mainStackPane.getChildren().add(enterPane);
			confirmPinTextField.clear();
			amountTextField.clear();
			transactionOutputTextArea.setText(String.format(transactionFormat,
					"PIN","Name","Account Type", "Trans Type", "Trans Amt","Charge","Balance" ) );
		}
		else if(sourceObject == backFromDisplayButton)
		{
			mainStackPane.getChildren().remove(displayPaneVBox);
			selectComboBox.getSelectionModel().select(0);
			mainStackPane.getChildren().add(enterPane);
		}	
		
	}//end of handle method
	
	
	//validates if something has been entered into the three text fields 
	public boolean validationNewAccountFields()
	{
	    boolean validationBoolean = false;
	    
	    if(!(firstNameTextField.getText()).equals(""))
	    {
	    	if(!(lastNameTextField.getText()).equals(""))
	    	{
	    		if(!(newPinTextField.getText()).equals(""))
	    		{ 
	    			if((typeAccountComboBox.getSelectionModel().getSelectedIndex() == 1) ||
	    					(typeAccountComboBox.getSelectionModel().getSelectedIndex() == 2))
	    			{
	    				validationBoolean = true; 
	    			}
	    			else
	    			{
		    			AlertDialog("Account","", "Please choose a Checking or Savings");
		    			typeAccountComboBox.requestFocus();
		    			validationBoolean = false;
	    			}
	    		}
    		   
	    		else
	    		{
	    			AlertDialog("Pin","", "Please enter a PIN");
	    			newPinTextField.requestFocus();
	    			validationBoolean = false;
	    		}
	    	}
	    
	    	else
	    	{
	    		AlertDialog("Name","Last Name", "Please enter Last Name");
	    		lastNameTextField.requestFocus();
	    		validationBoolean = false;}
			}
	    else
	    {
	    	AlertDialog("Name","First Name", "Please enter First Name");
	    	firstNameTextField.requestFocus();
	    	validationBoolean = false;
	    }
	    
	    return validationBoolean;
	
	}
	
	//this method will validate if a radio button was selected
	public boolean validationTransRadioButtons()
	{
		boolean validationBoolean = false;
		
		if(depositRadioButton.isSelected() || withdrawRadioButton.isSelected())
			validationBoolean = true;
		else
			validationBoolean = false;
		return validationBoolean;
	}
	
	//this method will make a new account
	public void processNewAccount()
	{
		short pin;
		String accountType = typeAccountComboBox.getSelectionModel().getSelectedItem().toString();
		
		//resetting the textarea
		accountOutputTextArea.setText(String.format(accountFormat,
				"Name","PIN", "Account Type", "Balance"));
		
		/*
		 * 
		 * INPUT VALIDATION
		 * 
		 */
		
		//parsing the pin to an integer
		//using a try.catch statement to make sure the user used the right format and alerting them if not
		try {
			pin = Short.parseShort(newPinTextField.getText());
		}catch(Exception e) {
			AlertDialog("Pin not a valid integer", "", "Please make sure the pin is made up of only digits (no letters).");
			return;
		}
		
		//making sure the account limit was not reached
		if(lastAccountInteger >= MAX_ACCOUNT_INTEGER) {
			AlertDialog("Maximum Account Limit Reached", "", "You can only create "+(MAX_ACCOUNT_INTEGER+1)+" accounts.");
			return;
		}
		
		//making sure the pin is the right length
		if(newPinTextField.getText().length() != pinLength) {
			AlertDialog("Invalid Pin", "Pin length invalid", "The pin must be "+pinLength+" digits.");
			return;
		}
		
		/*
		 * BUSINESS VALIDATION
		 */
		//making sure the pin is not already used
		for(int currentAccountIndex = 0; currentAccountIndex <= lastAccountInteger; currentAccountIndex++) {
			if (myAccount[currentAccountIndex].validateUsedPin(pin)) {
				AlertDialog("Invalid Pin", "", "The entered pin is already used.");
				return;
			}
		}
		
		//CREATING THE ACCOUNT
		
		lastAccountInteger++;
		if(accountType == "Checking") 
			myAccount[lastAccountInteger] = new CheckingAccount(firstNameTextField.getText(), lastNameTextField.getText(), pin);
		else 
			myAccount[lastAccountInteger] = new SavingsAccount(firstNameTextField.getText(), lastNameTextField.getText(), pin);
		
		//appending the account information into the account output textarea
		accountOutputTextArea.appendText(myAccount[lastAccountInteger].toString());
		
		
		return;
	}//end of processNewAccount method
	
	//this method checks if the entered pin is correct and then withdraws or deposits depending on the radio button
	public void processTransaction()
	{
		String transactionType = ((RadioButton) transactionButtonGroup.getSelectedToggle()).getText().trim();
		short pin;
		byte accountIndex = 0;
		float amount;
		
		/*
		 * 
		 * INPUT VALIDATION:
		 * 
		 */
		//parsing the pin and amount from string to integer and double respectively and using try/catch statements incase they are not in the right format
		//alerting the user if the pin or amount are not in the right format
		try {
			pin = Short.parseShort(confirmPinTextField.getText());
		}catch(Exception e) {
			AlertDialog("Invalid Pin", "", "The pin must be made up of only digits (no letters).");
			return;
		}
		try {
			amount = Float.parseFloat(amountTextField.getText());
		}catch(Exception e) {
			AlertDialog("Invalid Amount", "", "The amount must be in number format (no letters).");
			return;
		}
		
		/*
		 * 
		 * BUSINESS VALIDATION:
		 * 
		 */
		//searching for the account with that pin linearly since there can only be 10 accounts
		for(byte currentAccountIndex = 0; currentAccountIndex <= lastAccountInteger; currentAccountIndex++) {
			//checking if the pin is equal to the pin of the current saved account
			if (myAccount[currentAccountIndex].validateUsedPin(pin)) {
				//we will save the index of the account and get out of the loop
				accountIndex = currentAccountIndex;
				break;
			}
			//if the end is reached without an equal pin, then the pin is invalid
			if(currentAccountIndex==lastAccountInteger) {
				//we will alert the user and stop the transaction process
				AlertDialog("Invalid Account", "The entered pin is invalid.", "No account associated with this pin exists.");
				return;
			}
		}
		
		//MAKING DEPOSIT IF THAT IS THE TYPE OF TRANSACTION
		if (transactionType.equals("Deposit")) {
			transactionOutputTextArea.appendText(myAccount[accountIndex].deposit(amount));
			return;
		}
		
		/*
		 * MAKING WITHDRAWAL BUSINESS VALIDATION
		 */
		//validating that the account has sufficient funds
		if ( !myAccount[accountIndex].validateSufficientFunds(amount)) {
			AlertDialog("Insufficient Funds", "", "You do not have enough funds for this withdrawal and the $"+myAccount[accountIndex].getFee()+" fee.");
			return;
		}
				
		//checking if a fee must be charged and confirming with the user if it is okay to continue and charge a fee (if one exists)
		if(myAccount[accountIndex].validateChargeFee(amount) && !AlertConfirmation("Proceed?", "A fee of $"+ myAccount[accountIndex].getFee() +" must be charged", "Would you like to continue?") ) {
			transactionOutputTextArea.appendText(myAccount[accountIndex].getCancelledTransactionLog());
			return;
		}
		
		//making the withdrawal
		transactionOutputTextArea.appendText(myAccount[accountIndex].withdraw(amount));
		return;
		
	}//end of processTransaction method
	
	//this method shows the account information in a JOption pane
	public void displayAllAccountInfo()
	{
		displayAllTextArea.setText(String.format(accountFormat+"%n",
				"Name","PIN", "Account Type", "Balance"));
		//looping through all the accounts and appending them
		for(int currentAccountIndex = 0; currentAccountIndex <= lastAccountInteger; currentAccountIndex++) {
			displayAllTextArea.appendText(myAccount[currentAccountIndex].toString());
		}
		
	}//end of displayAllAccountInfo method	
	
	
	public void AlertDialog(String titleString, String headerString, String messageString)
	{
		Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle(titleString);
    	alert.setHeaderText(headerString);
    	alert.setContentText(messageString);
    	alert.showAndWait();
	}
	
	public boolean AlertConfirmation(String titleString, String headerString, String messageString)
	{
		boolean confirmBoolean = false;
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle(titleString);
    	alert.setHeaderText(headerString);
    	alert.setContentText(messageString);
    	
    	ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
    	ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
    	
    	alert.getButtonTypes().setAll(okButton, noButton);
    	
    	
        

        Optional <ButtonType> result = alert.showAndWait();
        
        
        if(result.get() == okButton)
		{
			confirmBoolean = true;
		}
        
        return confirmBoolean;
        
        
        
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// TODO Auto-generated method stub
		//Brilliant TShirts will on the title on the pane
		primaryStage.setTitle(bankName);
		
		enterPane.setAlignment(Pos.CENTER);
		mainStackPane = new StackPane();
		
		mainStackPane.getChildren().add(enterPane);				
		Scene scene= new Scene(mainStackPane, 400, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
