package dms.pastor.game.rpg.lab;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-16
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Frankenstein {
    private final String name;
    private int lvl;
    private final int strength;
    private final int charisma;
    private final int intelligence;
    private final int vitality;
    private final int dexterity;
    private final int psychokinesis;
    //--//
    private int minDMG;
    private int maxDMG;
    private int accuracy;
    private int evasion;
    private int HP;
    private int maxHP;
    private int SP;
    private int maxSP;
    private int mana;
    private int maxMana;
    private int ARM;

    public Frankenstein(String name, int strength, int charisma, int intelligence, int vitality, int dexterity, int psychokinesis) {
        this.name = name;
        lvl = 1;
        this.strength = strength;
        this.charisma = charisma;
        this.intelligence = intelligence;
        this.vitality = vitality;
        this.dexterity = dexterity;
        this.psychokinesis = psychokinesis;
    }


    public int getInitiative() {
        return 5 * dexterity + 2 * psychokinesis + intelligence;
    }

    //each class has modifier
    public void generateStatsForLevel(int lvl) {
        this.lvl = lvl;
        int s = strength;
        int c = charisma;
        int i = intelligence;
        int v = vitality;
        int d = dexterity; // compSci*3/4
        int p = psychokinesis; //compsci*2
        minDMG = s + (s + (s + lvl / 2) / 5) - 2;
        maxDMG = (2 * s) + lvl;
        accuracy = 40 + (d * lvl) / 6;
        evasion = 1 + (2 * d + (lvl / 3)) * 3 / 4;
        HP = (3 * v) * (lvl * 2 / 5);
        maxHP = HP;
        SP = (2 * p) * lvl;
        maxSP = SP;
        ARM = ((2 * s) + v + lvl) / 10;
        mana = lvl * ((3 * p) + (i / 3)) * 2 / 3;
        maxMana = mana;
    }

    @Override
    public String toString() {
        return name + "(" + lvl + ")  {" +
                "ARM=" + ARM +
                ", minDMG=" + minDMG +
                ", maxDMG=" + maxDMG +
                ", accuracy=" + accuracy +
                ", evasion=" + evasion +
                ", HP=" + HP +
                ", maxHP=" + maxHP +
                ", SP=" + SP +
                ", maxSP=" + maxSP +
                ", mana=" + mana +
                ", maxMana=" + maxMana +
                '}';
    }
}
