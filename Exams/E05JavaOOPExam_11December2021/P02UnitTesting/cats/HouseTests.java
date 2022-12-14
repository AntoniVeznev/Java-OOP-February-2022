package Exams.E05JavaOOPExam_11December2021.P02UnitTesting.cats;

import org.junit.Assert;
import org.junit.Test;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;

public class HouseTests {
    Cat cat = new Cat("Tom");
    Cat cat1 = new Cat("Miki");
    House house = new House("ViCity", 2);
    House house1 = new House("SanAndreas", 3);

    @Test
    public void testConstructor() {
        House house = new House("ViCity", 2);
        Assert.assertEquals(2, house.getCapacity());
    }

    @Test
    public void testGetName() {
        House house = new House("ViCity", 2);
        Assert.assertEquals("ViCity", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetName() {
        House house = new House(" ", 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity() {
        House house = new House("ViCity", -1);

    }

    @Test
    public void testGetCount() {
        Collection<Cat> cat0 = new ArrayList<>();
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Miki");
        House house = new House("ViCity", 2);
        house.addCat(cat1);
        house.addCat(cat2);
        cat0.add(cat1);
        cat0.add(cat2);
        Assert.assertEquals(2, cat0.size());
        Assert.assertEquals(2, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatError() {
        House house = new House("ViCity", 2);
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Miki");
        Cat cat3 = new Cat("Toni");
        house.addCat(cat1);
        house.addCat(cat2);
        house.addCat(cat3);

    }

    @Test
    public void testRemovingCat() {
        House house = new House("ViCity", 2);
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Miki");
        house.addCat(cat1);
        house.addCat(cat2);
        house.removeCat("Tom");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatException() {
        House house = new House("ViCity", 2);
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Miki");
        house.addCat(cat1);
        house.addCat(cat2);
        house.removeCat("Toni");
    }

    @Test
    public void testCatForSale() {
        House house = new House("ViCity", 2);
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Miki");
        house.addCat(cat1);
        house.addCat(cat2);
        house.catForSale("Tom");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorSale() {
        House house = new House("ViCity", 2);
        Cat cat1 = new Cat("Tom");
        house.addCat(cat1);
        house.catForSale("Tom");
        house.catForSale("TIMI");
    }

}
