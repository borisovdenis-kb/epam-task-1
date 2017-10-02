package ru.intodayer.movableobject.enemy;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ru.intodayer.HealthInterface;
import ru.intodayer.Planet;
import ru.intodayer.Coordinate;
import ru.intodayer.movableobject.MovableObject;


public class Enemy extends MovableObject implements HealthInterface {
    protected Coordinate previousPos;
    protected final double speed = 2;
    protected final double speedOy;
    protected final double tangent;
    protected int health;

    public Enemy(Coordinate position, Planet planet, int health) {
        super(position, planet);
        this.health = health;
        this.tangent = calcTG();
        this.speedOy = calcSpeedOY();
    }

    private double calcSpeedOY() {
        double speed = this.speed;
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
        double newX = previousPos.getX() + speedOy * time * tangent;
        double newY = previousPos.getY() + speedOy * time;
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
        setHealth(decreaseHealth(getHealth(), value));
    }
}
