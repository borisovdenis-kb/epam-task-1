package ru.intodayer.MovableObject.Enemy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import ru.intodayer.Planet;
import ru.intodayer.Coordinate;
import ru.intodayer.MovableObject.MovableObject;


public class Enemy extends MovableObject {
    protected Coordinate previousPos;
    protected final double SPEED = 2;
    protected final double SPEED_OY;
    protected final double TG;
    protected int health;

    public Enemy() {
        currentPos = null;
        planet = null;
        health = 0;
        SPEED_OY = 0;
        TG = 0;
    }

    public Enemy(Coordinate position, Planet planet, int health) {
        super(position, planet);
        this.health = health;
        this.TG = calcTG();
        this.SPEED_OY = calcSpeedOY();
    }

    private double calcSpeedOY() {
        double speed = SPEED;
        if ((planet.getPosition().getY() - currentPos.getY()) < 0) {
            speed *= -1;
        }
        return speed;
    }

    private double calcTG() {
        double tg = Math.abs(planet.getPosition().getX() - currentPos.getX()) /
                    Math.abs(planet.getPosition().getY() - currentPos.getY());
        return tg;
    }

    /**
     * Changes coordinates of object according to time.
     * It's uniform rectilinear motion.
     *
     * @param time
     */
    @Override
    public void flyForward(double time) {
        previousPos = currentPos;
        double newX = previousPos.getX() + SPEED_OY * time * TG;
        double newY = previousPos.getY() + SPEED_OY * time;
        newX = new BigDecimal(newX).setScale(4, RoundingMode.HALF_UP).doubleValue();
        newY = new BigDecimal(newY).setScale(4, RoundingMode.HALF_UP).doubleValue();
        currentPos.setX(newX);
        currentPos.setY(newY);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void decreaseHealth(int value) {
        int hp = getHealth() - value;
        setHealth(hp <= 0 ? 0 : hp);
    }
}
