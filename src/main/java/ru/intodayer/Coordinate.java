package ru.intodayer;


public class Coordinate {
    public final double MAX_OX = 1000.0;
    public final double MAX_OY = 1000.0;
    private double x;
    private double y;

    public Coordinate() {
        x = 0.0;
        y = 0.0;
    }

    public Coordinate(Coordinate coordinate) {
        x = coordinate.getX();
        y = coordinate.getY();
    }

    public Coordinate(double x, double y) {
        this.x = checkX(x);
        this.y = checkY(y);
    }

    private double checkX(double x) {
        if (x >= 0 && x < MAX_OX) {
            return x;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private double checkY(double y) {
        if (y >= 0 && y < MAX_OX) {
            return y;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = checkX(x);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = checkY(y);
    }

    public double getDistance(Coordinate coordinate) {
        return Math.sqrt(Math.pow(Math.abs(coordinate.x - x), 2) + Math.pow(Math.abs(coordinate.y - y), 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (Double.compare(that.x, x) != 0) return false;
        return Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Coordinate(x: " + x + ", y: " + y + ')';
    }
}
