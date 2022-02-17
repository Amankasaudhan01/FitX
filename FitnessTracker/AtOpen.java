package FitnessTracker;

import FitnessPackage.FitnessTrackerUser;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class AtOpen {

    private static FitnessTrackerUser user;

    public static FitnessTrackerUser EnterUserName(){
        //Name TextBox:
        TextField nameTextBox = setUpNameTextBox();

        //Stage:
        Stage primaryStage = setUpPrimaryStage(nameTextBox);

        //Enter name label:
        Label enterNameL = setUpEnterNameLabel();

        //Buttons:
        Button nextB = setUpNextButton();
        setUpNextButtonAction(nextB, primaryStage, nameTextBox);

        //TextBox and next button layout:
        HBox textBoxAndNextButtonLayout = setUpTextBoxAndNextButtonLayout(nameTextBox, nextB);

        //Parent layout:
        VBox vLayout = setUpParentLayout(enterNameL, textBoxAndNextButtonLayout);

        //Scene:
        Scene scene = new Scene(vLayout, 230, 80);

        //Show the stage:
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

        //Return the user object with the user name:
        return user;
    }

    private static Stage setUpPrimaryStage(TextField nameTextBox){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Login");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> {
            if (nameTextBox.getText().equals(""))
                user = new FitnessTrackerUser("User");
            MessageBox.messageBox("Warning", "Your user name was set to \"User\"");
        });
        return primaryStage;
    }

    private static HBox setUpTextBoxAndNextButtonLayout(TextField nameTextBox, Button nextB){
        HBox textBoxAndNextButtonLayout = new HBox(10);
        textBoxAndNextButtonLayout.styleProperty().set("-fx-background-color: #addde7; ");
        textBoxAndNextButtonLayout.getChildren().addAll(nameTextBox, nextB);
        return textBoxAndNextButtonLayout;
    }

    private static VBox setUpParentLayout(Label enterNameL,
                                          HBox textBoxAndNextButtonLayout){
        VBox parentLayout = new VBox(10);
        parentLayout.styleProperty().set("-fx-background-color: #addde7; ");
        parentLayout.setPadding(new Insets(10,10,10,10));
        parentLayout.setAlignment(Pos.TOP_LEFT);
        parentLayout.getChildren().addAll(enterNameL, textBoxAndNextButtonLayout);
        return parentLayout;
    }

    private static Label setUpEnterNameLabel(){
        Label enterNameL = new Label();
        enterNameL.setFont(new Font("Cambria", 15));
        enterNameL.setText("Enter your name:");
        return enterNameL;
    }

    private static TextField setUpNameTextBox(){
        TextField nameTextBox = new TextField();
        nameTextBox.setStyle("-fx-background-radius: 18;" +
                "-fx-border-radius: 18;" +
                "-fx-border-color: #000000; -fx-border-width: 0.3px; ");
        nameTextBox.setPromptText("Enter your name.");
        return nameTextBox;
    }

    private static Button setUpNextButton(){
        Button nextB = new Button();
        nextB.setText("Next");
        nextB.setPrefHeight(20);
        nextB.setPrefWidth(50);
        nextB.setCursor(Cursor.HAND);
        nextB.setStyle(setUpNextButtonStyle());
        return nextB;
    }

    private static void setUpNextButtonAction(Button nextB, Stage firstStage,
                                              TextField nameTextBox){
        nextB.setOnAction(e -> {
            String name = nameTextBox.getText();
            name = name.trim();
            if (isValidName(name)) {
                user = new FitnessTrackerUser(name);
                MessageBox.messageBox("Success",
                        "Welcome " + user.nameGetter() + ".");
                firstStage.close();
            }
            else MessageBox.messageBox("Error",
                    "Please enter a valid name.");
        });
    }

    private static String setUpNextButtonStyle(){
        return "-fx-background-color: #2196f3; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 12; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 18;" +
                "-fx-border-radius: 18;" +
                "-fx-border-color: #000000; -fx-border-width: 0.3px; ";
    }

    private static boolean isValidName(String name){
        if (name.equals("")) return false;
        for (int i = 0 ; i < name.length(); i++)
            if (!isCharacter(name.charAt(i)))
                return false;

        return true;
    }

    private static boolean isCharacter(char ch){
        return ((ch >= 'a' && ch <= 'z' || ch == ' ')
                || (ch >= 'A' && ch <= 'Z'));
    }
}
