package ru.intodayer.movableobject;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;
import ru.intodayer.Weapon;
import ru.intodayer.movableobject.enemy.Enemy;

import java.math.BigDecimal;
import java.math.RoundingMode;

// TODO: Singleton

public class SpaceShip extends MovableObject {
    private final double period = 2.0;
    private final double radius;
    private double angle;
    private String nikName;
    private Weapon weapon;

    public SpaceShip(String nikName, Weapon weapon, Planet planet, double radius) {
        this.nikName = nikName;
        this.weapon = weapon;
        this.planet = planet;
        this.angle = 0;
        this.radius = radius;
        this.currentPos = getInitPosition();
    }

    private Weapon getWeapon() {
        return weapon;
    }

    /**
     * Changes coordinates of object according to time.
     * It's uniform circular motion.
     *
     * @param time
     */
    @Override
    public void flyForward(double time) {
        double newX = (radius * Math.cos((2 * Math.PI * time) / period)) + planet.getPosition().getX();
        double newY = (radius * Math.sin((2 * Math.PI * time) / period)) + planet.getPosition().getY();
        newX = new BigDecimal(newX).setScale(4, RoundingMode.HALF_UP).doubleValue();
        newY = new BigDecimal(newY).setScale(4, RoundingMode.HALF_UP).doubleValue();
        currentPos.setX(newX);
        currentPos.setY(newY);
    }

    public Coordinate getInitPosition() {
        Coordinate coordinate = new Coordinate(0.0, 0.0);
        coordinate.setX((radius * Math.cos((2 * Math.PI * 0.0) / period)) + planet.getPosition().getX());
        coordinate.setY((radius * Math.sin((2 * Math.PI * 0.0) / period)) + planet.getPosition().getY());

        return coordinate;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void shoot(Enemy enemy) {
        enemy.decreaseHealth(getWeapon().getDamage());
    }

    public String getNikName() {
        return nikName;
    }
}

