package dms.pastor.game.rpg.items;

import java.util.EnumSet;


public enum Action {
    DROP,
    EAT,
    EQUIPT,
    GIVE,
    INFO,
    REPAIR,
    USE,
    WEAR;

    public static EnumSet<Action> junk = EnumSet.of(INFO, DROP);
    public static EnumSet<Action> item = EnumSet.of(INFO, USE, DROP);
    public static EnumSet<Action> weapon = EnumSet.of(EQUIPT, INFO, DROP);
    public static EnumSet<Action> food = EnumSet.of(EAT, INFO, DROP);
    public static EnumSet<Action> armor = EnumSet.of(WEAR, INFO, DROP);
    public static EnumSet<Action> quest = EnumSet.of(INFO);

}
