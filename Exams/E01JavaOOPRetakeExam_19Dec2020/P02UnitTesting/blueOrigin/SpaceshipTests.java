package Exams.E01JavaOOPRetakeExam_19Dec2020.P02UnitTesting.blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Astronaut astronaut;
    private Spaceship spaceship;


    @Before
    public void setUp() {
        this.astronaut = new Astronaut("Maria", 10);
        this.spaceship = new Spaceship("MariaShip", 2);
    }

    @Test
    public void testHowMuchPplAreInTheShip() {
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void testWhatIsTheNameOfTheShip() {
        spaceship.add(astronaut);
        Assert.assertEquals("MariaShip", spaceship.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowErrorIfCapacityIsIncorrect() {
        Astronaut astronaut2 = new Astronaut("Toni", 20);
        Astronaut astronaut3 = new Astronaut("Ivan", 30);
        spaceship.add(astronaut);
        spaceship.add(astronaut2);
        spaceship.add(astronaut3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowErrorIfWeHaveTheSamePerson() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void testRemoveAustronaut() {
        spaceship.add(astronaut);
        spaceship.remove(astronaut.getName());
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowErrorIfCapacityIsLowerThenZero() {
        this.spaceship = new Spaceship("Viktoria", -1);
        spaceship.add(astronaut);
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsNull() {
        spaceship = new Spaceship(null, 2);
        spaceship.getName();
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsEmpty() {
        spaceship = new Spaceship(" ", 2);
        spaceship.getName();
    }
}
