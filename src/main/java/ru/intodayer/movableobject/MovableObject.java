package ru.intodayer.movableobject;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;


public abstract class MovableObject {
    protected Planet planet;
    protected Coordinate currentPos;

    public MovableObject() {
    }

    public MovableObject(Planet planet) {
        this.planet = planet;
    }

    protected void setCurrentPos(Coordinate currentPos) {
        this.currentPos = currentPos;
    }

    protected double getDistanceToPlanet() {
        return currentPos.getDistance(planet.getPosition());
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
}
