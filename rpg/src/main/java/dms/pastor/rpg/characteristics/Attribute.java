package dms.pastor.rpg.characteristics;

//TODO add description
public enum Attribute {
    /*

    HUMAN("A branch of apes that has  "),
    UNDEAD("ex-biological form that soul exists using magic  "),
    MAGICAL("Item has magical properties "),
    PMS("Woman only");
     */
    WEAPON,
    ECONOMICS,
    POISONED,
    STUNNED,// unit cannot make movement
    DISEASE,// state ,it is poison plus it cause random stunned ,weakness
    //RACE
    HUMAN,
    UNDEAD,
    GHOST,
    FISH,
    BIRD,
    HORSE,
    //ITEM
    FOUR_LEAF_CLOVER,
    //TYPE
    MECHANIC,
    MAGIC,
    NORMAL,
    MASSIVE,
    //MAGIC
    SPELL_QUICKNESS,
    SPELL_TURTLE,
    SPELL_DRAGON_POWER,
    MAGIC_RESISTANCE100,
    MAGIC_RESISTANCE50,
    MAGIC_RESISTANCE10,
    //STATE
    BLIND, //blind reduce accuracy to 2%
    POISON,
    DEPRESS,
    WEAKNESS,
    CURSE, // curse caused minimum damage, reduce accuracy by half and bad luck
    DRUNK, //DRUNK  random accuracy% ,
    VEGETERIAN, //It cannot attack animals. It cannot eat meat . Dom cause double dmg to vegeterians.
    //DRUG
    TRIPLE_BOOST,
    //WEAPONS.
    NORMAL_WEAPON,
    MAGIC_WEAPON,
    RANGE_WEAPON,
    MELEE_WEAPON,
    //STUDENT TYPES
    STUDENT_SPORT,
    STUDENT_COMP_SCI,
    STUDENT_INTERPOL,

    //OTHER    
    PERIOD, //Period is attribute added to a few woman
    LEGENDARY,
    UNDEAD_KILLER, //It does 1000 dmg per turn
    NONE, HERBALIST,
    DIPLOMACY, // People who study internal politics
    ;
}
