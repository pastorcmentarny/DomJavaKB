package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import static dms.pastor.game.dcs.Elements.noElements;

/**
 * Author Dominik Symonowicz
 * Created 2017-06-05
 * WWW:	https://dominiksymonowicz.com/welcome/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * tag-nullObjectPattern
 * tag-Singleton
 * <p>
 * Serialization is unnecessary for this class.
 * I used it to give complete example of singleton pattern.
 */
public final class NoSpell extends Spell implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoSpell.class);
    private static final long serialVersionUID = -32961183500001L;

    private NoSpell() {
    }

    @SuppressWarnings("SameReturnValue") // part of Singleton
    static NoSpell getInstance() {
        return NoSpellHolder.INSTANCE;
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        LOGGER.warn("Nothing happen. (Bug? Casting spell for No Spell???)");
    }

    public boolean isASpell(Elements elements) {
        return false;
    }

    @Override
    public boolean hasEnoughElementsToCovertToSpell(Elements elements) {
        return false;
    }

    @Override
    public Elements getElements() {
        return noElements();
    }

    @Override
    void setElements(Elements elements) {
        LOGGER.warn("Bug detected! Something trying to set elements on NoSpell.");
        super.setElements(noElements());
    }

    private Object readResolve() {
        return NoSpell.getInstance();
    }

    private static final class NoSpellHolder {
        static final NoSpell INSTANCE = new NoSpell();
    }
}
