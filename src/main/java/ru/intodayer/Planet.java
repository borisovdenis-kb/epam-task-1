package ru.intodayer;


public class Planet implements HealthInterface{
    private final Coordinate position;
    private int health;

    public Planet(int health, Coordinate position) {
        this.position = position;
        this.health = health;
    }

    public Coordinate getPosition() {
        return position;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decreaseHealth(int value) {
        setHealth(decreaseHealth(getHealth(), value));
    }
}
