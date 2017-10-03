package ru.intodayer.movableobject.enemy;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;


public class Asteroid extends Enemy {
    private int damage;

    public Asteroid(Planet planet, Coordinate position, int health, int damage) {
        super(planet, position, health);
        this.damage = damage;
    }

    public void crash() {
        this.planet.decreaseHealth(damage);
        health = 0;
    }
}
