package de.dung.realproject;

public class Exercise {
    private String name,description;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Exercise(String name){
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name,String description) {
        this.name = name;
        this.description = description;
    }
}
