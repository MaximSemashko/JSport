package Exercises;

public class GymExercises {
    public GymExercises() {

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

    public int getBenchSquats() {
        return BenchSquats;
    }

    public void setBenchSquats(int benchSquats) {
        BenchSquats = benchSquats;
    }

    public int getBarbellBenchPress() {
        return BarbellBenchPress;
    }

    public void setBarbellBenchPress(int barbellBenchPress) {
        BarbellBenchPress = barbellBenchPress;
    }

    public int getBentOverBarbellRow() {
        return BentOverBarbellRow;
    }

    public void setBentOverBarbellRow(int bentOverBarbellRow) {
        BentOverBarbellRow = bentOverBarbellRow;
    }

    public int getDips() {
        return Dips;
    }

    public void setDips(int dips) {
        Dips = dips;
    }

    public GymExercises(int days, int sets, int benchSquats, int barbellBenchPress, int bentOverBarbellRow, int dips) {

        this.days = days;
        this.sets = sets;
        BenchSquats = benchSquats;
        BarbellBenchPress = barbellBenchPress;
        BentOverBarbellRow = bentOverBarbellRow;
        Dips = dips;
    }

    public int days;
    public int sets;
    public int BenchSquats;
    public int BarbellBenchPress;
    public int BentOverBarbellRow;
    public int Dips;

}

