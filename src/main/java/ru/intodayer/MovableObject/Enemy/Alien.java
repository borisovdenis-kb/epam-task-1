package ru.intodayer.MovableObject.Enemy;

import ru.intodayer.Planet;
import ru.intodayer.Weapon;


public class Alien extends Enemy {
    private Weapon weapon;

    public Alien(Weapon weapon, Planet planet) {
        this.weapon = weapon;
        this.planet = planet;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void shoot() {
        planet.decreaseHealth(getWeapon().getDamage());
    }
}
