package dms.pastor.game.rpg.items.weapons;


public class CrapWeapon extends Weapon {

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
