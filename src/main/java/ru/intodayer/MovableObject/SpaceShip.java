package ru.intodayer.MovableObject;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;
import ru.intodayer.Weapon;
import ru.intodayer.MovableObject.Enemy.Enemy;

import java.math.BigDecimal;
import java.math.RoundingMode;

// TODO: Singleton

public class SpaceShip extends MovableObject {
    private final double PERIOD = 2.0;
    private final double RADIUS;
    private final String nikName;
    private double angle;
    private Weapon weapon;

    public SpaceShip(String nikName, Weapon weapon, Planet planet, double radius) {
        this.nikName = nikName;
        this.weapon = weapon;
        this.planet = planet;
        this.angle = 0;
        this.RADIUS = radius;
        this.currentPos = getInitPosition();
    }

    /**
     * Changes coordinates of object according to time.
     * It's uniform circular motion.
     *
     * @param time
     */
    @Override
    public void flyForward(double time) {
        double newX = (RADIUS * Math.cos((2 * Math.PI * time) / PERIOD)) + planet.getPosition().getX();
        double newY = (RADIUS * Math.sin((2 * Math.PI * time) / PERIOD)) + planet.getPosition().getY();
        newX = new BigDecimal(newX).setScale(4, RoundingMode.HALF_UP).doubleValue();
        newY = new BigDecimal(newY).setScale(4, RoundingMode.HALF_UP).doubleValue();
        currentPos.setX(newX);
        currentPos.setY(newY);
    }

    private Coordinate getInitPosition() {
        Coordinate coordinate = new Coordinate();
        coordinate.setX((RADIUS * Math.cos((2 * Math.PI * 0.0) / PERIOD)) + planet.getPosition().getX());
        coordinate.setY((RADIUS * Math.sin((2 * Math.PI * 0.0) / PERIOD)) + planet.getPosition().getY());

        return coordinate;
    }

    private Weapon getWeapon() {
        return weapon;
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

