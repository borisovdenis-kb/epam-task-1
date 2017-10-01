package ru.intodayer;


public class Planet {
    private final Coordinate POSITION;
    private int health;

    public Planet(int health, Coordinate position) {
        this.POSITION = position;
        this.health = health;
    }

    public Coordinate getPosition() {
        return POSITION;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decreaseHealth(int value) { // TODO: Это можно сделать с помощью interface?
        int hp = getHealth() - value;
        setHealth(hp <= 0 ? 0 : hp);
    }
}
