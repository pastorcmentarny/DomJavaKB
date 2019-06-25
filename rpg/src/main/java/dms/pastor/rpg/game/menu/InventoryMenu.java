package dms.pastor.rpg.game.menu;

import dms.pastor.rpg.game.armor.Armor;
import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.commons.Result;
import dms.pastor.rpg.game.items.Action;
import dms.pastor.rpg.game.items.Inventory;
import dms.pastor.rpg.game.items.Item;
import dms.pastor.rpg.game.items.food.FoodItem;
import dms.pastor.rpg.game.items.weapons.Weapon;
import dms.pastor.rpg.game.units.Hero;

import java.util.Scanner;


public class InventoryMenu implements Menu {

    private static final //FIXME log.er //FIXME log.= //FIXME log.er.get//FIXME log.er(Game.class);
        Scanner scanner = new Scanner(System.in);
    private final Hero hero = Hero.getHero();

    private final Inventory inventory;

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

    private void itemMenu(Item item) {
        if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            generateActionList(weapon);
        } else if (item instanceof FoodItem) {
            FoodItem food = (FoodItem) item;
            generateActionList(food);
        } else if (item instanceof Armor) {
            Armor armor = (Armor) item;
            generateActionList(armor);
        } else {
            generateActionList(item);
        }
    }

    private void generateActionList(Item item) {
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
            sb.append(Config.LINE_SEPARATOR);
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
                        if (action.equals(Action.EQUIP)) {
                            Result r = hero.equipWeapon(item);
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

    private String generateInventoryList() {
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
        sb.append(Config.LINE_SEPARATOR);
        sb.append("0. Exit");
        return sb.toString();
    }
}
