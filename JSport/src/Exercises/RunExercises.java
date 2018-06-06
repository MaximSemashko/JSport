package Exercises;

public class RunExercises {

    public RunExercises(int days, int runing, int squats, int runningWithAcceleration, int impacts) {
        this.days = days;
        this.runing = runing;
        this.squats = squats;
        this.runningWithAcceleration = runningWithAcceleration;
        this.impacts = impacts;
    }

    public int days;
    public int runing;
    public int squats;
    public int runningWithAcceleration;
    public int impacts;

    public RunExercises() {

    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getRuning() {
        return runing;
    }

    public void setRuning(int runing) {
        this.runing = runing;
    }

    public int getSquats() {
        return squats;
    }

    public void setSquats(int squats) {
        this.squats = squats;
    }

    public int getRunningWithAcceleration() {
        return runningWithAcceleration;
    }

    public void setRunningWithAcceleration(int runningWithAcceleration) {
        this.runningWithAcceleration = runningWithAcceleration;
    }

    public int getImpacts() {
        return impacts;
    }

    public void setImpacts(int impacts) {
        this.impacts = impacts;
    }
}
