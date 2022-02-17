package FitnessTracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

abstract public class MessageBox {

    public static void messageBox(String title, String message){
        //Stage:
        Stage primaryStage = setUpPrimaryStage(title);

        //Message label:
        Label messageLabel = setUpMessageLabel(message);

        //Buttons:
        Button okB = setUpOkB(primaryStage);

        //Button layout:
        HBox okBLayout = setUpOkBLayout(okB);

        //Label layout:
        HBox labelLayout = setUpLabelLayout(messageLabel);

        //Parent layout:
        VBox vLayout = setUpParentLayout(labelLayout, okBLayout);

        //Scene:
        Scene scene = new Scene(vLayout, 300,80);

        //Show stage:
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    private static Stage setUpPrimaryStage(String title){
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.setResizable(false);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        return primaryStage;
    }

    private static Label setUpMessageLabel(String message){
        Label messageLabel = new Label();
        messageLabel.setFont(new Font("Cambria", 15));
        messageLabel.setText(message);
        return messageLabel;
    }

    private static Button setUpOkB(Stage primaryStage){
        Button okB= new Button();
        okB.setText("Ok");
        okB.setCursor(Cursor.HAND);
        okB.setPrefHeight(40);
        okB.setPrefWidth(40);
        okB.setStyle(setUpOkBStyle());
        okB.setOnAction(e -> primaryStage.close());
        return okB;
    }

    private static String setUpOkBStyle(){
        return "-fx-background-color: #2196f3; " +
                "-fx-font-weight: bold; " +
                "-fx-font-size: 12; " +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 18;" +
                "-fx-border-radius: 18;" +
                "-fx-border-color: #000000; -fx-border-width: 0.3px; ";
    }

    private static HBox setUpOkBLayout(Button okB){
        HBox okBLayout = new HBox();
        okBLayout.getChildren().add(okB);
        okBLayout.setAlignment(Pos.CENTER);
        return okBLayout;
    }

    private static HBox setUpLabelLayout(Label messageLabel){
        HBox labelLayout = new HBox();
        labelLayout.styleProperty().set("-fx-background-color: #addde7; ");
        labelLayout.getChildren().addAll(messageLabel);
        labelLayout.setAlignment(Pos.CENTER);
        return labelLayout;
    }

    private static VBox setUpParentLayout(HBox messageLabel, HBox okBLayout){
        VBox parentLayout = new VBox(10);
        parentLayout.styleProperty().set("-fx-background-color: #addde7; ");
        parentLayout.setPadding(new Insets(10,10,10,10));
        parentLayout.setAlignment(Pos.CENTER);
        parentLayout.getChildren().addAll(messageLabel, okBLayout);
        return parentLayout;
    }

}
