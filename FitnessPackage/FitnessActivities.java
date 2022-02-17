package FitnessPackage;



abstract public class FitnessActivities implements IFitnessActivities{

    protected String sportType;
    protected int caloriesBurnt;
    protected int caloriesBurntPerMinute;
    protected float heartRate = 80;
    protected static int totalCaloriesBurnt;
    protected static double totalHeartRate = 80;

    abstract public void addNewPracticeTime(int time);

    abstract public int caloriesBurntGetter();

    public static int totalCaloriesBurntGetter(){return totalCaloriesBurnt;}

    public double heartRateGetter(){return heartRate;}

    public static double TotalHeartRateGetter(){
        return totalHeartRate;
    }

    abstract public String getString();
}
