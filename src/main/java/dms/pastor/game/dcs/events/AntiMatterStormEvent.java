package dms.pastor.game.dcs.events;

import dms.pastor.game.dcs.units.Unit;

import static dms.pastor.game.dcs.events.Rarity.RARE;

public class AntiMatterStormEvent extends Event {

    public AntiMatterStormEvent() {
        rarity = RARE;
        setDescription("An awful storm hit area of battle of these 2 heroes ...");
    }

    @Override
    public String makeItHappen(Unit unit1, Unit unit2) {
        unit1.doesShieldDamage(unit1.getElements().countElements());
        unit1.doesDirectDamage(unit1.getElements().countElements() / 2);
        unit1.getElements().removeRandomElements(unit1.getElements().countElements() / 2);
        unit2.doesShieldDamage(unit2.getElements().countElements());
        unit2.doesDirectDamage(unit2.getElements().countElements() / 2);
        unit2.getElements().removeRandomElements(unit2.getElements().countElements() / 2);
        return "Anti matter storm caused serious damages to all units in area.";
    }
}
