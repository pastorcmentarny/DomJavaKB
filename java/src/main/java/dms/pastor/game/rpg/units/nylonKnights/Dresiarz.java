package dms.pastor.game.rpg.units.nylonKnights;

import dms.pastor.game.rpg.characteristics.Attribute;
import dms.pastor.game.rpg.characteristics.Skills;
import dms.pastor.game.rpg.characteristics.Stats;
import dms.pastor.game.rpg.items.weapons.BaseballBat;
import dms.pastor.game.rpg.units.Hero;
import dms.pastor.game.rpg.units.Unit;
import dms.pastor.game.rpg.units.enemies.Enemy;


public class Dresiarz extends Enemy {

    public Dresiarz(int level) {
        name = this.getClass().getSimpleName();
        description = " It looks cute,but it is deadly undead animal who sucks your life . ";//TODO implement id
        this.lvl = level;
        psycho = false;
        skills = new Skills(8, 1, 1, 4, 4, 0);
        setup();
        bonusPerLevelStats = new Stats(1, 3, 1, 0, 20, 20, 0, 0, 0, 0, 0, 0);
        plainStats = Stats.generateStatsFromSkills(skills);
        updateLevelFromTo(1, lvl);
        plainStats.addArm(lvl / 3);
        BaseballBat bb = new BaseballBat();
        inventory.addItem(bb);
        bb.addToStats(plainStats);
    }

    @Override
    public boolean avoidFightDiplomacy(Unit unit) {
        return Hero.getHero().nativeAttributes.contains(Attribute.STUDENT_SPORT);
    }

    @Override
    public void beforeBattle() {
        System.out.println("Chcesz wpier..? - spytał kulturalnie");
    }

    @Override
    public void afterBattle() {
        System.out.println("Jeszcze się spotkamy ... i wtedy ci pokaże");
    }

    @Override
    public void specialAttack(Unit unit) {
        //TODO Friends summon (1% summon 3 friends 4% summon a friend) 
    }
}
