package dms.pastor.rpg.game.spells;

import dms.pastor.rpg.game.characteristics.Attribute;
import dms.pastor.domain.Result;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;


public class Fireball extends Spell {

    private final Unit caster;

    public Fireball(Unit caster) {
        this.caster = caster;
    }

    @Override
    public Result cast(Hero hero) {
        return calcDmg(hero);
    }

    @Override
    public Result cast(Unit unit) {
        return calcDmg(unit);
    }

    @Override
    public Result cast(Hero hero, Unit[] units) {
        return null;
    }

    private Result calcDmg(Unit unit) {
        if (unit.currentAttributes.contains(Attribute.MAGIC_RESISTANCE100)) {
            return new Result(false, "You are immune to magic");
        }
        int dmg = caster.skills.getPsychokinesis() * 10;

        if (unit.currentAttributes.contains(Attribute.MAGIC_RESISTANCE50)) {
            return calcDmgWithResistance(unit, dmg, 50);
        }
        if (unit.currentAttributes.contains(Attribute.MAGIC_RESISTANCE10)) {
            return calcDmgWithResistance(unit, dmg, 10);
        }

        return calcDmgWithResistance(unit, dmg, 1);//1% lucky
    }

    private Result calcDmgWithResistance(Unit unit, int damage, int resistancePercentage) {
        int dmg = damage - (damage * resistancePercentage / 100);
        if (random.nextInt(101) > resistancePercentage) {
            unit.battleStats.doesDMG(dmg, 0);
            return new Result(true, "Fireball hits you and caused " + dmg + " dmg");
        } else {
            return new Result(false, "You resist damage from Fireball.");
        }
    }
}
