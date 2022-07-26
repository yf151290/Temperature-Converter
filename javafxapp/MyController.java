package com.myfirst.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
@FXML
public Label welcomeid;
@FXML
public ChoiceBox<String> choiceid;
@FXML
public TextField userinputid;
@FXML
public Button buttonid;
private static final String C_to_F="Celsius to Farenhite";
private static final String F_to_C=" Farenhite to Celsius";
private boolean isC_to_F =true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceid.getItems().add(C_to_F);
		choiceid.getItems().add(F_to_C);
		choiceid.setValue(C_to_F);
		choiceid.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
		{
			if(newValue.equals(C_to_F))//if user selected celsius to farenhite
				isC_to_F=true;
			else
				isC_to_F=false; //if user selected farenhite to celsius
		});
buttonid.setOnAction(event -> {
	convert();
});

	}

	private void convert() {
		String input=userinputid.getText();
		float enteredtemp=0.0f;
		try {
			 enteredtemp = Float.parseFloat(input);
		}catch (Exception exception)
		{
			warnUser();
			return;
		}

		float newtemp=0.0f;
		if(isC_to_F)
			newtemp=(enteredtemp*9/5)+32;
		else
			newtemp=(enteredtemp-32)*5/9;
		display(newtemp);

	}

	private void warnUser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temprature Entered");
		alert.setContentText("Enter Valid Temperature");
		alert.show();
	}

	private void display(float newtemp) {
		String unit= isC_to_F? "F" :"C";
		System.out.println("The new temperature is : " + newtemp + unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Result");
alert.setContentText("The new temperature is : " + newtemp + unit);
alert.show();
	}
}
