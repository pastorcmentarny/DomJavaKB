package dms.pastor.game.dcs.actions;

import dms.pastor.game.dcs.units.Unit;

public interface Action {

    void perform(Unit caster, Unit target);
}
