package dms.pastor.rpg.game.commons;

import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Errors {

    public static String getRandomCode() {
        String[] errors = {"404 - not found", "Catastrophic Failure", "Unexpected error found in unknown error",
                "No keyboard detected. Press F1 to resume.",
                "Software Failure. Press left mouse button to continue.\n Guru mediation #01234567,FEDCBA98", "Cannot delete this file.There is not enough free disk space. Delete one or more files to free disk space, and then try again."};
        //TODO implement 100 of common errors
        return errors[new Random().nextInt(errors.length)];
    }

    public static boolean getNotEnoughMoney() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void outOfStock() {
        System.out.println("OUT OF STOCK! (Feature not implement yet)");
    }

}
