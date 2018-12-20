package dms.pastor.rpg.items;

import java.util.EnumSet;


public enum Action {
    DROP,
    EAT,
    EQUIP,
    GIVE,
    INFO,
    REPAIR,
    USE,
    WEAR;

    public static EnumSet<Action> junk = EnumSet.of(INFO, DROP);
    public static final EnumSet<Action> item = EnumSet.of(INFO, USE, DROP);
    public static final EnumSet<Action> weapon = EnumSet.of(EQUIP, INFO, DROP);
    public static final EnumSet<Action> food = EnumSet.of(EAT, INFO, DROP);
    public static final EnumSet<Action> armor = EnumSet.of(WEAR, INFO, DROP);
    public static final EnumSet<Action> quest = EnumSet.of(INFO);

}
