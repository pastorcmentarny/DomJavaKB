package dms.pastor.rpg.game;

import dms.pastor.rpg.game.items.Item;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;

import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT Blog: http://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Bonus {
    private int money = 0;
    private int exp = 0;
    private ArrayList<Item> items = null;

    public Bonus(Unit[] units) {
        items = new ArrayList<>();
        generateBonus(units);
    }

    public Bonus(ArrayList<Item> items) {
        items.addAll(items);
    }

    public Bonus(int money, int exp) {
        this.money = money;
        this.exp = exp;
    }


    private void generateBonus(Unit[] units) {
        for (Unit unit : units) {
            exp += unit.getExpForKill(Hero.getHero().getName());
            money += unit.getMoneyForKill();
            if (unit.inventory.isInventoryNotEmpty()) {
                items.addAll(unit.inventory.getAllInventoryItems());
            }
        }
    }

    public int getMoney() {
        return money;
    }

    public int getExp() {
        return exp;
    }

    public ArrayList<Item> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

}
