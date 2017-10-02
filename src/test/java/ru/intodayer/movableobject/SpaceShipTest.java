package ru.intodayer.movableobject;

import org.junit.jupiter.api.*;
import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.intodayer.Coordinate;
import ru.intodayer.movableobject.enemy.Alien;
import ru.intodayer.movableobject.enemy.Asteroid;
import ru.intodayer.Planet;
import ru.intodayer.Weapon;


public class SpaceShipTest extends TestCase {

    @Test
    public void testShoot() throws Exception {
        Planet planet        = new Planet(1000, new Coordinate(500, 500));
        Weapon weaponOne     = new Weapon("Blaster", 20);
        Asteroid asteroidOne = new Asteroid(new Coordinate(100, 200), planet, 100, 100);
        Asteroid asteroidTwo = new Asteroid(new Coordinate(100, 200), planet, 200, 100);
        Alien alienOne       = new Alien(new Coordinate(100, 200), planet, 100, weaponOne);
        Alien alienTwo       = new Alien(new Coordinate(100, 200), planet, 200, weaponOne);
        SpaceShip spaceShip  = new SpaceShip("Denisko", weaponOne, planet,50);

        /* test: decrease asteroid`s health by weaponOne with damage = 20, 3 times*/
        spaceShip.shoot(asteroidOne);
        spaceShip.shoot(asteroidOne);
        spaceShip.shoot(asteroidOne);
        assertEquals(40, asteroidOne.getHealth());

        /* test: decrease alien`s health by weaponOne with damage = 20, 2 times*/
        spaceShip.shoot(alienOne);
        spaceShip.shoot(alienOne);
        assertEquals(60, alienOne.getHealth());

        /* test: raise new weaponOne */
        /* and kill asteroid and alien by weaponOne with damage = 1000 */
        Weapon weaponTwo = new Weapon("Nagibator", 1000);
        spaceShip.setWeapon(weaponTwo);
        spaceShip.shoot(asteroidTwo);
        spaceShip.shoot(alienTwo);
        assertEquals(0, asteroidTwo.getHealth());
        assertEquals(0, alienTwo.getHealth());
    }

    @Test
    public void testFlyForward() throws Exception {
        Weapon weapon = new Weapon("Blaster", 20);
        Planet planet = new Planet(1000, new Coordinate(500, 500));
        SpaceShip spaceShip = new SpaceShip("Denisko", weapon, planet,50);

        Coordinate expected1 = new Coordinate(550, 500);
        Coordinate expected2 = new Coordinate(450.0,500.0);
        Coordinate expected3 = new Coordinate(547.5528,484.5492);

        /* tes: check of spaceShip coordinates. time = 2.0 = PERIOD */
        for (double t = 0.0; t < 2.0; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected1, spaceShip.getCurrentPos());

        spaceShip.setCurrentPos(new Coordinate(0.0, 0.0));

        /* test: check of spaceShip coordinates. time = 1.0 = PERIOD / 2 */
        for (double t = 0.0; t < 1; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected2, spaceShip.getCurrentPos());

        spaceShip.setCurrentPos(new Coordinate(0.0, 0.0));

        /* test: check of spaceShip coordinates. time = 1.9 */
        for (double t = 0.0; t < 1.9; t += 0.0001) {
            spaceShip.flyForward(t);
        }
        assertEquals(expected3, spaceShip.getCurrentPos());
    }
}