/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dms.pastor.prototypes.littlefighter;

import java.util.Random;

import static dms.pastor.prototypes.littlefighter.Config.DEFAULT_HEALTH_POINTS;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	https://dominiksymonowicz.com/
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings("ClassWithTooManyFields")
class Player {
    private static final int DEFAULT_PLAYER_MANA_ADDITION = 50;
    public final Status status = new Status();
    private final Random random = new Random();
    // --Commented out by Inspection (15/04/2018 17:20):private String playerName = "Player";
    private int playerAttack = random.nextInt(9) + 1;
    private int playerDefence = random.nextInt(9) + 1;
    private int playerPower = random.nextInt(5) + 1;
    private int playerHp = 2 * DEFAULT_HEALTH_POINTS + random.nextInt(2 * DEFAULT_HEALTH_POINTS);
    private int playerShield = 2 * playerHp;
    private int playerMana = 100;
    private int exp = 0;
    private int score = 0;
    private int playerLevel = 1;
    private int playerShieldRegen = 2;
    private int playerManaRegen = 2;
    private int kills = 0;
    private String msg;

// --Commented out by Inspection START (21/02/2018 15:56):
//    public Random getRandom() {
//        return random;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public String getPlayerName() {
//        return playerName;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerName(String playerName) {
//        playerName = playerName;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getPlayerAttack() {
        return playerAttack;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerAttack(int playerAttack) {
//        this.playerAttack = playerAttack;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getPlayerDefence() {
        return playerDefence;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerDefence(int playerDefence) {
//        this.playerDefence = playerDefence;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getPlayerPower() {
        return playerPower;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerPower(int playerPower) {
//        this.playerPower = playerPower;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getPlayerHp() {
        return playerHp;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerHp(int playerHp) {
//        this.playerHp = playerHp;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getPlayerShield() {
        return playerShield;
    }

    void setPlayerShield(int playerShield) {
        this.playerShield = playerShield;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public int getPlayerArmor() {
//        return playerArmor;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerArmor(int playerArmor) {
//        this.playerArmor = playerArmor;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getPlayerMana() {
        return playerMana;
    }

    void setPlayerMana(int playerMana) {
        this.playerMana = playerMana;
    }

    int getExp() {
        return exp;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setExp(int exp) {
//        this.exp = exp;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    public int getScore() {
        return score;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setScore(int score) {
//        this.score = score;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getPlayerLevel() {
        return playerLevel;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerLevel(int playerLevel) {
//        this.playerLevel = playerLevel;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public int getPlayerShieldRegen() {
//        return playerShieldRegen;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerShieldRegen(int playerShieldRegen) {
//        this.playerShieldRegen = playerShieldRegen;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    private int getPlayerManaRegen() {
        return playerManaRegen;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setPlayerManaRegen(int playerManaRegen) {
//        this.playerManaRegen = playerManaRegen;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    int getKills() {
        return kills;
    }

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setKills(int kills) {
//        this.kills = kills;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

// --Commented out by Inspection START (21/02/2018 15:56):
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
// --Commented out by Inspection STOP (21/02/2018 15:56)

    public Status getStatus() {
        return status;
    }

    void levelUp() {
        exp -= 1000;
        playerLevel++;
        playerShieldRegen++;
        int bonus = random.nextInt(4);
        switch (bonus) {
            case 0 -> {
                playerAttack++;
                playerDefence++;
            }
            case 1 -> {
                playerAttack++;
            }
            case 2 -> {
                playerDefence++;
            }
            case 3 -> {
                playerShieldRegen++;
            }
            case 4 -> {
                playerManaRegen++;
            }
            default -> playerMana += DEFAULT_PLAYER_MANA_ADDITION;
        }
    }

    public void msg(String message) {
        msg += message;
    }

    public String getMsg() {
        String temp = msg;
        msg = "";
        return temp;

    }

    void addHp() {
        playerHp++;
    }

    void addExp(int value) {
        exp += value;
    }

    void addScore(int points) {
        score += points;
    }

    boolean hasNotShield() {
        return playerShield < 0;
    }

    void addHp(int points) {
        playerHp += points;
    }

    void setShieldToZero() {
        playerShield = 0;
    }

    void addPower() {
        playerPower++;
    }

    void addKill() {
        kills++;
    }

    private boolean isAlive() {
        return playerHp > 0;
    }

    boolean isDeath() {
        return !isAlive();
    }

    void addAttack() {
        playerAttack++;
    }

    void addDefence() {
        playerDefence++;
    }

    void reduceHp(int value) {
        playerHp -= value;
    }

    void addShieldPoints(int shieldRegen) {
        playerShield += shieldRegen;
    }

    void regenMana() {
        playerMana += getPlayerManaRegen();
    }
}
