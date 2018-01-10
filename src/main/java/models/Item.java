package models;

import java.util.ArrayList;

/**
 * Created by Guest on 1/10/18.
 */
public class Item {
    private String name;
    private int price;
    private boolean purchased;
    private int weight;
    private String manufacturer;
    private boolean packed;
    private static ArrayList<Item>instances = new ArrayList<>();
    private int id;

    public Item(String name, int price, boolean purchased, int weight, String manufacturer) {
        this.name = name;
        this.price = price;
        this.purchased=purchased;
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.packed = false;
        instances.add(this);
        this.id = instances.size();

    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public int getWeight() {
        return weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isPacked() {
        return packed;
    }

    public static ArrayList<Item> getAll() {
        return instances;
    }

    public int getId() {
        return id;
    }

    public boolean setPacked() {
        this.packed = true;
        return packed;
    }

    public static void clearAllItems() {
        instances.clear();
    }

    public static ArrayList<Item> getAllUnpacked() {
        ArrayList<Item> returnAllUnpacked = new ArrayList<>();
        for (Item item : instances) {
            if (!item.isPacked()) {
                returnAllUnpacked.add(item);
            }
        }
        return returnAllUnpacked;
    }

    public static ArrayList<Item> getAllPacked() {
        ArrayList<Item> returnAllPacked = new ArrayList<>();
        for (Item item : instances) {
            if (item.isPacked()) {
                returnAllPacked.add(item);
            }
        }
        return returnAllPacked;
    }
    public static ArrayList<Item> getAllPurchased() {
        ArrayList<Item> returnAllPurchased = new ArrayList<>();
        for (Item item : instances) {
            if (item.isPurchased()) {
                returnAllPurchased.add(item);
            }
        }
        return returnAllPurchased;
    }
    public static ArrayList<Item> getAllUnpurchased() {
        ArrayList<Item> returnAllUnpurchased = new ArrayList<>();
        for (Item item : instances) {
            if (!item.isPurchased()) {
                returnAllUnpurchased.add(item);
            }
        }
        return returnAllUnpurchased;
    }
}
