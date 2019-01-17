package dms.pastor.rpg.units;

import dms.pastor.rpg.Bonus;
import dms.pastor.rpg.Money;
import dms.pastor.rpg.actions.BattleAction;
import dms.pastor.rpg.armor.Armor;
import dms.pastor.rpg.armor.CrocodileArmor;
import dms.pastor.rpg.armor.UnitArmors;
import dms.pastor.rpg.cfg.Config;
import dms.pastor.rpg.characteristics.*;
import dms.pastor.rpg.commons.CLI;
import dms.pastor.rpg.commons.Msg;
import dms.pastor.rpg.commons.Result;
import dms.pastor.rpg.exceptions.NoEnoughMoneyException;
import dms.pastor.rpg.items.DomSocks;
import dms.pastor.rpg.items.Inventory;
import dms.pastor.rpg.items.Item;
import dms.pastor.rpg.items.weapons.AluminiumBaseballBat;
import dms.pastor.rpg.items.weapons.Hands;
import dms.pastor.rpg.items.weapons.Weapon;
import dms.pastor.rpg.spells.AcidRainSpell;
import dms.pastor.rpg.units.enemies.Enemy;

import java.util.Random;
import java.util.Scanner;

import static dms.pastor.rpg.Game.gameOver;


/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Hero extends Unit implements BattleAction {
    private static Hero hero;
    private Weapon leftHand;
    private Weapon rightHand;
    public final Money money = new Money(1000);
    private final UnitArmors armors;
    private final Scanner scanner = new Scanner(System.in);
    private boolean castlePermission;
    private boolean wantFight = true;
    private final SkillsType[] skillTypes;


    private Hero() {
        //FIXME log.setLevel(Config.//FIXME log.LEVEL);
        setName("YOU");
        setDescription("You are a hero who apparently is on the way to home and during your journey you will  discover new life and ");
        this.lvl = 1;
        exp += new Random().nextInt(10000);
        armors = new UnitArmors(Config.HUMAN_ARMOR_TYPE);
        psycho = true;
        isPlayer = true;
        skills = Skills.generateRandomSkills(Config.DEFAULT_POINTS_FOR_SKILLS, 10, psycho, null);
        setup();
        bonusPerLevelStats = Stats.generateDefaultBonusStats(psycho);
        //bonusPerLevelStats.addToAllStats(lvl, psycho);
        //bonusPerLevelSkills = Skills.generateOneNumberForAllSkills(1, psycho);

        extraStats.setHP(1000);
        extraStats.setMaxHP(1000);//TODO remove it
        //inventory = new Inventory(18); default value
        inventory = new Inventory(100);
        inventory.addItem(new AluminiumBaseballBat());
        inventory.addItem(new CrocodileArmor());
        inventory.addItem(new DomSocks());
        castlePermission = true;

        skillTypes = SkillsType.values();

    }

    public static synchronized Hero getHero() {

        if (hero == null) {
            hero = new Hero();
        }
        return hero;
    }

    @Override
    public final Object clone() throws CloneNotSupportedException {
        //FIXME log.error("Clone not supported exception!");
        throw new CloneNotSupportedException();
    }

    @Override
    public void levelUp() {
        if (lvl < Config.MAX_LEVEL) {
            lvl++;
            calcExpForNextLevel();
            System.out.println(CLI.CUTE_LINE_SEPARATOR);
            System.out.println(getName() + " is leveled up and is on level: " + lvl);
            System.out.println(CLI.CUTE_LINE_SEPARATOR);
            if (lvl % Config.DEFAULT_SKILL_BONUS_FREQUENCY == 0) {
                Skills.addRandomSkillFromSkillType(skills, skillTypes);
                bonusPerLevelStats = Stats.generateDefaultBonusStatsFromSkills(skills);
            }
            plainStats.levelUp(bonusPerLevelStats, psycho);
        } else {
            //FIXME log.info( name + "reaches highest level and cannot be more clever.");
        }


    }


    //@Override
    private void calcExpForNextLevel() {
        nextLvlExp = Config.getExpNeededForLevel(lvl);//TODO different type of hear will have different level of learning

    }

    //TODO remove it,when spell will be implement
    private Result castMinorHealing() {
        addHealth(battleStats, lvl);
        return new Result(true, getName() + " was heal by " + lvl);
    }

    private Result castAcidRain(Unit[] units) {
        AcidRainSpell rain = new AcidRainSpell(this);
        return rain.cast(this, units);
    }

    private void addHealth(Stats stat, int hp) {
        //System.out.println("Health before cast minor health..." + stat.getHP() + "restore health by" + hp + "MaxHP" + stat.getMaxHP());
        if (stat.getHP() + hp > stat.getMaxHP()) {
            stat.setHP(stat.getMaxHP());
        } else {
            stat.setHP(stat.getHP() + hp);

        }
        System.out.println("Health after casting minor health ... " + stat.getHP() + " hp.");
    }

    public void updateAfterBattle(int expForBattle) {
        exp += expForBattle;
        plainStats.setHP(battleStats.getHP());
        plainStats.setSP(battleStats.getSP());
        plainStats.setMana(battleStats.getMana());

    }

    public void addHealthByPercent(int i) {
        plainStats.setHP(i);
    }

    public void addBonus(Bonus bonus) {
        exp += bonus.getExp();
        money.addMoney(bonus.getMoney());
        if (bonus.getItems() != null) {
            for (Item item : bonus.getItems()) {
                if (inventory.isInventoryNotFull()) {
                    if (inventory.addItem(item)) {
                        System.out.println(item.getName() + " was added to your inventory.");
                    } else {
                        System.out.println("Whoops! You broke " + item.getName() + "and you can't add this to inventory.");
                    }
                } else {
                    System.out.println("As typical student,you take what you could and abandon rest without evaluate value of items.");
                }
            }
        }

    }

    public void addExp(int i) {
        exp += i;
    }

    public boolean hasCastlePermission() {
        return castlePermission;
    }

    public void setCastlePermission(boolean granted) {
        castlePermission = granted;
    }

    public void gotInjured(String reason) {
        int dmg = plainStats.getMaxHP() / 5;
        System.out.println(reason + "... it causes " + dmg + " to you.");
        plainStats.setHP(plainStats.getHP() - dmg);
        if (isAlive()) {
            System.out.println("You have " + plainStats.getHP() + " hp left.");
        } else {
            gameOver(reason + " and killed you.", getName());
        }

    }

    @Override
    public void beforeBattle() {
        //NOTHING
    }

    @Override
    public void beforeTurn() {
        if (state.isPoisoned) {
            int dmg = battleStats.getMaxDMG() / 35;
            if (battleStats.getHP() - dmg <= 0) {
                battleStats.setHP(1);
            } else {
                battleStats.doesDMG(dmg, battleStats.getARM());
            }
        }
    }

    @Override
    public void afterTurn() {
        hero.castMinorHealing();
        hero.state.afterTurn();
    }

    @Override
    public void afterBattle() {
        hero.plainStats.setHP(hero.battleStats.getHP());
        hero.plainStats.setSP(hero.battleStats.getSP());
        hero.plainStats.setMana(hero.battleStats.getMana());
        hero.removeBattleOnlyAttributes();

    }

    private void removeBattleOnlyAttributes() {
        //TODO implement it
    }

    public boolean wantFight() {
        return wantFight;
    }

    public void setAlwaysFight(boolean wantFight) {
        this.wantFight = wantFight;
    }

    @Override
    public String displayShortInfo(boolean inBattle) {
        return super.displayShortInfo(inBattle) + "\n\t<FIGHT MOOD:" + Msg.isWantFight(wantFight) + " >\n\tARMOR:" + armors.toString() + ">\n\t<WEAPONS: left::" + (leftHand != null ? leftHand.getName() : "none") + " right:: " + (rightHand != null ? rightHand.getName() : "none");
    }

    public String getFightMood() {
        return Msg.isWantFight(wantFight);
    }

    @Override
    public void specialAttack(Unit unit) {
        //NOTHING
    }

    public Result wear(Item item) {
        if (item instanceof Armor) {
            Armor armor = (Armor) item;
            return hero.armors.wearArmor(armor);
        } else {
            //FIXME log.warn("Player trying to wear " + item.getName() + " but it is not an armor.bug?");
            return new Result(false, "You can't wear that");
        }
    }

    public Result equipWeapon(Item item) {
        try {
            Weapon weapon = (Weapon) item;
            if (weapon.hand.equals(Hands.LEFT)) {
                if (leftHand != null) {
                    Weapon old = leftHand;
                    leftHand = weapon;
                    return new Result(true, "You swap " + old.getName() + " with " + weapon.getName(), old);
                } else {
                    leftHand = weapon;
                    return new Result(true, "You equipped with " + weapon.getName());
                }
            } else {
                if (rightHand != null) {
                    Weapon old = rightHand;
                    rightHand = weapon;
                    return new Result(true, "You swap " + old.getName() + " with " + weapon.getName(), old);
                } else {
                    rightHand = weapon;
                    return new Result(true, "You equipped with " + weapon.getName());
                }
            }
        } catch (ClassCastException cce) {
            String msg = "This item is not a weapon!" + cce.getMessage();
            //FIXME log.error(msg);
            return new Result(false, msg);
        }
        //return new Result(false,"not implemented");
    }

    public Weapon unequippedWeapon(Hands hand) {
        Weapon weapon;
        if (hand.equals(Hands.LEFT)) {
            weapon = leftHand;
            leftHand = null;
            return weapon;
        } else {
            weapon = rightHand;
            rightHand = null;
            return weapon;
        }
    }


    @Override
    public void generateBattleStats() {
        battleStats = new BattleStats(state);
        battleStats.addStats(plainStats);
        battleStats.addStats(extraStats);
        battleStats.addArm(armors.getTotalARM());
        if (leftHand != null) {
            leftHand.addToStats(battleStats);
        }
        if (rightHand != null) {
            rightHand.addToStats(battleStats);
        }
    }

    @Override
    public boolean canAttack() {
        return !state.isStunned();
    }

    @Override
    public boolean canCastSpell() {
        return psycho && !state.isStunned();
    }

    public Result castWorldSpell(int which) {
        switch (which) {
            case 1:
                castMinorHealing();
            case 8:
                //castScanForHidden();
            case 9:
                //castLight();

        }
        return new Result(false, "Unable to cast unknown spell");
    }

    //public hero.castBattleSpell(6,new Unit[]{enemy});

    //TODO implement
    public Result castBattleSpell(int which, Unit[] units) {
        switch (which) {
            case 1:
                return castShieldProtection();
            case 2:
                return castFireBall();
            case 3:
                //return cast
            case 4:
                return castElectricAura();
            case 5:
                return castBlur(); //add evasion                                
            case 6:
                return castAcidRain(units); // TODO if null then it should return false;                
            case 7:
                return castBlindness();
            case 8:
                return castFreeze();
            case 9:
                //return  castImplosion();
            default:
                //FIXME log.warn("unable to cast unknown spell");

        }
        return new Result(false);
    }

    //3 sel
    public Result castClericSpell(int which) {
        switch (which) {
            case 1:
                //return castMajorHealing();
            case 2:
                //return cure();
            case 3:
                //return castPrecision();
            case 4:
                return castShieldProtection();
            case 5:
                //dispel();
            default:
        }

        return new Result(false);
    }

    public boolean canUseItem() {
        return !currentAttributes.contains(Attribute.STUNNED) || !currentAttributes.contains(Attribute.BLIND);
    }

    public void useItem(Enemy enemy) {

        if (inventory.isInventoryNotEmpty()) {
            String[] itemToUse = new String[inventory.getSize()];
            System.out.println("Select item to use");

            int counter = 1;
            for (Item item : inventory.getAllInventoryItems()) {
                if (item.isIsUsableInBattle()) {
                    itemToUse[counter - 1] = item.getName();
                    System.out.println(counter + ". " + item.getName());
                }
            }
            System.out.println("0. Go back.");
            int selection = scanner.nextInt();
            if (selection == 0) {
                //noinspection UnnecessaryReturnStatement
                return;
            } else if (selection > itemToUse.length) {
                System.out.println("Do you have illusion ? You can't use item that you don't have");
            } else {
                Item item = inventory.getItemByName(itemToUse[selection - 1]);
                Result r = item.useInBattle(enemy);
                if (r.isSuccess()) {
                    System.out.println("You used an item." + r.getMessage());
                } else {
                    System.out.println("Whoops." + r.getMessage());
                }
            }
        } else {
            System.out.println("You don't have any item in your inventory ,so what you want use ? Air?");
        }

    }

    private Result castFireBall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Result castShieldProtection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean canUseSpecial() {
        return false; //TODO implement whe student type is implemented
    }

    private Result castBlindness() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Result castFreeze() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Result castElectricAura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Result castBlur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Result pay(int value, Item item) {
        if (money.hasEnoughMoney(value)) {
            if (inventory.isInventoryFull()) {
                return new Result(false, "Inventory is full");
            } else {
                try {
                    money.takeMoney(value);
                } catch (NoEnoughMoneyException ex) {
                    return new Result(false, "You don't have enough money");
                }
                inventory.addItem(item);
                return new Result(true, "You bought " + item.getName());
            }
        } else {
            return new Result(false, "You don't have enough money");
        }
    }

    public void castSpell(Enemy enemy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
