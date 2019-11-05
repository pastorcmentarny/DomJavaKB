package dms.pastor.prototypes.dcs.actions;

import dms.pastor.prototypes.dcs.units.Unit;

interface Action {

    void perform(Unit caster, Unit target);
}
