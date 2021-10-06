package dms.pastor.rpg.game.actions;

import dms.pastor.rpg.game.units.Unit;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
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
