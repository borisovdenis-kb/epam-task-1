package ru.intodayer.MovableObject.Enemy;

import ru.intodayer.Planet;


public class Asteroid extends Enemy {
    private int damage;

    public Asteroid(int damage, Planet planet) {
        this.damage = damage;
        this.planet = planet;
    }

    public void crash() {
        if (getCurrentPos().equals(planet.getPosition())) {
            planet.decreaseHealth(damage);
        }
    }
}
