package ru.intodayer.movableobject;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;


public abstract class MovableObject {
    protected Coordinate currentPos;
    protected Planet planet;

    public MovableObject() {
        currentPos = new Coordinate(0.0, 0.0);
    }

    public MovableObject(Coordinate position, Planet planet) {
        this.currentPos = position;
        this.planet = planet;
    }

    /**
     * Changes coordinates of object according to time.
     *
     * @param time
     */
    public abstract void flyForward(double time);

    public Coordinate getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Coordinate currentPos) {
        this.currentPos = currentPos;
    }

    protected double getDistanceToPlanet() {
        return currentPos.getDistance(planet.getPosition());
    }
}
