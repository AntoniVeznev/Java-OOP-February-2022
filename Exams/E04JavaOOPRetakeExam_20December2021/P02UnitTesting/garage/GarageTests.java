package Exams.E04JavaOOPRetakeExam_20December2021.P02UnitTesting.garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;
import java.util.List;

public class GarageTests {
    private final static int MAX_SPEED = 250;
    private Garage garage;
    private Car porshe;
    private Car mercedes;
    private Car audi;

    @Before
    public void setup() {
        garage = new Garage();
        porshe = new Car("porshe", 300, 1200);
        mercedes = new Car("mercedes", 200, 1500);
        audi = new Car("audi", 220, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testErrorAddToGarage() {
        garage.addCar(null);
    }

    @Test
    public void testAddSucsess() {
        garage.addCar(porshe);
        Assert.assertEquals(1, garage.getCount());
        garage.addCar(mercedes);
        Assert.assertEquals(2, garage.getCount());
    }

    @Test
    public void testGetCarsSucs() {
        garage.addCar(porshe);
        garage.addCar(mercedes);
        garage.addCar(audi);
        List<Car> carsInGarage = garage.getCars();
        Assert.assertEquals(3, garage.getCount());
        Assert.assertEquals("porshe", porshe.getBrand());
    }

    @Test
    public void testMaxSpeedCars() {
        garage.addCar(porshe);
        garage.addCar(mercedes);
        garage.addCar(audi);
        List<Car> carsWithSpeedAbove250 = garage.findAllCarsWithMaxSpeedAbove(250);
        Assert.assertEquals(porshe.getBrand(), carsWithSpeedAbove250.get(0).getBrand());

    }

    @Test
    public void testGiveTheMostExpensiveCar() {
        garage.addCar(porshe);
        garage.addCar(mercedes);
        garage.addCar(audi);
        Car car = garage.getTheMostExpensiveCar();
        Assert.assertEquals(mercedes, car);

    }

    @Test
    public void testFindALLcarsByBRAND() {
        garage.addCar(porshe);
        garage.addCar(mercedes);
        garage.addCar(audi);
        garage.addCar(mercedes);
        List<Car> car = garage.findAllCarsByBrand("mercedes");
        Assert.assertEquals(2, car.size());
    }

}