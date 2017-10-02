package ru.intodayer.MovableObject;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.intodayer.Coordinate;
import ru.intodayer.Planet;
import ru.intodayer.Weapon;


public class SpaceShipTest extends TestCase {

    @Test
    public void testFlyForward() throws Exception {
        Weapon weapon = new Weapon("Blaster", 20);
        Planet planet = new Planet(1000, new Coordinate(500, 500));
        SpaceShip spaceShip = new SpaceShip("Denisko", weapon, planet,50);

        Coordinate expected1 = new Coordinate(550, 500);
        Coordinate expected2 = new Coordinate(450.0,500.0);
        Coordinate expected3 = new Coordinate(547.5528,484.5492);

        /* test time = 2.0 = PERIOD */
        for (double t = 0.0; t < 2.0; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected1, spaceShip.getCurrentPos());

        spaceShip.setCurrentPos(new Coordinate(0.0, 0.0));

        /* test time = 1.0 = PERIOD / 2 */
        for (double t = 0.0; t < 1; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected2, spaceShip.getCurrentPos());

        spaceShip.setCurrentPos(new Coordinate(0.0, 0.0));

        /* test time = 1.9 */
        for (double t = 0.0; t < 1.9; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected3, spaceShip.getCurrentPos());
    }
}