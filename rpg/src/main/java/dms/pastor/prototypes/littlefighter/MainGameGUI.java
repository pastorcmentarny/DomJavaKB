/*
 * lfGUI.java
 *
 * Created on 2009-12-20, 23:48:44
 */
package dms.pastor.prototypes.littlefighter;

import dms.pastor.utils.StringUtils;

import java.util.Random;

import static java.lang.Short.MAX_VALUE;
import static javax.swing.GroupLayout.DEFAULT_SIZE;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@SuppressWarnings({"MagicNumber", "ClassWithTooManyFields", "ClassWithTooManyMethods"})
//TOO OLD PROJECT  TO TAKE CARE OF MAGIC NUMBERS
public final class MainGameGUI extends javax.swing.JFrame {

    private static final int PREFERRED_SIZE = 113;
    private static final int DEFAULT_GAP_SIZE = 274;
    private final Player player = new Player();
    private final Battle battle = new Battle();
    private final SpellBook spellBook = new SpellBook();
    private final HiScore hs = new HiScore();
    private final Random random = new Random();
    private Enemy enemy = new Unknown();
    private int lvl = 0;
    private int shieldRegen = 2;
    private int antiExp = 0;
    private javax.swing.JButton runTurn;
    private javax.swing.JButton berserkAttack;
    private javax.swing.JTextArea console;
    private javax.swing.JButton dispel;
    private javax.swing.JTextArea enemyConsole;
    private javax.swing.JButton lightingSpell;
    private javax.swing.JButton magicVampire;
    private javax.swing.JButton nextEnemy;
    private javax.swing.JTextArea playerConsole;
    private javax.swing.JButton poisonEnemy;
    private javax.swing.JButton shadowAttack;
    private javax.swing.JButton suddenDeath;

    /**
     * Creates new form lfGUI
     */
    MainGameGUI() {
        initComponents();
        runTurn.setEnabled(false);
        updateConsole();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MainGameGUI().setVisible(true));
    }

    void closeWindow() {
        this.dispose();
    }


    @SuppressWarnings("OverlyLongMethod") //GUI setup
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        runTurn = new javax.swing.JButton();
        javax.swing.JButton fireBall = new javax.swing.JButton();
        nextEnemy = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        playerConsole = new javax.swing.JTextArea();
        javax.swing.JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
        enemyConsole = new javax.swing.JTextArea();
        javax.swing.JButton mana2Shield = new javax.swing.JButton();
        javax.swing.JButton powerUP = new javax.swing.JButton();
        javax.swing.JButton quickerShieldRegen = new javax.swing.JButton();
        javax.swing.JButton info = new javax.swing.JButton();
        lightingSpell = new javax.swing.JButton();
        magicVampire = new javax.swing.JButton();
        dispel = new javax.swing.JButton();
        poisonEnemy = new javax.swing.JButton();
        berserkAttack = new javax.swing.JButton();
        shadowAttack = new javax.swing.JButton();
        suddenDeath = new javax.swing.JButton();
        javax.swing.JButton spell = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Little fighter");
        setResizable(false);

        console.setColumns(20);
        console.setRows(5);
        jScrollPane1.setViewportView(console);

        runTurn.setText("NEXT TURN");
        runTurn.addActionListener(this::runTurnActionPerformed);

        fireBall.setText("FireBall");
        fireBall.addActionListener(this::fireBallActionPerformed);

        nextEnemy.setText("Next Enemy");
        nextEnemy.addActionListener(this::nextEnemyActionPerformed);

        playerConsole.setColumns(20);
        playerConsole.setRows(5);
        jScrollPane2.setViewportView(playerConsole);

        enemyConsole.setColumns(20);
        enemyConsole.setRows(5);
        jScrollPane3.setViewportView(enemyConsole);

        mana2Shield.setText("Mana>Shield");
        mana2Shield.addActionListener(this::mana2ShieldActionPerformed);

        powerUP.setText("PowerUP");
        powerUP.addActionListener(this::powerUPActionPerformed);

        quickerShieldRegen.setText("Q.S.regen");
        quickerShieldRegen.addActionListener(this::quickerShieldRegenActionPerformed);

        info.setText("Info");
        info.addActionListener(this::infoActionPerformed);

        lightingSpell.setText("Lighting Strike");
        lightingSpell.setEnabled(false);
        lightingSpell.addActionListener(this::lightingSpellActionPerformed);

        magicVampire.setText("MagicVampire");
        magicVampire.setEnabled(false);
        magicVampire.addActionListener(this::magicVampireActionPerformed);

        dispel.setText("Dispel");
        dispel.setEnabled(false);
        dispel.addActionListener(this::dispelActionPerformed);

        poisonEnemy.setText("Poison Enemy");
        poisonEnemy.setEnabled(false);

        berserkAttack.setText("BerserkAttack");
        berserkAttack.setEnabled(false);

        shadowAttack.setText("ShadowAttack");
        shadowAttack.setEnabled(false);
        shadowAttack.addActionListener(this::shadowAttackActionPerformed);

        suddenDeath.setText("Sudden Death");
        suddenDeath.setEnabled(false);

        spell.setText("Spell");
        spell.addActionListener(this::spellActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(nextEnemy, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(runTurn, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE))
                                        .addComponent(spell))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(shadowAttack, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(dispel, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(berserkAttack, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(quickerShieldRegen, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(mana2Shield, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(powerUP, DEFAULT_SIZE, DEFAULT_SIZE, MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fireBall, DEFAULT_SIZE, PREFERRED_SIZE, MAX_VALUE)
                                        .addComponent(info, DEFAULT_SIZE, PREFERRED_SIZE, MAX_VALUE)
                                        .addComponent(suddenDeath, DEFAULT_SIZE, PREFERRED_SIZE, MAX_VALUE)
                                        .addComponent(lightingSpell, javax.swing.GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, PREFERRED_SIZE, MAX_VALUE)
                                        .addComponent(magicVampire, DEFAULT_SIZE, PREFERRED_SIZE, MAX_VALUE)
                                        .addComponent(poisonEnemy, javax.swing.GroupLayout.Alignment.TRAILING, DEFAULT_SIZE, PREFERRED_SIZE, MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(nextEnemy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(runTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE, DEFAULT_GAP_SIZE))
                        .addComponent(jScrollPane1, DEFAULT_SIZE, 370, MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, DEFAULT_SIZE, 185, MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(powerUP)
                                                        .addComponent(spell))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mana2Shield)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quickerShieldRegen)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(berserkAttack)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dispel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(shadowAttack))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(info)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fireBall)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, DEFAULT_SIZE, MAX_VALUE)
                                                .addComponent(magicVampire)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(poisonEnemy)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lightingSpell)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(suddenDeath)))
                                .addContainerGap())
        );

        pack();
    }

    @SuppressWarnings("unused") //useless but required by awt
    private void runTurnActionPerformed(java.awt.event.ActionEvent evt) {
        status();
        antiExp += 10;
        int playerDmg = battle.playerAttack(player, enemy);
        console.setText(console.getText() + "\nEnemy does " + playerDmg + " damage!");
        boolean isIt = isAlive();
        if (isIt) {
            int enemyDmg = battle.enemyAttack(player, enemy, console);
            antiExp += enemyDmg;
            console.setText(console.getText() + "\nPlayer does " + enemyDmg + " damage!");
            player.setPlayerShield(player.getPlayerShield() - enemyDmg);
            if (player.hasNotShield()) {
                player.addHp(player.getPlayerShield());
                player.setShieldToZero();
            }
            isAlive();
        }

        updateConsole();
        endOfTurn();

    }

    @SuppressWarnings("unused") //useless but required by awt
    private void fireBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireBallActionPerformed
        spellBook.castFireBall(player, enemy);
        if (spellBook.isSuccess()) {
            console.setText(console.getText() + "\nFireBall spell casted!");
            isAlive();
        }
        updateConsole();
    }//GEN-LAST:event_FireBallActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void nextEnemyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextEnemyActionPerformed
        runTurn.setEnabled(true);
        nextEnemy.setEnabled(false);
    }//GEN-LAST:event_nextEnemyActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void mana2ShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mana2ShieldActionPerformed
        //casting spell mana to shield
        String result = spellBook.castMana2Shield(player);
        console.setText(console.getText() + result);
        updateConsole();

    }//GEN-LAST:event_Mana2ShieldActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void powerUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerUPActionPerformed
        final int manaCost = 100;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            player.addPower();
            console.setText(console.getText() + "\n+1 to Power");
        }
    }//GEN-LAST:event_PowerUPActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void quickerShieldRegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuickerShieldRegenActionPerformed
        final int manaCost = 75;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            shieldRegen += 1;
            console.setText(console.getText() + "\n+1 to Mana shield regen");
        }

    }//GEN-LAST:event_QuickerShieldRegenActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        final int manaCost = 10;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            updateConsole();
            enemyConsole.setText(
                    "Level:" + lvl
                            + "\n" + enemyConsole.getText()
                            + "\nAttack: " + enemy.getEnemyAttack()
                            + "\nDefence: " + enemy.getEnemyDefence()
                            + "\nArmor:" + enemy.getEnemyArmor()
            );
            playerConsole.setText(player.status.setActiveStatuses());
            console.setText(console.getText() + "\n Info spell casted!");
        }

    }//GEN-LAST:event_InfoActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void lightingSpellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightingSpellActionPerformed
        spellBook.castLightingStrike(player, enemy);
        if (spellBook.isSuccess()) {
            console.setText(console.getText() + "\nLightingStrike spell casted!");
            isAlive();
        }
        updateConsole();
    }//GEN-LAST:event_lightingSpellActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void shadowAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shadowAttackActionPerformed
        final int manaCost = 175;
        if (player.getPlayerMana() >= manaCost) {
            player.setPlayerMana(player.getPlayerMana() - manaCost);
            for (int i = 1; i <= 3; i++) {
                int playerAttack = battle.playerAttack(player, enemy);
                player.addExp(playerAttack);
                player.addScore(playerAttack);
                console.setText(console.getText() + "In " + i + " attack:\nEnemy does " + playerAttack + " damage!");
                enemy.setEnemyHP(enemy.getEnemyHP() - playerAttack);
                isAlive();
            }
        }
    }//GEN-LAST:event_shadowAttackActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void dispelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispelActionPerformed
        spellBook.castDispel(player);
        if (spellBook.isSuccess()) {
            console.setText(console.getText() + "Dispel spell casted");
            updateConsole();
        }
    }//GEN-LAST:event_dispelActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void magicVampireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicVampireActionPerformed
        spellBook.castMagicVampire(player, enemy);
        if (spellBook.isSuccess()) {
            console.setText(console.getText() + "\nMagic vampire casted!");
            isAlive();
            updateConsole();
        }
    }//GEN-LAST:event_magicVampireActionPerformed

    @SuppressWarnings("unused") //useless but required by awt
    private void spellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpellActionPerformed
        Spell spell = new Spell();
        spell.setVisible(true);
    }//GEN-LAST:event_SpellActionPerformed

    private void updateConsole() {
        playerConsole.setText(
                "Player:(Level " + player.getPlayerLevel()
                        + ")\nAttack: " + player.getPlayerAttack()
                        + "\nDefence: " + player.getPlayerDefence()
                        + "\nPower: " + player.getPlayerPower()
                        + "\nHP: " + player.getPlayerHp()
                        + "\nShield: " + player.getPlayerShield()
                        + "\nMana: " + player.getPlayerMana()
                        + "\nScore:" + player.getScore()
        );

        enemyConsole.setText(
                "Enemy:" + enemy.getName()
                        + "\nPower: " + enemy.getEnemyPower()
                        + "\nHP: " + enemy.getEnemyHP()
        );
    }

    private void endOfBattle() {
        player.addKill();
        console.setText("You kill " + player.getKills() + " unit" + setPluralForMoreThanOneKill());
        runTurn.setEnabled(false);
        nextEnemy.setEnabled(true);
        player.addHp();
        if (player.getKills() >= 75) {
            wave4();
        } else if (player.getKills() >= 50) {
            wave3();
        } else if (player.getKills() >= 25) {
            console.setText(console.getText() + "\nWave2");
            wave2();
        } else {
            console.setText(console.getText() + "\nWave1");
            wave1();
        }
        console.setText(console.getText() + "\nGet ready for next battle");
    }

    private void levelUpUnitsIfTheyHaveEnoughExperience() {
        final int nextLevelValue = 1000;
        if (antiExp >= nextLevelValue) {
            antiExp -= nextLevelValue;
            lvl++;
            console.setText("Enemy level up! Current level:" + lvl);
        }
        if (player.getExp() >= nextLevelValue) {
            player.levelUp();
            updateConsole();
        }
        unlockNewSpellCheck();

    }

    private boolean isAlive() {
        if (enemy.getEnemyHP() < 0) {
            console.setText(console.getText() + "YOU WIN!");
            endOfBattle();
            return false;
        }

        if (player.isDeath()) {
            //String temp = console.getText();
            System.out.println("Game Over");
            console.setText("\n\nGAME OVER");
            System.out.println(player.getScore());
            hs.addToHiScore(player.getScore());
            //hs.save2File(player.score);
            System.exit(0);
            return false;
        }
        return true;
    }

    private void wave4() {
        //aliens world
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void wave3() {
        // modern army world
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void wave2() {
        //undead world (
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @SuppressWarnings("OverlyLongMethod")
    private void wave1() {
        //fantasy world (Dragon as boss)
        int next = random.nextInt(19);
        switch (next) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
                enemy = new Enemy();
                enemy.upgradeEnemy(lvl);
                break;
            case 4:
                console.setText(console.getText() + "\n+1 to player Attack");
                player.addAttack();
                enemy = new Enemy();
                break;
            case 13:
                console.setText(console.getText() + "\n+1 to player Defence");
                player.addDefence();
                enemy = new Enemy();
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
                enemy = new Dwarf();
                enemy.upgradeEnemy(lvl);
                break;
            case 16:
            case 18:
            case 19:
            case 7:
            case 17:
                enemy = new Troll();
                enemy.upgradeEnemy(lvl);
                break;
            default:
                System.out.println("???");
                enemy = new Enemy();
                enemy.upgradeEnemy(lvl);
                break;
        }

    }

    private String setPluralForMoreThanOneKill() {
        if (player.getKills() > 1) {
            return "s";
        }
        return StringUtils.EMPTY_STRING;
    }

    private void status() {
        if (player.status.isPoisoned()) {
            player.reduceHp(5 * (lvl + 1));
            console.setText(console.getText() + "\nPoison does " + (5 * (lvl + 1)) + " damage to Player.");
            isAlive();
        }
        if (enemy.statuses.isPoisoned()) {
            int hp = enemy.getEnemyHP();
            hp -= 5;
            enemy.setEnemyHP(hp);
            console.setText(console.getText() + "\nPoison does " + (5 * (lvl + 1)) + " damage to Enemy.");
            isAlive();
        }
    }

    private void unlockNewSpellCheck() {
        if (player.getPlayerLevel() >= 2) {
            magicVampire.setEnabled(true);
        }

        if (player.getPlayerLevel() >= 5) {
            berserkAttack.setEnabled(true);
        }

        if (player.getPlayerLevel() >= 8) {
            poisonEnemy.setVisible(true);
        }

        if (player.getPlayerLevel() >= 10) {
            dispel.setVisible(true);
        }

        if (player.getPlayerLevel() >= 13) {
            lightingSpell.setVisible(true);
        }

        if (player.getPlayerLevel() >= 18) {
            shadowAttack.setVisible(true);
        }

        if (player.getPlayerLevel() >= 24) {
            suddenDeath.setVisible(true);
        }
    }

    private void endOfTurn() {
        player.addShieldPoints(shieldRegen);
        player.regenMana();
        enemy.setEnemyHP(enemy.getEnemyHP() + enemy.getRegen());
        levelUpUnitsIfTheyHaveEnoughExperience();
        player.status.decreaseLengthOfPoison();
    }
}
