package dms.pastor.prototype.dcs.actions;

import dms.pastor.prototype.dcs.units.Unit;

interface Action {

    void perform(Unit caster, Unit target);
}
