package Exercises;

public class WorkoutExercises {
    public int days;
    public int sets;
    public int squatsWithJump;
    public int dips;
    public int pullUps;
    public int australianPullUps;

    public WorkoutExercises(int days, int sets, int squatsWithJump, int dips, int pullUps, int australianPullUps) {
        this.days = days;
        this.sets = sets;
        this.squatsWithJump = squatsWithJump;
        this.dips = dips;
        this.pullUps = pullUps;
        this.australianPullUps = australianPullUps;
    }

    public WorkoutExercises() {

    }

    public int getDays() {

        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getSquatsWithJump() {
        return squatsWithJump;
    }

    public void setSquatsWithJump(int squatsWithJump) {
        this.squatsWithJump = squatsWithJump;
    }

    public int getDips() {
        return dips;
    }

    public void setDips(int dips) {
        this.dips = dips;
    }

    public int getPullUps() {
        return pullUps;
    }

    public void setPullUps(int pullUps) {
        this.pullUps = pullUps;
    }

    public int getAustralianPullUps() {
        return australianPullUps;
    }

    public void setAustralianPullUps(int australianPullUps) {
        this.australianPullUps = australianPullUps;
    }


}
