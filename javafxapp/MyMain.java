package com.myfirst.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String args[]){
launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter");
		primaryStage.show();
	}
	private MenuBar createMenu() {
		Menu filemenu = new Menu("FILE");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("new item clicked"));
		SeparatorMenuItem sem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		filemenu.getItems().addAll(newMenuItem, sem, quitMenuItem);
		Menu helpmenu = new Menu("HELP");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				aboutApp();
			}
		});
		helpmenu.getItems().addAll(aboutApp);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(filemenu, helpmenu);
		return menuBar;
	}
		public static void aboutApp()
	{
		Alert alertdialog=new Alert(Alert.AlertType.INFORMATION);
		alertdialog.setTitle("MY FILE");
		alertdialog.setHeaderText("ABOUT JAVA FX APPLICATION");
		alertdialog.setContentText("TIS IA ABC D EF JK LON KKOI YODHFHGLGJLGG. HBLOFHDSKKHG ,FJSILUGL");
		ButtonType yesbtn= new ButtonType("yes");
		ButtonType nobtn= new ButtonType("no");
		alertdialog.getButtonTypes().setAll(yesbtn,nobtn);
		Optional<ButtonType> clickBtn=alertdialog.showAndWait();
		if(clickBtn.isPresent()&&clickBtn.get()==yesbtn)
			System.out.println("yes button clicked");
		else
			System.out.println("no button clicked");
	}


	}

