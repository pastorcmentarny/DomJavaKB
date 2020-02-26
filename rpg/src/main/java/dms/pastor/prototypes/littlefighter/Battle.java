package dms.pastor.prototypes.littlefighter;

import javax.swing.*;
/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class Battle {
    //Round
    //private int dmg;


    int playerAttack(Player player, Enemy enemy) {
        int dmg = (player.getPlayerAttack() * player.getPlayerPower()) - (enemy.getEnemyDefence() * enemy.getEnemyPower()) - enemy.getEnemyArmor();
        if (dmg < 0) {
            return 0;
        } else {
            player.addExp(dmg);
            player.addScore(dmg);
            enemy.setEnemyHP(enemy.getEnemyHP() - dmg);
            return dmg;

        }

    }

    int enemyAttack(Player player, Enemy enemy, JTextArea console) {
        boolean isIt = enemy.addOnToAttack(player);
        if (isIt) {
            console.setText(console.getText() + player.getMsg());
        }
        int dmg = (enemy.getEnemyAttack() * enemy.getEnemyPower()) - (player.getPlayerDefence() * player.getPlayerPower());
        if (dmg < 0) {
            return 0;
        } else {
            return dmg;
        }
    }


}
