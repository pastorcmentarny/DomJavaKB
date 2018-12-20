package dms.pastor.rpg.actions;

import dms.pastor.rpg.units.Unit;

public interface BattleAction {
    void beforeBattle();

    void beforeTurn();

    void afterTurn();

    void afterBattle();

    void specialAttack(Unit unit);

}
