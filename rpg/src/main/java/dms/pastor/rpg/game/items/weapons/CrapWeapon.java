package dms.pastor.rpg.game.items.weapons;


class CrapWeapon extends Weapon {

    public CrapWeapon() {
        super(Hands.RIGHT);
        name = "Crap weapon";
        description = "As name suggest ,it's crap weapon";
        minDMG = 10;
        maxDMG = 20;
        accuracy = -10;
        evasion = -10;
    }

}
