package FitnessTracker;

import FitnessPackage.FitnessTrackerUser;
import javafx.scene.control.*;

public class RunningGUI extends ActivitiesGUI{

    public RunningGUI(){
        super("Running", "c57006");
    }

    @Override
    protected void setUpEnterBAction(Button enterB, FitnessTrackerUser user, TextField timeTextBox){
        enterB.setOnAction(e -> {
            String time = timeTextBox.getText();
            if (isValidInput(time)) {
                user.addRunningPracticeTime(Integer.parseInt(time));
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
        printB.setOnAction(e -> caloriesBurntField.setText(user.printRunning()));
    }
}
