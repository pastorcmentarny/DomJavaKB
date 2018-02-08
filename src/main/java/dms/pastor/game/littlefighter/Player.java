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
class Player {
    public final Status status = new Status();
    private final Random random = new Random();
    String PlayerName = "Player";
    int PlayerAttack = random.nextInt(9) + 1;
    int PlayerDefence = random.nextInt(9) + 1;
    int PlayerPower = random.nextInt(5) + 1;
    //int PlayerMinDamage = random.nextInt(9) + 1;
    //int PlayerMaxDamage = 2*PlayerMinDamage;
    int PlayerHP = 40 + random.nextInt(40);
    int PlayerShield = 2 * PlayerHP;
    int PlayerArmor = random.nextInt(2);
    int PlayerMana = 100;
    int exp = 0;
    int score = 0;
    int playerLevel = 1;
    private int PlayerShieldRegen = 2;
    int playerManaRegen = 2;
    int kills = 0;
    private String msg;

    public Status getStatus() {
        return status;
    }

    public String levelUp() {
        exp -= 1000;
        playerLevel++;
        PlayerShieldRegen++;
        int bonus = random.nextInt(4);
        switch (bonus) {
            case 0:
                PlayerAttack++;
                PlayerDefence++;
                return "Attack and Defence +1!";
            case 1:
                PlayerAttack++;
                return "Attack +1";
            case 2:
                PlayerDefence++;
                return "Defence +1";
            case 3:
                PlayerShieldRegen++;
                return "Shield regeneration +1";
            case 4:
                playerManaRegen++;
                return "quicker mana regen";
            default:
                PlayerMana += 50;
                return "???";
        }
    }

    public void msg(String string) {
        msg += string;
    }

    public String getMsg() {
        String temp = msg;
        msg = "";
        return temp;

    }
}
