package models;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Guest on 1/10/18.
 */
public class ItemTest {
    public Item setupPackedItem() {
        Item packedItem = new Item("backpack", 200, true, 10, "REI");
        packedItem.setPacked();
        return packedItem;
    }

    public Item setupUnpackedItem() {
        Item unpackedItem = new Item("backpack", 200, true, 10, "REI");
        return unpackedItem;
    }
    public Item setupPurchasedItem() {
        Item purchasedItem = new Item("backpack", 200, true, 10, "REI");
        return purchasedItem;
    }
    public Item setupUnpurchasedItem() {
        Item unpurchasedItem = new Item("backpack", 200, false, 10, "REI");
        return unpurchasedItem;
    }

    @After
    public void tearDown() {
        Item.clearAllItems();
    }

    @Test
    public void itemsInstantiatesCorrectly_true() {
        Item testItem = setupPackedItem();
        assertEquals(true, testItem instanceof Item);
    }

    @Test
    public void setPacked_changesPackedValueToTrue_true() throws Exception {
        Item testItem = setupUnpackedItem();
        testItem.setPacked();
        assertTrue(testItem.isPacked());
    }

    @Test
    public void getUnpackedItems_returnsAllItemsWithPackedEqualsFalse_2() throws Exception {
        Item firstTestItem = setupUnpackedItem();
        Item secondTestItem = setupUnpackedItem();
        Item packedTestItem = setupPackedItem();
        assertEquals(2, Item.getAllUnpacked().size());
    }

    @Test
    public void getPackedItems_returnsAllItemsWithPakcedEqualsTrue_3() throws Exception {
        Item firstTestItem = setupPackedItem();
        Item secondTestItem = setupPackedItem();
        Item thirdTestItem = setupPackedItem();
        Item unpackedTestItem = setupUnpackedItem();
        assertEquals(3, Item.getAllPacked().size());
    }
    @Test
    public void getPurchasedItems_returnsAllItemsWithPurchasedEqualsTrue_2() throws Exception {
        Item firstTestItem = setupPurchasedItem();
        Item secondTestItem = setupPurchasedItem();
        Item unpurchasedItem = setupUnpurchasedItem();
        assertEquals(2, Item.getAllPurchased().size());
    }
    @Test
    public void getUnpurchasedItems_returnsAllItemsWithPurchasedEqualsFalse_3() throws Exception {
        Item firstTestItem = setupUnpurchasedItem();
        Item secondTestItem = setupUnpurchasedItem();
        Item thirdTestItem = setupUnpurchasedItem();
        Item purchasedItemTest = setupPurchasedItem();
        assertEquals(3, Item.getAllUnpurchased().size());
    }
    @Test
    public void setUnpurchased_returnsPurchased_true() throws Exception {
        Item testItem = setupPurchasedItem();
        assertEquals(true, testItem.isPurchased());
    }
}