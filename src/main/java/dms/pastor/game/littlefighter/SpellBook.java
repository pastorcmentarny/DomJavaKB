package dms.pastor.game.littlefighter;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("MagicNumber")
        //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
class SpellBook {

    public String castMana2Shield(Player player) {

        final int manaCost = 17;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            player.setPlayerShield(player.getPlayerShield() + 13);
            return "\nRecharge Shield spell casted";
        }
        return "";

    }

    public boolean castMagicVampire(Player player, Enemy enemy) {
        final int manaCost = 25;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            enemy.setEnemyHP(enemy.getEnemyHP() - 5);
            player.addHp();
            return true;
        }
        return false;
    }

    boolean castFireBall(Player player, Enemy enemy) {
        final int manaCost = 19;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            int x = enemy.getEnemyHP() - 41 * player.getPlayerLevel();
            enemy.setEnemyHP(x);
            player.addExp(x);
            player.addScore(15);
            return true;
        }
        return false;
    }

    boolean castLightingStrike(Player player, Enemy enemy) {
        final int manaCost = 27;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);

            int enemyHp = enemy.getEnemyHP() - 23 * player.getPlayerLevel();
            enemy.setEnemyHP(enemyHp);
            player.addExp(enemyHp);
            player.addScore(15);
            return true;
        }
        return false;
    }

    boolean castDispel(Player player) {
        final int manaCost = 20;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            player.status.purify();
            return true;
        }
        return false;
    }

}
