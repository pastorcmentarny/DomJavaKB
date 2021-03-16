package dms.pastor.prototypes.littlefighter;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("MagicNumber")
        //TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
class SpellBook {
    private boolean isSuccess = false;

    String castMana2Shield(Player player) {

        final int manaCost = 17;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            player.setPlayerShield(player.getPlayerShield() + 13);
            return "\nRecharge Shield spell casted";
        }
        return "";

    }

    void castMagicVampire(Player player, Enemy enemy) {
        isSuccess = false;
        final int manaCost = 25;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            enemy.setEnemyHP(enemy.getEnemyHP() - 5);
            player.addHp();
            isSuccess = true;
        }
        isSuccess = false;
    }

    void castFireBall(Player player, Enemy enemy) {
        isSuccess = false;
        final int manaCost = 19;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            int x = enemy.getEnemyHP() - 41 * player.getPlayerLevel();
            enemy.setEnemyHP(x);
            player.addExp(x);
            player.addScore(15);
            isSuccess = true;
        }
        isSuccess = false;
    }

    void castLightingStrike(Player player, Enemy enemy) {
        isSuccess = false;
        final int manaCost = 27;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);

            int enemyHp = enemy.getEnemyHP() - 23 * player.getPlayerLevel();
            enemy.setEnemyHP(enemyHp);
            player.addExp(enemyHp);
            player.addScore(15);
            isSuccess = true;
        }
        isSuccess = false;
    }

    void castDispel(Player player) {
        final int manaCost = 20;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            player.status.purify();
            isSuccess = true;
        }
        isSuccess = false;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
