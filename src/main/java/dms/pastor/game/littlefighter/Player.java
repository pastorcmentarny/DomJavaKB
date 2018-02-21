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
class Player {
    public final Status status = new Status();
    private final Random random = new Random();
    String PlayerName = "Player";
    private int playerAttack = random.nextInt(9) + 1;
    private int playerDefence = random.nextInt(9) + 1;
    private int playerPower = random.nextInt(5) + 1;
    private int playerHp = 2 * DEFAULT_HEALTH_POINTS + random.nextInt(2 * DEFAULT_HEALTH_POINTS);
    private int playerShield = 2 * playerHp;
    private int playerArmor = random.nextInt(2);
    private int playerMana = 100;
    private int exp = 0;
    private int score = 0;
    private int playerLevel = 1;
    private int playerShieldRegen = 2;
    private int playerManaRegen = 2;
    private int kills = 0;
    private String msg;

    public Random getRandom() {
        return random;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public int getPlayerAttack() {
        return playerAttack;
    }

    public void setPlayerAttack(int playerAttack) {
        this.playerAttack = playerAttack;
    }

    public int getPlayerDefence() {
        return playerDefence;
    }

    public void setPlayerDefence(int playerDefence) {
        this.playerDefence = playerDefence;
    }

    public int getPlayerPower() {
        return playerPower;
    }

    public void setPlayerPower(int playerPower) {
        this.playerPower = playerPower;
    }

    public int getPlayerHp() {
        return playerHp;
    }

    public void setPlayerHp(int playerHp) {
        this.playerHp = playerHp;
    }

    public int getPlayerShield() {
        return playerShield;
    }

    public void setPlayerShield(int playerShield) {
        this.playerShield = playerShield;
    }

    public int getPlayerArmor() {
        return playerArmor;
    }

    public void setPlayerArmor(int playerArmor) {
        this.playerArmor = playerArmor;
    }

    public int getPlayerMana() {
        return playerMana;
    }

    public void setPlayerMana(int playerMana) {
        this.playerMana = playerMana;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerShieldRegen() {
        return playerShieldRegen;
    }

    public void setPlayerShieldRegen(int playerShieldRegen) {
        this.playerShieldRegen = playerShieldRegen;
    }

    public int getPlayerManaRegen() {
        return playerManaRegen;
    }

    public void setPlayerManaRegen(int playerManaRegen) {
        this.playerManaRegen = playerManaRegen;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Status getStatus() {
        return status;
    }

    public String levelUp() {
        exp -= 1000;
        playerLevel++;
        playerShieldRegen++;
        int bonus = random.nextInt(4);
        switch (bonus) {
            case 0:
                playerAttack++;
                playerDefence++;
                return "Attack and Defence +1!";
            case 1:
                playerAttack++;
                return "Attack +1";
            case 2:
                playerDefence++;
                return "Defence +1";
            case 3:
                playerShieldRegen++;
                return "Shield regeneration +1";
            case 4:
                playerManaRegen++;
                return "quicker mana regen";
            default:
                playerMana += 50;
                return "???";
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

    public void addHp() {
        playerHp++;
    }

    public void addExp(int value) {
        exp += value;
    }

    public void addScore(int points) {
        score += points;
    }

    public boolean hasNotShield() {
        return playerShield < 0;
    }

    public void addHp(int points) {
        playerHp += points;
    }

    public void setShieldToZero() {
        playerShield = 0;
    }

    public void addPower() {
        playerPower++;
    }

    public void addKill() {
        kills++;
    }

    public boolean isAlive() {
        return playerHp > 0;
    }

    public boolean isDeath() {
        return !isAlive();
    }

    public void addAttack() {
        playerAttack++;
    }

    public void addDefence() {
        playerDefence++;
    }

    public void reduceHp(int value) {
        playerHp -= value;
    }

    public void addShieldPoints(int shieldRegen) {
        playerShield += shieldRegen;
    }

    public void regenMana() {
        playerMana += getPlayerManaRegen();
    }
}
