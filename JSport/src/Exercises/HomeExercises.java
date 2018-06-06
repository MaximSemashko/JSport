package Exercises;

public class HomeExercises {

    public int days;
    public int sets;
    public int squatsNumber;
    public int pushUpsNumber;
    public int pressNumber;
    public int rearPushUpsNumber;
    public int impactsNumber;
    public float plankDuration;

    public HomeExercises() {

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

    public int getSquatsNumber() {
        return squatsNumber;
    }

    public void setSquatsNumber(int squatsNumber) {
        this.squatsNumber = squatsNumber;
    }

    public int getPushUpsNumber() {
        return pushUpsNumber;
    }

    public void setPushUpsNumber(int pushUpsNumber) {
        this.pushUpsNumber = pushUpsNumber;
    }

    public int getPressNumber() {
        return pressNumber;
    }

    public void setPressNumber(int pressNumber) {
        this.pressNumber = pressNumber;
    }

    public int getRearPushUpsNumber() {
        return rearPushUpsNumber;
    }

    public void setRearPushUpsNumber(int rearPushUpsNumber) {
        this.rearPushUpsNumber = rearPushUpsNumber;
    }

    public int getImpactsNumber() {
        return impactsNumber;
    }

    public void setImpactsNumber(int impactsNumber) {
        this.impactsNumber = impactsNumber;
    }

    public float getPlankDuration() {
        return plankDuration;
    }

    public void setPlankDuration(float plankDuration) {
        this.plankDuration = plankDuration;
    }

    public HomeExercises(int days, int sets, int squatsNumber, int pushUpsNumber, int pressNumber, int rearPushUpsNumber, int impactsNumber, float plankDuration) {
        this.days = days;
        this.sets = sets;
        this.squatsNumber = squatsNumber;
        this.pushUpsNumber = pushUpsNumber;
        this.pressNumber = pressNumber;
        this.rearPushUpsNumber = rearPushUpsNumber;
        this.impactsNumber = impactsNumber;
        this.plankDuration = plankDuration;
    }
}
