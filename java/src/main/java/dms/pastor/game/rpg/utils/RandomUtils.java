package dms.pastor.game.rpg.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: dsymonowicz
 * Date: 01/03/13
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class RandomUtils {
    private static ArrayList<String> studentName;


    //private static ArrayList<String> nameList;

    public static int generateNumberFromRange(int min, int max) {
        if (max - min > 0) {
            return min + new Random().nextInt(max - min);
        } else {
            return 1;//TODO remove it
        }


    }


    public static String getRandomWord() {
        ArrayList<String> swearWords = getList();
        return swearWords.get(new Random().nextInt(swearWords.size()));
    }

    public static ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Czego?");
        list.add("I co sie kurwa gapisz?//FIXME log.w nie widziales?");
        return list;
    }

    public static String getRandomName(ArrayList<String> list) {
        ArrayList<String> names = getNameList();
        return names.get(new Random().nextInt(names.size()));
    }

    public static ArrayList<String> getNameList() {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(getFemaleNameList());
        list.addAll(getMaleNameList());
        return list;
    }

    public static ArrayList<String> getFemaleNameList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Arlais");         //Arlais Female From the temple.
        list.add("Bubble");
        list.add("Genowefa");
        list.add("Dobrożyźń");  //staropolskie imię żeńskie
        list.add("Ophelia");
        list.add("Coyne");
        list.add("Amber");
        list.add("Adolfina");
        list.add("Rosemary");

        return list;
    }

    public static ArrayList<String> getMaleNameList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Ynyr");//Honor
        list.add("Culhwych");//possibly means "pig-lord.")
        list.add("Gwylan");//Gwylan	GWI lan	"seagull"
        list.add("Rusty");
        list.add("Porky");
        list.add("Myślidar");
        list.add("Minigniew");
        list.add("Cierpisław");
        list.add("Meilyr");  //man of iron (welsh)
        list.add("Llyr"); //grey-haired  (welsh)

        return list;
    }

    public static ArrayList<String> getAnimalNameList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Porky");
        list.add("Otto");
        list.add("Dick");
        list.add("Bishop");
        list.add("Smokey");
        list.add("Whiskey");
        list.add("Fudge");
        list.add("Cajun");
        list.add("Spooky");
        list.add("Biscuit");
        list.add("Copper");
        list.add("Cotton");
        list.add("Peanut");
        list.add("Tomba");
        list.add("Bazooka");
        list.add("Beefeater");
        list.add("Brie");
        list.add("Loaf");
        list.add("Ozwald");
        list.add("Jellyfish");

        return list;
    }


    public static ArrayList<String> getUniqueNameList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Dosichwaradynaina");     //Dos i chwarady nain 	 Go finger your granny         ;
        list.add("Cocoen");
        list.add("Anwsblewoga");
        list.add("Penbacha");
        list.add("Cachia");
        list.add("Tingocoena");
        list.add("Malucachua");
        list.add("Tianwodana");//Lick my balls    (in chinese)
        list.add("Sixia");//eat shit (in chinese)
        list.add("Sharbie");//stupid shit (in chinese)

        return list;
    }

    public static String getRandomStory() {
        //TODO implement it
        return "You save a world!";
    }

    public static ArrayList<String> getStudentName() {
        return studentName;
    }

    public static ArrayList<String> getStudentList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Dosichwaradynaina");     //Dos i chwarady nain 	 Go finger your granny         ;
        list.add("Cocoen");
        list.add("Anwsblewoga");
        return list;
    }
}
