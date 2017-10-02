package ru.intodayer.movableobject.enemy;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import ru.intodayer.Coordinate;
import ru.intodayer.Planet;
import ru.intodayer.Weapon;


public class AlienTest extends TestCase {

    @Test
    public void testShoot() throws Exception {
        Weapon weapon = new Weapon("Pistolet", 30);
        Planet planet = new Planet(1000, new Coordinate(500, 500));
        Alien alien = new Alien(new Coordinate(100, 200), planet, 100, weapon);

        /* test: decrease planet`s health by weapon with damage = 30. 10 times */
        for (int i = 0; i < 10; i++) {
            alien.shoot();
        }
        assertEquals(700, planet.getHealth());

        /* test: decrease planet health while planet is alive by weapon with damage = 30.*/
        while (planet.getHealth() != 0) {
            alien.shoot();
        }
        assertEquals(0, planet.getHealth());
    }

    @Test
    public void testFlyForward() throws Exception {
        Planet planet = new Planet(1000, new Coordinate(500, 500));
        Coordinate startPos = new Coordinate(100, 200);
        Coordinate expected = new Coordinate(100.5333, 200.4);
        Weapon weapon = new Weapon("Pistolet", 30);
        Alien alien = new Alien(startPos, planet, 100, weapon);

        /* test: changes coordinates of asteroid */
        alien.flyForward(0.2);
        assertEquals(expected, alien.getCurrentPos());
    }

}