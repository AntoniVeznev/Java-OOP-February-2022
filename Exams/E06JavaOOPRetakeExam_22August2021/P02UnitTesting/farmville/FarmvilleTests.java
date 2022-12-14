package Exams.E06JavaOOPRetakeExam_22August2021.P02UnitTesting.farmville;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FarmvilleTests {


    private Farm farm = new Farm("SoftUni", 2);
    private Animal cat = new Animal("Cat", 10);
    private Animal dog = new Animal("Dog", 20.5);


    @Test
    public void testConstructorCreateSucsessfully() {
        Farm farm = new Farm("SoftUni", 2);
        Animal cat = new Animal("Cat", 10);
        Animal dog = new Animal("Dog", 20.5);

    }

    @Test
    public void testGetCount() {
        Farm farm = new Farm("SoftUni", 2);
        Animal cat = new Animal("Cat", 10);
        Animal dog = new Animal("Dog", 20.5);
        farm.add(cat);
        farm.add(dog);
        Assert.assertEquals(2, farm.getCapacity());
        Assert.assertEquals("SoftUni", farm.getName());
        Assert.assertEquals("Dog", dog.getType());


    }

    @Test
    public void testCount() {
        List<Animal> animals = new ArrayList<>();
        Farm farm = new Farm("SoftUni", 2);
        Animal cat = new Animal("Cat", 10);
        Animal dog = new Animal("Dog", 20.5);
        farm.add(cat);
        farm.add(dog);
        animals.add(cat);
        animals.add(dog);
        Assert.assertEquals(2, animals.size());

    }

    @Test
    public void testRemove() {
        Farm farm = new Farm("SoftUni", 2);
        Animal cat = new Animal("Cat", 10);
        Animal dog = new Animal("Dog", 20.5);
        farm.add(cat);
        farm.add(dog);
        farm.remove(cat.getType());
        farm.remove(cat.getType());
        Assert.assertEquals(1, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnergy() {
        Farm farm = new Farm("SoftUni", 2);
        Animal cat = new Animal("Cat", 10);
        Animal dog = new Animal("Dog", 20.5);
        Animal monkey = new Animal("Monkey", 24);
        farm.add(cat);
        farm.add(dog);
        farm.add(monkey);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAnimalExists() {
        Farm farm = new Farm("SoftUni", 2);
        Animal cat = new Animal("Cat", 10);
        Animal dog = new Animal("Dog", 20.5);
        Animal monkey = new Animal("Monkey", 24);
        farm.add(cat);
        farm.add(cat);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityZeroError() {
        Farm farm = new Farm("SoftUni", -1);

    }

    @Test(expected = NullPointerException.class)
    public void testLastError() {
        Farm farm = new Farm("", 2);
    }
}
