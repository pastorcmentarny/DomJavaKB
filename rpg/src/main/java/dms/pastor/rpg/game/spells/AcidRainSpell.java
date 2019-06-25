package dms.pastor.rpg.game.spells;

import dms.pastor.rpg.game.commons.Result;
import dms.pastor.rpg.game.units.Hero;
import dms.pastor.rpg.game.units.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author domhome //it cause random damage to all units
 */
public class AcidRainSpell extends Spell {

    private final Random random = new Random();
    private final Unit caster;

    public AcidRainSpell(Unit unit) {
        caster = unit;
    }

    @Override
    public Result cast(Hero hero) {
        int rainDrops = 5 + hero.skills.getPsychokinesis() * 3 + hero.lvl;
        int dmg = (caster.skills.getPsychokinesis() - 1) + caster.lvl / 5;

        for (int i = 0; i < rainDrops; i++) {
            if (random.nextBoolean()) {
                hero.battleStats.doesDirectDMGtoHP(dmg);
                System.out.println(hero.getName() + " was hit by raindrop and got" + dmg + " dmg.");
            } else {
                if (random.nextBoolean()) {
                    caster.battleStats.doesDirectDMGtoHP(1);
                    System.out.println(caster.getName() + " was hit by raindrop and got" + dmg + " dmg.");
                } else {
                    System.out.println("Raindrop missed everybody");
                }
            }
        }
        return new Result(true, "Spell casted");
    }

    @Override
    public Result cast(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Result cast(Hero hero, Unit[] units) {
        //20% for miss , each rain does 3dmg/psychokinesis
        ArrayList<Unit> allUnits = new ArrayList<>(units.length + 1);
        allUnits.addAll(Arrays.asList(units));
        allUnits.addAll(Arrays.asList(units)); //increase chance of rainbow will hit enemy
        allUnits.add(hero);
        int rainDrops = 5 + hero.skills.getPsychokinesis() * 3 + hero.lvl;
        int dmg = (caster.skills.getPsychokinesis() - 1) + caster.lvl / 5;
        int numbers = allUnits.size() + 1;
        for (int i = 0; i < rainDrops; i++) {
            int selection = random.nextInt(numbers);
            System.out.println("selection" + selection);
            if (selection >= allUnits.size()) {
                System.out.println("Raindrop missed everybody");
            } else {
                allUnits.get(selection).battleStats.doesDirectDMGtoHP(dmg);
                System.out.println(allUnits.get(selection).getName() + " was hit by raindrop and got" + dmg + " dmg.");
            }
        }
        return new Result(true, "Spell casted");
    }
}
