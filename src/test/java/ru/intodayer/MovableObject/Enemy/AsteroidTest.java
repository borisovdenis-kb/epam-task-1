package ru.intodayer.MovableObject.Enemy;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import ru.intodayer.Coordinate;
import ru.intodayer.Planet;


public class AsteroidTest extends TestCase {

    @Test
    public void testFlyForward() throws Exception {
        Planet planet = new Planet(1000, new Coordinate(500, 500));
        Coordinate startPos = new Coordinate(100, 200);
        Coordinate expected = new Coordinate(100.5333, 200.4);
        Asteroid asteroid = new Asteroid(startPos, planet, 100, 100);

        /* test: changes coordinates of asteroid */
        asteroid.flyForward(0.2);
        assertEquals(expected, asteroid.getCurrentPos());
    }

    @Test
    public void testCrash() throws Exception {
        Coordinate startPos = new Coordinate(100, 200);
        Planet planet = new Planet(1000, new Coordinate(500, 500));

        /* test: asteroids crash into the planet. 3 times */
        for (int i = 0; i < 3; i++) {
            Asteroid asteroid = new Asteroid(startPos, planet, 100, 155);
            asteroid.crash();
        }
        assertEquals(535, planet.getHealth());

        /* test: asteroids crash into the planet while planet is alive */
        while (planet.getHealth() != 0) {
            Asteroid asteroid = new Asteroid(startPos, planet, 100, 155);
            asteroid.crash();
        }
        assertEquals(0, planet.getHealth());
    }
}