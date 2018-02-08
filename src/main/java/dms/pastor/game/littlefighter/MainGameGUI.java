/*
 * lfGUI.java
 *
 * Created on 2009-12-20, 23:48:44
 */
package dms.pastor.game.littlefighter;

import java.util.Random;

import static dms.pastor.utils.StringUtils.EMPTY_STRING;

/**
 * Author Dominik Symonowicz
 * Created 2009
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class MainGameGUI extends javax.swing.JFrame {

    private final Player player = new Player();
    private Enemy enemy = new Unknown();
    private final Battle battle = new Battle();
    private final SpellBook spellBook = new SpellBook();
    private final HiScore hs = new HiScore();
    private final Random random = new Random();
    private int lvl = 0;
    private int shieldRegen = 2;
    private int antiExp = 0;
    private javax.swing.JButton FireBall;
    private javax.swing.JButton Info;
    private javax.swing.JButton Mana2Shield;
    private javax.swing.JButton PowerUP;
    private javax.swing.JButton QuickerShieldRegen;
    private javax.swing.JButton RunTurn;
    private javax.swing.JButton Spell;
    private javax.swing.JButton berserkAttack;
    private javax.swing.JTextArea console;
    private javax.swing.JButton dispel;
    private javax.swing.JTextArea enemyConsole;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private MainGameGUI() {
        initComponents();
        RunTurn.setEnabled(false);
        updateConsole();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainGameGUI().setVisible(true));
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        RunTurn = new javax.swing.JButton();
        FireBall = new javax.swing.JButton();
        nextEnemy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        enemyConsole = new javax.swing.JTextArea();
        Mana2Shield = new javax.swing.JButton();
        PowerUP = new javax.swing.JButton();
        QuickerShieldRegen = new javax.swing.JButton();
        Info = new javax.swing.JButton();
        lightingSpell = new javax.swing.JButton();
        magicVampire = new javax.swing.JButton();
        dispel = new javax.swing.JButton();
        poisonEnemy = new javax.swing.JButton();
        berserkAttack = new javax.swing.JButton();
        shadowAttack = new javax.swing.JButton();
        suddenDeath = new javax.swing.JButton();
        Spell = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Little fighter");
        setResizable(false);

        console.setColumns(20);
        console.setRows(5);
        jScrollPane1.setViewportView(console);

        RunTurn.setText("NEXT TURN");
        RunTurn.addActionListener(this::RunTurnActionPerformed);

        FireBall.setText("FireBall");
        FireBall.addActionListener(this::FireBallActionPerformed);

        nextEnemy.setText("Next Enemy");
        nextEnemy.addActionListener(this::nextEnemyActionPerformed);

        playerConsole.setColumns(20);
        playerConsole.setRows(5);
        jScrollPane2.setViewportView(playerConsole);

        enemyConsole.setColumns(20);
        enemyConsole.setRows(5);
        jScrollPane3.setViewportView(enemyConsole);

        Mana2Shield.setText("Mana>Shield");
        Mana2Shield.addActionListener(this::Mana2ShieldActionPerformed);

        PowerUP.setText("PowerUP");
        PowerUP.addActionListener(this::PowerUPActionPerformed);

        QuickerShieldRegen.setText("Q.S.regen");
        QuickerShieldRegen.addActionListener(this::QuickerShieldRegenActionPerformed);

        Info.setText("Info");
        Info.addActionListener(this::InfoActionPerformed);

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

        berserkAttack.setText("Beserk Attack");
        berserkAttack.setEnabled(false);

        shadowAttack.setText("ShadowAttack");
        shadowAttack.setEnabled(false);
        shadowAttack.addActionListener(this::shadowAttackActionPerformed);

        suddenDeath.setText("Sudden Death");
        suddenDeath.setEnabled(false);

        Spell.setText("Spell");
        Spell.addActionListener(this::SpellActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(nextEnemy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(RunTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(Spell))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(shadowAttack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dispel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(berserkAttack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(QuickerShieldRegen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Mana2Shield, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PowerUP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FireBall, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                        .addComponent(Info, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                        .addComponent(suddenDeath, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                        .addComponent(lightingSpell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                        .addComponent(magicVampire, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                        .addComponent(poisonEnemy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(nextEnemy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RunTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(274, 274, 274))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(PowerUP)
                                                        .addComponent(Spell))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Mana2Shield)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(QuickerShieldRegen)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(berserkAttack)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dispel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(shadowAttack))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Info)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(FireBall)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void RunTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunTurnActionPerformed
        status();
        antiExp += 10;
        int playerDmg = battle.PlayerAttack(player, enemy, console);
        console.setText(console.getText() + "\nEnemy does " + playerDmg + " damage!");
        boolean isIt = isAlive();
        if (isIt) {
            int enemyDmg = battle.EnemyAttack(player, enemy, lvl, console);
            antiExp += enemyDmg;
            console.setText(console.getText() + "\nPlayer does " + enemyDmg + " damage!");
            player.PlayerShield -= enemyDmg;
            if (player.PlayerShield < 0) {
                player.PlayerHP += player.PlayerShield;
                player.PlayerShield = 0;
            }
            if (player.PlayerHP < 0) {
                isAlive();
            }
        }

        updateConsole();
        endOfTurn();


    }//GEN-LAST:event_RunTurnActionPerformed

    private void FireBallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FireBallActionPerformed
        boolean isCasted = spellBook.castFireBall(player, enemy);
        if (isCasted) {
            console.setText(console.getText() + "\nFireBall spell casted!");
            isAlive();
        }
        updateConsole();
    }//GEN-LAST:event_FireBallActionPerformed

    private void nextEnemyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextEnemyActionPerformed
        RunTurn.setEnabled(true);
        nextEnemy.setEnabled(false);
    }//GEN-LAST:event_nextEnemyActionPerformed

    private void Mana2ShieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mana2ShieldActionPerformed
        //casting spell mana to shield
        String result = spellBook.castMana2Shield(player.PlayerMana, player.PlayerHP, console);
        console.setText(console.getText() + result);
        updateConsole();

    }//GEN-LAST:event_Mana2ShieldActionPerformed

    private void PowerUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PowerUPActionPerformed
        if (player.PlayerMana >= 100) {
            player.PlayerMana -= 100;
            player.PlayerPower += 1;
            console.setText(console.getText() + "\n+1 to Power");
        }
    }//GEN-LAST:event_PowerUPActionPerformed

    private void QuickerShieldRegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuickerShieldRegenActionPerformed
        if (player.PlayerMana >= 75) {
            player.PlayerMana -= 75;
            shieldRegen += 1;
            console.setText(console.getText() + "\n+1 to Mana shield regen");
        }

    }//GEN-LAST:event_QuickerShieldRegenActionPerformed

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        if (player.PlayerMana >= 10) {
            player.PlayerMana -= 10;
            updateConsole();
            enemyConsole.setText(
                    "Level:" + lvl
                            + "\n" + enemyConsole.getText()
                            + "\nAttack: " + enemy.getEnemyAttack()
                            + "\nDefence: " + enemy.getEnemyDefence()
                            + "\nArmor:" + enemy.getEnemyArmor()
            );
            playerConsole.setText(player.status.checkStatus());
            console.setText(console.getText() + "\n Info spell casted!");
        }

    }//GEN-LAST:event_InfoActionPerformed

    private void lightingSpellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lightingSpellActionPerformed
        boolean isCasted = spellBook.castLightingStrike(player, enemy);
        if (isCasted) {
            console.setText(console.getText() + "\nLightingStrike spell casted!");
            isAlive();
        }
        updateConsole();
    }//GEN-LAST:event_lightingSpellActionPerformed

    private void shadowAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shadowAttackActionPerformed
        boolean result = spellBook.castShadowAttack(player);
        if (result) {
            for (int i = 1; i <= 3; i++) {
                int Pdmg = battle.PlayerAttack(player, enemy, console);
                player.exp += Pdmg;
                player.score += Pdmg;
                console.setText(console.getText() + "In " + i + " attack:\nEnemy does " + Pdmg + " damage!");
                enemy.setEnemyHP(enemy.getEnemyHP() - Pdmg);
                isAlive();

            }
        }
    }//GEN-LAST:event_shadowAttackActionPerformed

    private void dispelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispelActionPerformed
        boolean result = spellBook.castDispel(player);
        if (result) {
            console.setText(console.getText() + "Dispel spell casted");
            updateConsole();
        }
    }//GEN-LAST:event_dispelActionPerformed

    private void magicVampireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magicVampireActionPerformed
        boolean result = spellBook.castMagicVampire(player, enemy);
        if (result) {
            console.setText(console.getText() + "\nMagic vampire casted!");
            isAlive();
            updateConsole();
        }
    }//GEN-LAST:event_magicVampireActionPerformed

    private void SpellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpellActionPerformed
        Spell spell = new Spell(player, enemy, spellBook, console);
        spell.setVisible(true);
    }//GEN-LAST:event_SpellActionPerformed
    // End of variables declaration//GEN-END:variables

    private void updateConsole() {
        playerConsole.setText(
                "Player:(Level " + player.playerLevel
                        + ")\nAttack: " + player.PlayerAttack
                        + "\nDefence: " + player.PlayerDefence
                        + "\nPower: " + player.PlayerPower
                        + "\nHP: " + player.PlayerHP
                        + "\nShield: " + player.PlayerShield
                        + "\nMana: " + player.PlayerMana
                        + "\nScore:" + player.score
        );

        enemyConsole.setText(
                "Enemy:" + enemy.getName()
                        + "\nPower: " + enemy.getEnemyPower()
                        + "\nHP: " + enemy.getEnemyHP()
        );
    }

    private void endOfBattle() {
        player.kills++;
        console.setText("You kill " + player.kills + " unit" + isPlurar());
        RunTurn.setEnabled(false);
        nextEnemy.setEnabled(true);
        player.PlayerHP += 1;
        if (player.kills >= 75) {
            wave4();
        } else if (player.kills >= 50) {
            wave3();
        } else if (player.kills >= 25) {
            console.setText(console.getText() + "\nWave2");
            wave2();
        } else {
            console.setText(console.getText() + "\nWave1");
            wave1();
        }
        console.setText(console.getText() + "\nGet ready for next battle");
    }

    private void isLevelUpForSomebody() {
        if (antiExp >= 1000) {
            antiExp -= 1000;
            lvl++;
            console.setText("Enemy level up! Current level:" + lvl);
        }
        if (player.exp >= 1000) {
            player.levelUp();
            updateConsole();
        }
        isEnoughLevelToUnlockNewSpell();

    }

    private boolean isAlive() {
        if (enemy.getEnemyHP() < 0) {
            console.setText(console.getText() + "YOU WIN!");
            endOfBattle();
            return false;
        }

        if (player.PlayerHP < 0) {
            //String temp = console.getText();
            System.out.println("Game Over");
            console.setText("\n\nGAME OVER");
            System.out.println(player.score);
            hs.addToHiScore(player.score);
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
                player.PlayerAttack++;
                enemy = new Enemy();
                break;
            case 13:
                console.setText(console.getText() + "\n+1 to player Defence");
                player.PlayerDefence++;
                enemy = new Enemy();
                break;
            case 8:
            case 9:
            case 10:
            case 11:
                enemy = new Elf();
                enemy.upgradeEnemy(lvl);
                break;
            case 12:
            case 14:
            case 15:
                enemy = new Dwarf();
                enemy.upgradeEnemy(lvl);
                break;
            case 16:
            case 18:
            case 19:
                enemy = new Centaur();
                enemy.upgradeEnemy(lvl);
                break;
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

    private String isPlurar() {
        if (player.kills > 1) {
            return "s";
        }
        return EMPTY_STRING;
    }

    private void status() {
        if (player.status.isItPoisoned()) {
            player.PlayerHP -= 5 * (lvl + 1);
            console.setText(console.getText() + "\nPoison does " + (5 * (lvl + 1)) + " damage to Player.");
            isAlive();
        }
        if (enemy.statuses.isItPoisoned()) {
            int hp = enemy.getEnemyHP();
            hp -= 5 * player.playerLevel;
            enemy.setEnemyHP(hp);
            console.setText(console.getText() + "\nPoison does " + (5 * (lvl + 1)) + " damage to Enemy.");
            isAlive();
        }
    }

    private void isEnoughLevelToUnlockNewSpell() {
        if (player.playerLevel >= 2) {
            magicVampire.setEnabled(true);
        }

        if (player.playerLevel >= 5) {
            berserkAttack.setEnabled(true);
        }

        if (player.playerLevel >= 8) {
            poisonEnemy.setVisible(true);
        }

        if (player.playerLevel >= 10) {
            dispel.setVisible(true);
        }

        if (player.playerLevel >= 13) {
            lightingSpell.setVisible(true);
        }

        if (player.playerLevel >= 18) {
            shadowAttack.setVisible(true);
        }

        if (player.playerLevel >= 24) {
            suddenDeath.setVisible(true);
        }

    }

    private void endOfTurn() {
        player.PlayerShield += shieldRegen;
        player.PlayerMana += player.playerManaRegen;
        enemy.setEnemyHP(enemy.getEnemyHP() + enemy.getRegen());
        isLevelUpForSomebody();
        player.status.decreaseLengthOfPoison();

    }
}
