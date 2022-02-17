package FitnessPackage;

final public class FitnessTrackerUser {
    private String userName;
    private int swimmingIndex = 0;
    private int runningIndex = 1;
    private int kickBoxingIndex = 2;
    private int strengthTrainingIndex = 3;
    private IFitnessActivities[] activities = new FitnessActivities[4];

    public FitnessTrackerUser(){}

    public FitnessTrackerUser(String userName){
        this.userName = userName;
        activities[swimmingIndex] = new Swimming();
        activities[runningIndex] = new Running();
        activities[kickBoxingIndex] = new KickBoxing();
        activities[strengthTrainingIndex] = new StrengthTraining();
    }

    public void addSwimmingPracticeTime(int time){
        activities[swimmingIndex].addNewPracticeTime(time);
    }

    public void addRunningPracticeTime(int time){
        activities[runningIndex].addNewPracticeTime(time);
    }

    public void addKickBoxingPracticeTime(int time){
        activities[kickBoxingIndex].addNewPracticeTime(time);
    }

    public void addStrengthTrainingPracticeTime(int time){
        activities[strengthTrainingIndex].addNewPracticeTime(time);
    }

    public void sortActivities(){
            boolean trueOrFalse = true;
            while (trueOrFalse){
                trueOrFalse = false;
                for (int i = 0; i < 3; i++){
                    if (checkToSwap(i)) {
                        trueOrFalse = true;
                        IFitnessActivities temp = activities[i];
                        activities[i] = activities[i + 1];
                        activities[i + 1] = temp;
                    }
                }
            }
            getNewIndices();
    }

    private boolean checkToSwap(int index){
        return activities[index].caloriesBurntGetter() < activities[index + 1].caloriesBurntGetter()
                || (  activities[index].caloriesBurntGetter() == activities[index + 1].caloriesBurntGetter()
                && activities[index].heartRateGetter() < activities[index + 1].heartRateGetter()  );
    }

    private void getNewIndices(){
        for (int i = 0; i < 4; i++){
            if (activities[i] instanceof Swimming) swimmingIndex = i;
            else if (activities[i] instanceof Running) runningIndex = i;
            else if (activities[i] instanceof KickBoxing) kickBoxingIndex = i;
            else if (activities[i] instanceof StrengthTraining) strengthTrainingIndex = i;
        }
    }

    public String nameGetter(){
        return userName;
    }

    public String printSwimming(){
        return userName
                + " activity: \n"
                + activities[swimmingIndex].getString();
    }

    public String printRunning(){
        return userName
                + " activity: \n"
                + activities[runningIndex].getString();
    }

    public String printKickBoxing(){
        return userName
                + " activity: \n"
                + activities[kickBoxingIndex].getString();
    }

    public String printStrengthTraining(){
        return userName
                + " activity: \n"
                + activities[strengthTrainingIndex].getString();
    }

    public String printCalories(){
        return "Results: \n\nTotal calories burnt: "
                + FitnessActivities.totalCaloriesBurntGetter()
                + "\nTotal heart rate: "
                + String.format("%.2f", FitnessActivities.TotalHeartRateGetter())
                + "\n\n"
                + userName + " Activities: \n\n"
                + activities[0].getString()
                + activities[1].getString()
                + activities[2].getString()
                + activities[3].getString();
    }
}
