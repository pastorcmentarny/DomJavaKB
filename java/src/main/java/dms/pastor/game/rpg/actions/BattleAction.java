package dms.pastor.game.rpg.actions;

import dms.pastor.game.rpg.units.Unit;

public interface BattleAction {
    void beforeBattle();

    void beforeTurn();

    void afterTurn();

    void afterBattle();

    void specialAttack(Unit unit);

}
