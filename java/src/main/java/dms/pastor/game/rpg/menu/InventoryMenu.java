package dms.pastor.game.rpg.menu;

import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.commons.Result;
import dms.pastor.game.rpg.items.Action;
import dms.pastor.game.rpg.items.Inventory;
import dms.pastor.game.rpg.items.Item;
import dms.pastor.game.rpg.items.food.FoodItem;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.armor.Armor;
import dms.pastor.game.rpg.items.weapons.Weapon;

import java.util.Scanner;


public class InventoryMenu implements Menu {

    static //FIXME log.er //FIXME log.= //FIXME log.er.get//FIXME log.er(Game.class);
        Scanner scanner = new Scanner(System.in);
    Hero hero = Hero.getHero();

    Inventory inventory;

    public InventoryMenu(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void displayMenu() {
        boolean displayMenu = true;
        while (displayMenu) {
            System.out.println(generateInventoryList());
            System.out.println("Select item:");
            try {
                int selection = scanner.nextInt();
                itemMenu(inventory.getItem(selection - 1));
                if (selection == 0) {
                    displayMenu = false;
                }
            } catch (Exception e) {
                //FIXME log.info("User type some rubbish." + e.getMessage());
                System.out.println("It s No idea what did you choose ...Quiting menu...");
                displayMenu = false;
            }
        }
    }

    public void itemMenu(Item item) {
        if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            genreateActionList(weapon);
        } else if (item instanceof FoodItem) {
            FoodItem food = (FoodItem) item;
            genreateActionList(food);
        } else if (item instanceof Armor) {
            Armor armor = (Armor) item;
            genreateActionList(armor);
        } else {
            genreateActionList(item);
        }
    }

    public void genreateActionList(Item item) {
        boolean displayMenu = true;
        while (displayMenu) {
            StringBuilder sb = new StringBuilder("Actions:\n");
            if (inventory == null || inventory.isInventoryEmpty()) {
                System.out.println("You don't have anything in your inventory");
                displayMenu = false;
                continue;
            } else {
                int counter = 1;
                for (Action action : item.actions) {
                    sb.append(counter).append(". ").append(action.toString()).append("\n");
                    counter++;
                }
            }
            sb.append(Config.LINE_SEPERATOR);
            sb.append("0. Exit");
            System.out.println(sb.toString());
            try {
                int selection = scanner.nextInt();
                int x = 1;
                for (Action action : item.actions) {
                    if (x == selection) {
                        if (action.equals(Action.DROP)) {
                            inventory.throwAway(item);
                            displayMenu = false;
                        }
                        if (action.equals(Action.USE)) {
                            item.use();
                            displayMenu = false;
                        }
                        if (action.equals(Action.WEAR)) {
                            Result r = hero.wear(item);
                            if (r.isSuccess()) {
                                inventory.swap(item, (r.getData()));

                            } else {
                                System.out.println(r.getMessage());
                            }
                            displayMenu = false;
                        }
                        if (action.equals(Action.EQUIPT)) {
                            Result r = hero.equiptWeapon(item);
                            if (r.isSuccess()) {
                                inventory.swap(item, (r.getData()));
                                displayMenu = false;

                            } else {
                                System.out.println(r.getMessage());
                            }
                        }
                        if (action.equals(Action.INFO)) {
                            System.out.println(item.getDescription());
                        }


                    }
                    x++;
                }
                if (selection == 0) {
                    displayMenu = false;
                }
            } catch (Exception e) {
                //FIXME log.info("User type some rubbish." + e.getMessage());
                System.out.println("It s No idea what did you choose ...Quiting menu...");
                displayMenu = false;
            }
        }
    }

    public String generateInventoryList() {
        StringBuilder sb = new StringBuilder("Inventory:\n");
        if (inventory == null || inventory.isInventoryEmpty()) {
            sb.append("You don't have anything in your inventory");
        } else {
            int counter = 1;
            for (Item item : inventory.getAllInventoryItems()) {
                if (item != null) {
                    sb.append(counter).append(". ").append(item.getName()).append("\n");
                    counter++;
                } else {
                    //FIXME log.error("Inventory contains null items!");
                }
            }
        }
        sb.append(Config.LINE_SEPERATOR);
        sb.append("0. Exit");
        return sb.toString();
    }
}
