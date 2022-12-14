package Exams.E02JavaOOPExam_10April2021.P02UnitTesting.aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {

    private Aquarium aquarium;
    private Fish fish;


    @Before
    public void setUp() {
        this.aquarium = new Aquarium("Aquarium", 2);
        this.fish = new Fish("Toni");
    }

    @Test
    public void test() {
        Assert.assertEquals("Aquarium", aquarium.getName());
        Assert.assertEquals(2, aquarium.getCapacity());
        Assert.assertEquals("Toni", fish.getName());
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        Aquarium aquarium = new Aquarium(null, 2);
        aquarium.add(fish);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        Aquarium aquarium = new Aquarium("Aquarium", -1);
        aquarium.add(fish);
    }

    @Test
    public void test4() {
        aquarium.add(fish);
        Fish fish = new Fish("Maria");
        aquarium.add(fish);
        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test5() {
        aquarium.add(fish);
        Fish fish = new Fish("Maria");
        aquarium.add(fish);
        Fish fish3 = new Fish("Maria");
        aquarium.add(fish3);
    }

    @Test
    public void test6() {
        Fish fish1 = new Fish("Toni");
        Fish fish2 = new Fish("Bisi");
        Fish fish3 = new Fish("Mimi");
        Fish fish4 = new Fish("Ivan");
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.remove("Toni");
        Assert.assertEquals(1, aquarium.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {
        Fish fish1 = new Fish("Toni");
        Fish fish2 = new Fish("Bisi");
        Fish fish3 = new Fish("Mimi");
        Fish fish4 = new Fish("Ivan");
        aquarium.add(fish1);
        aquarium.add(fish2);
        aquarium.remove("");
    }

    @Test
    public void test8() {
        Fish fish1 = new Fish("Toni");
        Fish fish2 = new Fish("Bisi");
        aquarium.add(fish1);
        aquarium.add(fish2);
        Fish fish = aquarium.sellFish("Toni");
        Assert.assertEquals(fish, aquarium.sellFish("Toni"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test9() {
        Fish fish1 = new Fish("Toni");
        Fish fish2 = new Fish("Bisi");
        aquarium.add(fish1);
        aquarium.add(fish2);
        Fish fish = aquarium.sellFish("Pepi");
        aquarium.sellFish("Pepi");
    }

}

