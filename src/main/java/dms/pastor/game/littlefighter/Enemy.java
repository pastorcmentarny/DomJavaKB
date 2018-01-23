/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.game.littlefighter;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Enemy {
    protected int enemyAttack;
    protected int enemyDefence;
    protected int enemyPower;
    protected int enemyHP;
    //private int EnemyShield = 2*EnemyHP;
    protected int enemyArmor;
    protected boolean isUseMagicShield;
    Random random = new Random();
    String enemyName = "Effigy";
    Status statuses = new Status();
    int regen;
    boolean isPoisoned;

    public Enemy() {
        enemyAttack = random.nextInt(9) + 1;
        enemyDefence = random.nextInt(9) + 1;
        enemyPower = random.nextInt(5) + 1;
        //int EnemyMinDamage = random.nextInt(9) + 1;
        //int EnemyMaxDamage = 2*EnemyMinDamage;
        enemyHP = 40 + random.nextInt(40);
        //int EnemyShield = 2*EnemyHP;
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
