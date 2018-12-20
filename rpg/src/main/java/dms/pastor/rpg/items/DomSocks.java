package dms.pastor.rpg.items;

import dms.pastor.rpg.units.Unit;
import dms.pastor.rpg.commons.Result;


public class DomSocks extends Item {
    private final int dmg = 8192;

    public DomSocks() {
        name = "Dom's socks";
        description = " most deadly throwing biological weapon that works against undead ,robots and aliens";
        isUsableInBattle = true;
    }

    @Override
    public Result use() {
        return new Result(false, "You don't wear them... You don't eat radioactive food ,because it will kill.The same with Dom's socks ,you don't want wear them,if you want be alive ");
    }


    @Override
    public Result useInBattle(Unit unit) {
        unit.battleStats.doesDirectDMGtoHP(dmg);
        return new Result(true, name + " hits " + unit.getName() + " and does " + dmg + "dmg");
    }

}
