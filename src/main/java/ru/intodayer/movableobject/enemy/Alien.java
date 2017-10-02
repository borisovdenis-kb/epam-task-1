package ru.intodayer.movableobject.enemy;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;
import ru.intodayer.Weapon;


public class Alien extends Enemy {
    private Weapon weapon;

    public Alien(Coordinate position, Planet planet, int health, Weapon weapon) {
        super(position, planet, health);
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void shoot() {
        planet.decreaseHealth(getWeapon().getDamage());
    }
}
