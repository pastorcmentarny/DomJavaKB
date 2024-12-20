package dms.pastor.rpg.game.armor;


import dms.pastor.domain.Result;

import java.util.ArrayList;


/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class UnitArmors {
    private static final ArrayList<Armor> armorList = new ArrayList<>();
    private final ArmorType[] availableTypes;

    public UnitArmors(ArmorType[] types) {
        this.availableTypes = types;
    }

    public int getTotalARM() {
        if (!armorList.isEmpty()) {
            int arm = 0;
            for (Armor armor : armorList) {
                arm += armor.getArmorPoints();
            }
            return arm;
        } else {
            return 0;
        }
    }

    public Result wearArmor(Armor armor) {
        if (canWearIt(armor.getType())) {
            if (isWearThisTypeOfArmor(armor.getType())) {
                Armor oldArmor = removeArmorByType(armor.getType());
                armorList.add(armor);
                return new Result(true, oldArmor.getName() + " armor is swap by " + armor.getName(), oldArmor);
            } else {
                armorList.add(armor);
                return new Result(true, " wear " + armor.getName());
            }
        } else {
            return new Result(false, " can't wear this armor");
        }
    }

    public Result takeOffArmor(ArmorType type) {
        Armor temp = null;
        if (isWearThisTypeOfArmor(type)) {
            temp = removeArmorByType(type);
        }
        if (temp != null) {
            return new Result(true, "  take Off " + temp.getName(), temp);
        }
        return new Result(false, "Unable to  take off this armor.");
    }

    private boolean canWearIt(ArmorType type) {
        for (ArmorType armorType : availableTypes) {
            if (type.equals(armorType)) {
                return true;
            }
        }
        return false;
    }

    private boolean isWearThisTypeOfArmor(ArmorType type) {
        for (Armor armor : armorList) {
            if (armor.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    private Armor removeArmorByType(ArmorType type) {
        Armor removedArmor = null;
        for (Armor armor : armorList) {
            if (armor.getType().equals(type)) {
                removedArmor = armor;
            }
        }
        if (removedArmor != null) {
            armorList.remove(removedArmor);
        }
        return removedArmor;
    }

    @Override
    public String toString() {
        StringBuilder armors = new StringBuilder();
        for (Armor armor : armorList) {
            armors.append(armor.getName()).append(" ");
        }
        return "UnitArmors{" + "armorList=" + armors + '}';
    }


}
