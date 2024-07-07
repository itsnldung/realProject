package de.dung.realproject;

public class Exercise {
    private String name, description;
    private int reps, sets, rpe;

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public int getRpe() {
        return rpe;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Exercise(String name) {
        this.name = name;
        this.description = "";
        this.sets = 0;
        this.reps = 0;
        this.rpe = 0;
    }

    public Exercise(String name, int reps, int sets, int rpe, String description) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.rpe = rpe;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
