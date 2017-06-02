package dms.pastor.game.dcs.units.enemies;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.spells.AntiShieldPiercingSpell;
import dms.pastor.game.dcs.spells.FireBall;
import dms.pastor.game.dcs.units.Unit;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-24
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FireElement extends Unit {

    public FireElement() {
        super();
        setName("Fire element");
        setShielded(true);
        setElements(new Elements(10));
        setSp(24);
    }


    @Override
    public void turn(Unit unit) {
        if (getElements().getWater() > 0) {
            int dmg = getElements().getWater() * 2;
            doesDamage(dmg, unit);
            System.out.println("Water elements  cause " + dmg);
            if (isDead()) {
                return;
            }
        }

        if (unit.getSp() > 0 && (getElements().getAir() >= 1 && getElements().getFire() >= 1 && getElements().getDeath() >= 2)) {
            AntiShieldPiercingSpell spell = new AntiShieldPiercingSpell();
            spell.castSpell(this, unit);
            getElements().setFire(getElements().getAir() - 1);
            getElements().setFire(getElements().getFire() - 1);
            getElements().setFire(getElements().getDeath() - 2);
        }

        while (getElements().getFire() >= 1) {
            System.out.println(getName() + " will attack!");
            FireBall fireBall = new FireBall();
            fireBall.castSpell(this, unit);
            getElements().setFire(getElements().getFire() - 1); // Fireball takes only half
        }

        if (getElements().getEarth() >= 3) {
            int fireAdd = getElements().getEarth() / 3;
            System.out.println("Morphing earth elements into " + fireAdd + " fire elements.");
            getElements().setEarth(getElements().getEarth() % 3);
        }

        if (getElements().getAir() >= 3) {
            int airAdd = getElements().getAir() / 3;
            System.out.println("Morphing air elements into " + airAdd + " air elements.");
            getElements().setEarth(getElements().getEarth() % 3);
        }

        if (getElements().getLife() >= 3) {
            int fireAdd = getElements().getLife() / 3;
            System.out.println("Morphing life elements into " + fireAdd + " fire elements.");
            getElements().setEarth(getElements().getLife() % 3);
        }

        if (getElements().getDeath() >= 3) {
            int fireAdd = getElements().getDeath() / 3;
            System.out.println("Morphing death elements into " + fireAdd + " fire elements.");
            getElements().setEarth(getElements().getDeath() % 3);
        }
    }
}
