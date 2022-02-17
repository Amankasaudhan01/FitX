package FitnessTracker;

import FitnessPackage.FitnessTrackerUser;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

abstract public class ActivitiesGUI {

    private String activityTitle;
    private String color;

    public ActivitiesGUI(String activityTitle, String color){
        this.activityTitle = activityTitle;
        this.color = color;
    }

    public void GUI(FitnessTrackerUser user, Stage previousStage){
        //Stage:
        Stage primaryStage = setUpPrimaryStage(previousStage);

        //TextField:
        TextField timeTextBox = setUpTimeTextBox();

        //TextArea
        TextArea caloriesBurntField = setUpCaloriesBurntField();

        //Buttons:
        Button enterB = setUpEnterBStyle();
        setUpEnterBAction(enterB, user, timeTextBox);
        Button printB = setUpPrintBStyle();
        setUpPrintBAction(printB, user, caloriesBurntField);
        Button returnB = setUpReturnB(primaryStage, previousStage);

        //TextBox and enter button layout:
        HBox textBoxAndEnterBLayout = setUpTextBoxAndEnterBLayout(timeTextBox, enterB);

        //Parent layout:
        VBox parentLayout = setUpParentLayout(textBoxAndEnterBLayout, printB,
                returnB, caloriesBurntField);

        //Scene:
        Scene scene = new Scene(parentLayout, 250, 250);

        //Show the stage:
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    private Stage setUpPrimaryStage(Stage previousStage){
        Stage primaryStage = new Stage();
        primaryStage.setTitle(this.activityTitle);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> previousStage.show());
        return primaryStage;
    }

    private TextField setUpTimeTextBox(){
        TextField timeTextBox = new TextField();
        timeTextBox.setPromptText("Enter the exercise time.");
        timeTextBox.setPrefHeight(20);
        timeTextBox.setPrefWidth(160);
        timeTextBox.setStyle("-fx-background-radius: 18;" +
                "-fx-border-radius: 18;" +
                "-fx-border-color: #000000; -fx-border-width: 0.3px; ");
        return timeTextBox;
    }

    private TextArea setUpCaloriesBurntField(){
        TextArea caloriesBurntField = new TextArea();
        caloriesBurntField.setEditable(false);
        caloriesBurntField.setPrefHeight(150);
        caloriesBurntField.setPrefWidth(240);
        caloriesBurntField.setStyle("-fx-background-radius: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #000000; -fx-border-width: 0.5px; ");
        return caloriesBurntField;
    }

    private Button setUpEnterBStyle(){
        Button enterB = new Button();
        enterB.setText("Enter");
        enterB.setPrefHeight(30);
        enterB.setPrefWidth(70);
        enterB.setCursor(Cursor.HAND);
        enterB.setStyle(setUpButtonsStyle());
        return enterB;
    }

    abstract void setUpEnterBAction(Button enterB,FitnessTrackerUser user, TextField timeTextBox);

    private Button setUpPrintBStyle(){
        Button printB = new Button();
        printB.setText("Print " + activityTitle + " calories burnt");
        printB.setPrefHeight(30);
        printB.setPrefWidth(260);
        printB.setCursor(Cursor.HAND);
        printB.setStyle(setUpButtonsStyle());
        return printB;
    }

    abstract void setUpPrintBAction(Button printB, FitnessTrackerUser user, TextArea caloriesBurntField);

    private Button setUpReturnB(Stage primaryStage, Stage previousStage){
        Button returnB = new Button();
        returnB.setText("Go back");
        returnB.setCursor(Cursor.HAND);
        returnB.setStyle(setUpButtonsStyle());
        returnB.setOnAction(e -> {
            previousStage.show();
            primaryStage.close();
        });
        return returnB;
    }

    protected String setUpButtonsStyle(){
        return "-fx-background-color: #" + color + "; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 12; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 15;" +
                "-fx-border-radius: 15;" +
                "-fx-border-color: #000000; -fx-border-width: 0.5px; ";
    }

    private HBox setUpTextBoxAndEnterBLayout(TextField timeTextBox, Button enterB){
        HBox textBoxAndEnterBLayout = new HBox(10);
        textBoxAndEnterBLayout.styleProperty().set("-fx-background-color: #addde7; ");
        textBoxAndEnterBLayout.getChildren().addAll(timeTextBox, enterB);
        return textBoxAndEnterBLayout;
    }

    private VBox setUpParentLayout(HBox textBoxAndEnterBLayout, Button printB,
                                   Button returnB, TextArea caloriesBurntField){
        VBox parentLayout = new VBox(10);
        parentLayout.styleProperty().set("-fx-background-color: #addde7; ");
        parentLayout.setPadding(new Insets(10,10,10,10));
        parentLayout.getChildren().addAll(textBoxAndEnterBLayout, printB, caloriesBurntField, returnB);
        return parentLayout;
    }

    protected boolean isValidInput(String time){
        if (time.equals("")) return false;
        for (int i = 0; i < time.length(); i++)
            if (!(time.charAt(i) >= '0' && time.charAt(i) <= '9'))
                return false;

        return true;
    }
}