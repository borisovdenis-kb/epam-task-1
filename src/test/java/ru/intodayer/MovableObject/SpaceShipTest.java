package ru.intodayer.MovableObject;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.intodayer.Coordinate;
import ru.intodayer.Weapon;


public class SpaceShipTest extends TestCase {

    @Test
    public void testShoot() throws Exception {
        Weapon weapon = new Weapon("Blaster", 20);
        SpaceShip spaceShip = new SpaceShip("Denisko", weapon, 50);
        Coordinate expected1 = spaceShip.getCurrentPos();
        Coordinate expected2 = new Coordinate(49.728912893728198627477574100964,5.99540595859726367369742574018);

        for (double t = 0.0; t < 2.0; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected1, spaceShip.getCurrentPos());

        spaceShip.setCurrentPos(new Coordinate(0.0, 0.0));

        for (double t = 0.0; t < 1.9; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected2, spaceShip.getCurrentPos());
    }
}