package Exams.E07JavaOOPExam_15August2021.P02UnitTesting.shopAndGoods;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        this.shop = new Shop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonExistingShelf() throws OperationNotSupportedException {
        shop.addGoods("invalid", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonExistingShelfForEXISTINGgoood() throws OperationNotSupportedException {
        Goods goods = new Goods("aaa", "555");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);

    }

    @Test
    public void testNonExistingShelfForreturncorrMassage() throws OperationNotSupportedException {
        Goods goods = new Goods("aaa", "555");
        Goods goods1 = new Goods("bbb", "666");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test1() throws OperationNotSupportedException {
        shop.removeGoods("invalid", null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test12() throws OperationNotSupportedException {
        Goods goods = new Goods("aaa", "555");
        shop.removeGoods("Shelves1", goods);
    }


}