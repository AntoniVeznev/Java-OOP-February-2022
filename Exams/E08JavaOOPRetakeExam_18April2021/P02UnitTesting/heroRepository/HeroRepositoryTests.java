package Exams.E08JavaOOPRetakeExam_18April2021.P02UnitTesting.heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HeroRepositoryTests {
    private Hero hero;
    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.hero = new Hero("Toni", 5);
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void test1() {
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        Hero hero1 = new Hero("Toni", 5);
        Hero hero2 = new Hero("Toni", 10);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
    }

    @Test(expected = NullPointerException.class)
    public void test4() {
        Hero hero = new Hero("", 5);
        heroRepository.remove(hero.getName());
    }

    @Test
    public void test5() {
        Hero hero1 = new Hero("Toni", 5);
        heroRepository.create(hero1);
        heroRepository.remove("Toni");
    }

    @Test
    public void test6() {
        Hero hero1 = new Hero("Iwan", 5);
        Hero hero2 = new Hero("Petar", 10);
        Hero hero3 = new Hero("Toni", 15);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);
        Assert.assertEquals("Toni", heroRepository.getHeroWithHighestLevel().getName());
    }

    @Test
    public void test7() {
        Hero hero1 = new Hero("Iwan", 5);
        Hero hero2 = new Hero("Petar", 10);
        Hero hero3 = new Hero("Toni", 15);
        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);

        Hero toni = heroRepository.getHero("Toni");

        Assert.assertEquals(toni, heroRepository.getHero("Toni"));

    }

}
