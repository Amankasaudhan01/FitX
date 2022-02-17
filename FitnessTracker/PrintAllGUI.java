package FitnessTracker;

import FitnessPackage.FitnessTrackerUser;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

abstract public class PrintAllGUI {

    public static void printActivities(FitnessTrackerUser user, Stage previousStage){
        //Stage:
        Stage primaryStage = setUpPrimaryStage(previousStage);

        //Buttons:
        Button returnB = setUpReturnB(primaryStage, previousStage);

        //Print TextArea:
        TextArea printField = setUpPrintField(user);

        //Parent layout:
        VBox parentLayout = setUpParentLayout(printField, returnB);

        //Scene:
        Scene scene = new Scene(parentLayout, 400, 400);

        //Show stage:
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    private static Stage setUpPrimaryStage(Stage previousStage){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("My activities");
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> previousStage.show());
        return primaryStage;
    }

    private static Button setUpReturnB(Stage primaryStage, Stage previousStage){
        Button returnB = new Button();
        returnB.setText("Go back");
        returnB.setCursor(Cursor.HAND);
        returnB.setStyle(setUpReturnBStyle());
        returnB.setOnAction(e -> {
            previousStage.show();
            primaryStage.close();
        });
        return returnB;
    }

    private static String setUpReturnBStyle(){
        return "-fx-background-color: #2196f3; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 12; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 15;" +
                "-fx-border-radius: 15;" +
                "-fx-border-color: #000000; -fx-border-width: 0.5px; ";
    }

    private static TextArea setUpPrintField(FitnessTrackerUser user){
        TextArea printField = new TextArea();
        printField.setEditable(false);
        printField.setPrefHeight(350);
        printField.setPrefWidth(350);
        printField.setStyle("-fx-background-radius: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: #000000; -fx-border-width: 0.5px; ");
        printField.setText(user.printCalories());
        return printField;
    }

    private static VBox setUpParentLayout(TextArea printField, Button returnB){
        VBox parentLayout = new VBox(10);
        parentLayout.styleProperty().set("-fx-background-color: #addde7; ");
        parentLayout.setPadding(new Insets(10,10,10,10));
        parentLayout.getChildren().addAll(printField, returnB);
        return parentLayout;
    }
}
