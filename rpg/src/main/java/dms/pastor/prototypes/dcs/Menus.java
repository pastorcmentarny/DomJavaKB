package dms.pastor.prototypes.dcs;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public final class Menus {

    private Menus() {
    }

    public static void displayPlayerActions() {
        System.out.println("1. Cast Spell.");
        System.out.println("0. End of Turn.");

    }

    public static void castSpell() {
        System.out.println("Type Number of elements,you want to use and semicolon for example 0;0;2;0;0;0 which means air,earth,(2)fire,water,life,death  which gives fireball");

    }
}
