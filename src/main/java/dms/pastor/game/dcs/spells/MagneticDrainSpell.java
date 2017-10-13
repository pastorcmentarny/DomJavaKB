package dms.pastor.game.dcs.spells;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.units.Unit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class MagneticDrainSpell extends Spell {

    private static final Logger LOGGER = LoggerFactory.getLogger(MagneticDrainSpell.class);
    private static final Random random = new Random();

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
                if(40 > random.nextInt(100)){
                    LOGGER.debug(defender.getName() + " ");
                    defender.getElements().removeRandomElements(1);
                }
            }
        }
    }
}
