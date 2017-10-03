package ru.intodayer.movableobject.enemy;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;
import ru.intodayer.Weapon;


public class Alien extends Enemy {
    private Weapon weapon;

    public Alien(Planet planet, Coordinate position, int health, Weapon weapon) {
        super(planet, position, health);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void shoot() {
        planet.decreaseHealth(getWeapon().getDamage());
    }
}
