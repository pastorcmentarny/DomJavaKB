package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Author Dominik Symonowicz
 * Created 2017-06-05
 * WWW:	https://dominiksymonowicz.com/welcome/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 *
 * tag-nullObjectPattern
 * tag-Singleton
 *
 * Serialization is unnecessary for this class.
 * I used it to give complete example of singleton pattern.
 */
public class NoSpell extends Spell implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoSpell.class);
    private static final long serialVersionUID = -32961183500001L;

    private NoSpell() {
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        LOGGER.debug("No");
    }

    @Override
    public boolean isASpell(Elements elements) {
        return false;
    }

    @Override
    public boolean hasEnoughElementsToCovertToSpell(Elements elements) {
        return false;
    }

    @Override
    void setElements(Elements elements) {
        super.setElements(Elements.noElements());
    }

    @Override
    public Elements getElements() {
        return Elements.noElements();
    }

    // Singleton setup

    private static class NoSpellHolder {

        static final NoSpell INSTANCE = new NoSpell();
    }

    @SuppressWarnings("SameReturnValue") // part of Singleton
    static NoSpell getInstance() {
        return NoSpellHolder.INSTANCE;
    }

    private Object readResolve() {
        return NoSpell.getInstance();
    }
}
