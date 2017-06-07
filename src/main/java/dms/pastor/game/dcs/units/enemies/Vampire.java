package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.spells.VampireDrainSpell;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-08-02
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Vampire extends Unit {

    public Vampire() {
        super();
        setName("Vampire");
        setShielded(true);
        setSp(48);
    }


    @Override
    public void turn(Unit unit) {
        VampireDrainSpell vds = new VampireDrainSpell();

        vds.castSpell(this, unit);

        while (vds.hasEnoughElementsToCovertToSpell(getElements()) && (getMaxHp() - getHp() > 5)) {
            vds.castSpell(this, unit);
            getElements().useElements(vds.getElements());
        }

    }
}
