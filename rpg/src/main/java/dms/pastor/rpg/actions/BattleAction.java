package dms.pastor.rpg.actions;

import dms.pastor.rpg.units.Unit;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public interface BattleAction {
    void beforeBattle();

    void beforeTurn();

    void afterTurn();

    void afterBattle();

    void specialAttack(Unit unit);

}
