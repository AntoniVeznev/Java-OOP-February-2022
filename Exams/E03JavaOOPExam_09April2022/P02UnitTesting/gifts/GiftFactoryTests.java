package Exams.E03JavaOOPExam_09April2022.P02UnitTesting.gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {

    private Gift gift;
    private GiftFactory giftFactory;

    @Before
    public void setUp() {
        this.gift = new Gift("toy", 20);
        this.giftFactory = new GiftFactory();
    }

    @Test
    public void testGetCountAndSucsessfullyADDED() {
        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiftExistsError() {
        giftFactory.createGift(gift);
        giftFactory.createGift(gift);

    }


    @Test(expected = NullPointerException.class)
    public void testRemoveNullError1() {
        this.gift = new Gift(null, 20);
        giftFactory.createGift(gift);
        giftFactory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullError2() {
        this.gift = new Gift("", 20);
        giftFactory.createGift(gift);
        giftFactory.removeGift("");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNullError3() {
        this.gift = new Gift(" ", 20);
        giftFactory.createGift(gift);
        giftFactory.removeGift(" ");
    }


    @Test(expected = NullPointerException.class)
    public void testIFnameIsEmpty() {
        this.gift = new Gift("", 20);
        giftFactory.removeGift("");
    }


    @Test
    public void testcorrectRemove() {
        giftFactory.createGift(gift);
        giftFactory.removeGift("toy");
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void testGiftWithLowestMagic() {
        Gift gift1 = new Gift("toy", 10);
        Gift gift2 = new Gift("bear", 20);
        Gift gift3 = new Gift("car", 30);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Gift gift = giftFactory.getPresentWithLeastMagic();
        Assert.assertEquals(gift1, gift);

    }

    @Test
    public void testGetPresentSucsesfully() {
        Gift gift1 = new Gift("toy", 10);
        Gift gift2 = new Gift("bear", 20);
        Gift gift3 = new Gift("car", 30);
        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        Gift gift = giftFactory.getPresent("toy");

        Assert.assertEquals(gift1, gift);

    }


    @Test(expected = UnsupportedOperationException.class)
    public void testCollection() {
        giftFactory.createGift(gift);
        Gift gift2 = new Gift("bear", 10);
        Gift gift3 = new Gift("car", 30);
        giftFactory.createGift(gift2);
        giftFactory.createGift(gift3);
        giftFactory.getPresents().clear();
    }

}
