/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.game.littlefighter;

import java.util.Random;

import static dms.pastor.game.littlefighter.Config.DEFAULT_HEALTH_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Enemy {
    // --Commented out by Inspection (21/02/2018 15:56):protected boolean isUseMagicShield;
    final Random random = new Random();
    final Status statuses = new Status();
    int enemyAttack;
    int enemyDefence;
    int enemyPower;
    int enemyHP;
    //private int EnemyShield = 2*EnemyHP;
    int enemyArmor;
    String enemyName = "Effigy";
    int regen;
    // --Commented out by Inspection (21/02/2018 15:56):boolean isPoisoned;

    Enemy() {
        enemyAttack = random.nextInt(9) + 1;
        enemyDefence = random.nextInt(9) + 1;
        enemyPower = random.nextInt(5) + 1;
        enemyHP = 2 * DEFAULT_HEALTH_POINTS + random.nextInt(3 * DEFAULT_HEALTH_POINTS);
        enemyArmor = random.nextInt(2);
        regen = 1;

    }


    public void upgradeEnemy(int lvl) {
        enemyAttack += lvl;
        enemyDefence += lvl;
        enemyPower += lvl;
        enemyHP += 10 * lvl;
    }

    public String getName() {
        return enemyName;
    }

    public int getEnemyAttack() {
        return enemyAttack;
    }

    public int getEnemyDefence() {
        return enemyDefence;
    }

    public int getEnemyPower() {
        return enemyPower;
    }

    public int getEnemyHP() {
        return enemyHP;
    }

    public void setEnemyHP(int hp) {
        enemyHP = hp;
    }

    public int getEnemyArmor() {
        return enemyArmor;
    }

    public int getRegen() {
        return regen;
    }

    /*
     * enemy level is equal to power of add-on to spell
     */
    public boolean addOnToAttack(Player player) {
        return false;
    }

}
