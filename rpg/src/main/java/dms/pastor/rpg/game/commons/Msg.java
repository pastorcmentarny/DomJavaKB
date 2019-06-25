package dms.pastor.rpg.game.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Msg {

    private static final String[] pubStories = {"A pub story 1",
        "A pub story 2", "A pub story 3", "A pub story 4", "A pub story 5"}; //TODO improve it
    private static final String[] sorryMessages = {"We apologize any inconvenience this may cause to you.", "Sorry for any troubles that,it will cause to you.", "I would like to apologise for any inconvenience caused."};

    public static String sayHelloDependsOnHour() {
        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour < 9) {
            return "Good morning to you";
        } else if (hour < 13) {
            return "Good day to you";
        } else if (hour < 19) {
            return "Good afternoon to you";
        } else {
            return "Good evening to you";
        }
    }

    public static String apologize() {
        return sorryMessages[new Random().nextInt(sorryMessages.length)];
    }

    public static String selectionNotAllowed() {
        return "Selection not allowed.";
    }

    public static String isWantFight(boolean wantFight) {
        return wantFight ? "FIGHT" : "PEACE";
    }

    public static void noHelp() {
        System.out.println("Sorry! No help available. Good luck and " + apologize());
    }

    public static String getRandomPubStory() {
        return pubStories[new Random().nextInt(pubStories.length)];
    }

    public static String getDEEM() {
        return "User typed some gibberish .. ";
    }

    public static String notAtHome(String name) {
        return name + " is not at home. Please left message after tone .... (Beep) ... You hate this voicemail messages ,so you just ignore it and left a place";
    }

    public static void cant(String what) {
        System.out.println("You can't " + what + "!");
    }


}