package dms.pastor.game.dcs.actions;

import dms.pastor.game.dcs.units.Unit;

interface Action {

    void perform(Unit caster, Unit target);
}
