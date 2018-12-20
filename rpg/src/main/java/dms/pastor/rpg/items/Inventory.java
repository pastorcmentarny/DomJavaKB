package dms.pastor.rpg.items;

import dms.pastor.rpg.cfg.Config;

import java.util.ArrayList;


public class Inventory {

    private final int size;
    private final ArrayList<Item> items;

    public Inventory(int size) {
        this.size = size;
        items = new ArrayList<>(size);
    }

    public int getSize() {
        return size;
    }

    public boolean isInventoryFull() {
        return items.size() >= size;
    }

    public boolean isInventoryNotFull() {
        return !isInventoryFull();
    }

    public boolean addItem(Item item) {
        if (items.size() >= size) {
            return false;
        } else {
            items.add(item);
            return true;
        }
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public ArrayList<Item> getAllInventoryItems() {
        return new ArrayList<>(items);
    }

    public ArrayList<Item> takeAllItems() {
        ArrayList<Item> all = new ArrayList<>(items);
        items.clear();
        return all;
    }

    public boolean isInventoryEmpty() {
        return items.isEmpty();
    }

    public boolean isInventoryNotEmpty() {
        return !isInventoryEmpty();
    }

    void displayInventory() {
        System.out.println(Config.LINE_SEPARATOR_INVENTORY);
        if (items.isEmpty()) {
            System.out.println("Inventory is empty");
        } else {
            int counter = 1;
            for (Item item : items) {
                System.out.println("|" + counter + "| " + item.toString());
            }
        }
        System.out.println(Config.LINE_SEPARATOR_INVENTORY);
    }

    public boolean hasItem(String itemName) {
        if (items == null || items.isEmpty()) {
            return false;
        } else {
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Item getItemByName(String itemName) {
        if (items.isEmpty()) {
            return null;
        } else {
            Item tmp = null;
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(itemName)) {
                    tmp = item;
                }
            }
            if (tmp != null) {
                items.remove(tmp);
                return tmp;
            }
        }
        return null;
    }

    public void addItems(Item item, int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean throwAway(Item item) {
        return items.remove(item);
    }

    public boolean swap(Item item, Object object) {
        throwAway(item);
        if (object != null) {
            addItem((Item) object);
            return true;
        } else {
            return false;
        }
    }

}
