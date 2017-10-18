package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dms.pastor.game.dcs.utils.random.InGameRandomUtils.ONE_THIRD;

public class MagneticDrainSpell extends Spell {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagneticDrainSpell.class);

    public MagneticDrainSpell(){
        name = "Magnetic Drain";
        setElements(new Elements(1, 1, 1, 1));
    }

    @Override
    public void castSpell(Unit attacker, Unit defender) {
        if(defender.getElements().countElements() <= 1){
            attacker.getElements().removeRandomElements(3);
        }else{
            final int maxToStole = defender.getElements().countElements() / 8;
            for (int i = 0; i < maxToStole; i++) {
                if (randomUtils.isWillHappenWithProbabilityOf(ONE_THIRD)) {
                    LOGGER.debug(defender.getName() + " will lose element.");
                    defender.getElements().removeRandomElements(1);
                }
            }
        }
    }
}
