package org.launchcode.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {

    @NotNull
    @Size(min=1, max=20, message = "Description field required and must be between 1 and 20 characters")
    private String name;

    @NotNull
    @Size(min=1, max=40, message = "Description field required and must be between 1 and 40 characters")
    private String description;

    private CheeseType type;

    private int cheeseId;
    private static int nextId = 1;

    //constructor

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId ++;
    }

    //getters
    public int getCheeseId() {
        return cheeseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CheeseType getType() {
        return type;
    }

    //setters
    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

}
