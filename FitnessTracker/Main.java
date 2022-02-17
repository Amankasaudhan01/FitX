package FitnessTracker;

import FitnessPackage.FitnessActivities;
import FitnessPackage.FitnessTrackerUser;
import FitnessPackage.Swimming;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{

    private FitnessTrackerUser user;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Initialize a new user:
        user = AtOpen.EnterUserName();

        //Stage:
        setUpPrimaryStage(primaryStage);

        //Buttons:
        Button swimmingB = setUpActivityButton(primaryStage, "Swimming",
                "2196f3", "10", new SwimmingGUI());

        Button runningB = setUpActivityButton(primaryStage, "Running",
                "c57006", "-10", new RunningGUI());

        Button kickBoxingB = setUpActivityButton(primaryStage, "Kick Boxing",
                "c53200", "10", new KickBoxingGUI());

        Button strengthTrainingB = setUpActivityButton(primaryStage, "Strength Training",
                "004c92", "-10", new StrengthTrainingGUI());

        Button printB = setUpPrintB(primaryStage);
        Button sortB = setUpSortB();

        //Parent layout:
        GridPane buttonsLayout = setUpButtonsLayout(swimmingB, runningB,
                kickBoxingB, strengthTrainingB, sortB, printB);

        //Scene:
        Scene scene1 = new Scene(buttonsLayout, 380, 300);

        //Show the Stage:
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private void setUpPrimaryStage(Stage primaryStage){
        primaryStage.setTitle("Fitness Tracker");
        primaryStage.setResizable(false);
    }

    private GridPane setUpButtonsLayout(Button swimmingB, Button runningB,
                                        Button kickBoxingB, Button strengthTrainingB,
                                        Button sortB, Button printB){
        GridPane buttonsLayout = new GridPane();
        buttonsLayout.styleProperty().set("-fx-background-color: #addde7; ");
        buttonsLayout.setAlignment(Pos.CENTER);
        buttonsLayout.setPadding(new Insets(10, 10, 10, 10));
        buttonsLayout.setHgap(10);
        buttonsLayout.setVgap(10);
        GridPane.setConstraints(swimmingB, 0, 0);
        GridPane.setConstraints(runningB, 1, 0);
        GridPane.setConstraints(kickBoxingB, 0, 1);
        GridPane.setConstraints(strengthTrainingB, 1, 1);
        GridPane.setConstraints(sortB, 0, 2);
        GridPane.setConstraints(printB, 1, 2);
        buttonsLayout.getChildren().addAll(swimmingB, runningB, kickBoxingB
                , strengthTrainingB, sortB, printB);
        return buttonsLayout;
    }

    private Button setUpActivityButton(Stage primaryStage, String text, String color,
                                       String rotateEffectValue, ActivitiesGUI activityGUI){
        Button activityB = new Button();
        activityB.setText(text);
        activityB.setPrefHeight(100);
        activityB.setPrefWidth(200);
        activityB.setCursor(Cursor.HAND);
        activityB.setStyle(setUpButtonStyle(color, "0"));
        activityB.setOnMouseEntered(e -> activityB.setStyle(setUpButtonStyle(color, rotateEffectValue)));
        activityB.setOnMouseExited(e -> activityB.setStyle(setUpButtonStyle(color, "0")));
        activityB.setOnAction(e -> {
            primaryStage.close();
            activityGUI.GUI(user, primaryStage);
        });
        return activityB;
    }

    private Button setUpSortB(){
        Button sortB = new Button();
        sortB.setText("Sort my activities");
        sortB.setPrefHeight(50);
        sortB.setPrefWidth(200);
        sortB.setCursor(Cursor.HAND);
        sortB.setStyle(setUpButtonStyle("c7b500", "0"));
        sortB.setOnMouseEntered(a -> sortB.setStyle(setUpButtonStyle("c7b500", "10")));
        sortB.setOnMouseExited(k -> sortB.setStyle(setUpButtonStyle("c7b500", "0")));
        sortB.setOnAction(e -> {
            user.sortActivities();
            MessageBox.messageBox("Success","Done sorting.");
        });
        return sortB;
    }

    private Button setUpPrintB(Stage primaryStage){
        Button printB = new Button();
        printB.setText("Print my activities");
        printB.setPrefHeight(50);
        printB.setPrefWidth(200);
        printB.setCursor(Cursor.HAND);
        printB.setStyle(setUpButtonStyle("c7b500", "0"));
        printB.setOnMouseEntered(a -> printB.setStyle(setUpButtonStyle("c7b500", "-10")));
        printB.setOnMouseExited(k -> printB.setStyle(setUpButtonStyle("c7b500", "0")));
        printB.setOnAction(e -> {
            primaryStage.close();
            PrintAllGUI.printActivities(user, primaryStage);
        });
        return printB;
    }

    private String setUpButtonStyle(String color, String rotateValue){
        return "-fx-background-color: #" + color + "; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 16; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 50; " +
                "-fx-rotate: " + rotateValue + ";" +
                "-fx-border-radius: 50;" +
                "-fx-border-color: #000000; -fx-border-width: 1px; ";
    }

    public static void main(String[] args) {
       launch(args);
    }
}