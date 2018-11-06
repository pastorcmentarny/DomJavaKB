package dms.pastor.game.rpg.characteristics;

//TODO add descrption
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
    FOURLEAF_CLOVER,
    //TYPE
    MECHANIC,
    MAGIC,
    NORMAL,
    MASSIVE,
    //MAGIC
    SPELL_QUICKNESS,
    SPELL_TUTRLE,
    SPELL_DRAGONPOWER,
    MAGIC_RESISTANCE100,
    MAGIC_RESISTANCE50,
    MAGIC_RESISTANCE10,
    //STATE
    BLIND,
    POISON,
    DEPRESS,
    WEAKNESS,
    CURSE, // curse caused minimum damage, reduce accuracy by half and bad luck
    DRUNK, //DRUNK  random accuracy% ,
    //DRUG
    TRIPLE_BOOST,
    //WEAPONS.
    NORMAL_WEAPON,
    MAGIC_WEAPON,
    RANGE_WEAPON,
    MEELE_WEAPON,
    //STUDENT TYPES
    STUDENT_SPORT,
    STUDENT_COMPSCI,
    STUDENT_INTERPOL,

    //OTHER    
    PERIOD, //Period jest atrybutem dodanym to paru kobiet
    LEGENDARY,
    UNDEAD_KILLER, //It does 1000 dmg per turn
    NONE, HERBALIST,
    DIPLOMACY, // People who study intenral politics
    ;
}
