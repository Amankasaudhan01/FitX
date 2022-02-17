package FitnessPackage;

public class StrengthTraining extends FitnessActivities{

    public StrengthTraining(){
        sportType = "Strength Training";
        caloriesBurntPerMinute = 5;
    }

    @Override
     public void addNewPracticeTime(int time){
        double rateOfIncrease = totalHeartRate * 0.006 * time;
        totalHeartRate += rateOfIncrease;
        heartRate += rateOfIncrease;
        int oldCaloriesBurnt = caloriesBurnt;
        caloriesBurnt += caloriesBurntPerMinute * time;
        totalCaloriesBurnt += caloriesBurnt - oldCaloriesBurnt;
     }

    @Override
    public int caloriesBurntGetter(){
        return caloriesBurnt;
    }

    @Override
    public double heartRateGetter(){
        return heartRate;
    }

    @Override
    public String toString() {
        return sportType + ":\n"
                + "calories burnt: " + caloriesBurnt + "\n"
                + "heart rate increase: " + String.format("%.2f", (heartRate - 80))
                + " beat/minute." + "\n\n";
    }

    @Override
    public String getString(){
        return  sportType + ":\n"
                + "calories burnt: " + caloriesBurnt + "\n"
                + "heart rate increase: " + String.format("%.2f", (heartRate  - 80))
                + " beat/minute." + "\n\n";
    }

}
