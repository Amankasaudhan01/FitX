package FitnessTracker;

import FitnessPackage.FitnessTrackerUser;
import javafx.scene.control.*;

public class StrengthTrainingGUI extends ActivitiesGUI{

    public StrengthTrainingGUI(){
        super("StrengthTraining", "004c92");
    }

    @Override
    protected void setUpEnterBAction(Button enterB, FitnessTrackerUser user, TextField timeTextBox){
        enterB.setOnAction(e -> {
            String time = timeTextBox.getText();
            if (isValidInput(time)) {
                user.addStrengthTrainingPracticeTime(Integer.parseInt(time));
                timeTextBox.clear();
                MessageBox.messageBox("Success",
                        "Practice time was added successfully.");
            }
            else MessageBox.messageBox("Error",
                    "please enter a valid practice time.");
        });
    }

    @Override
    protected void setUpPrintBAction(Button printB, FitnessTrackerUser user, TextArea caloriesBurntField){
        printB.setOnAction(e -> caloriesBurntField.setText(user.printStrengthTraining()));
    }
}
