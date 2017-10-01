package ru.intodayer.MovableObject;

import ru.intodayer.Coordinate;
import ru.intodayer.Weapon;
import ru.intodayer.MovableObject.Enemy.Enemy;

// TODO: Singleton

public class SpaceShip extends MovableObject {
    private final double PERIOD = 2.0;
    private final double RADIUS;
    private final String nikName;
    private double angle;
    private Weapon weapon;

    public SpaceShip(String nikName, Weapon weapon, double radius) {
        this.nikName = nikName;
        this.weapon = weapon;
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
        currentPos.setX(RADIUS * Math.cos((2 * Math.PI * time) / PERIOD));
        currentPos.setY(RADIUS * Math.sin((2 * Math.PI * time) / PERIOD));
    }

    private Coordinate getInitPosition() {
        Coordinate coordinate = new Coordinate();
        coordinate.setX(RADIUS * Math.cos((2 * Math.PI * 0.0) / PERIOD));
        coordinate.setY(RADIUS * Math.sin((2 * Math.PI * 0.0) / PERIOD));

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

