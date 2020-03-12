package dms.pastor.rpg.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author Dominik Symonowicz
 * Created 01.03.2013 at 15.44
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class RandomUtils {

    public static String getRandomWord() {
        ArrayList<String> swearWords = getList();
        return swearWords.get(new Random().nextInt(swearWords.size()));
    }

    private static ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Czego?");
        list.add("I co sie kurwa gapisz?//FIXME log.w nie widziales?");
        return list;
    }

    public static String getRandomName(ArrayList<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    public static ArrayList<String> getNameList() {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(getFemaleNameList());
        list.addAll(getMaleNameList());
        return list;
    }

    private static ArrayList<String> getFemaleNameList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Arlais");         //Arlais Female From the temple.
        list.add("Bubble");
        list.add("Genowefa");
        list.add("Dobrożyźń");  //staropolskie imię żeńskie
        list.add("Ophelia");
        list.add("Coyne");
        list.add("Amber");
        list.add("Adolfina");
        list.add("Rosemary");
        list.add("Akuji");//The meaning of this African name is "dead and awake" – not very cheery for a new life!
        list.add("Desdemona"); //Never mind that this Greek name means "of the devil", "ill-fated one" and "misery".
        list.add("Dolores");//From Spanish name, means "lady of sorrows"
        list.add("Kennedy");//A unisex name of Celtic and Gaelic origin, means "deformed head".
        list.add("Nerezza");//This Italian name means "darkness". Which isn't necessarily a BAD thing, but...
        list.add("Persephone"); //Again, there are two ways to think about this name. Yes, the first is the meanings of "to destroy" and "murder". But bear in mind that Persephone was the Greek goddess of Spring
        list.add("Sloane");// Gaelic name is slightly ambiguous – yes, it means "warrior" or "fighter", but that's not ALWAYS a bad thing, is it?
        list.add("Thana");   //Sounds lovely doesn't it? But Thana actually means "death" in Arabic. Gulp.
        list.add("Tristana");  //This Celtic name means "sorrowful" or "sad". Poor Tristana!
        return list;
    }

    private static ArrayList<String> getMaleNameList() {
        ArrayList<String> list = new ArrayList<>();
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
        list.add("Abaddon");// from Hebrew,means Abaddon means "Angel of death".
        list.add("Byron");// Byron is derived from Old English "byre", which means "cowshed".
        list.add("Das"); //This Indian name derives from the Sanskrit word Dasa, which means "servant" or "slave".
        list.add("Doyle");// From Irish name, means "dark stranger".
        list.add("Huxley");//This well-sounding name is of English origin – but it means "inhospitable place"
        list.add("Oleander");// - "poisonous flower".
        list.add("Little Sweetmeat");//"Swear to God."
        return list;
    }

    public static ArrayList<String> getAnimalNameList() {
        ArrayList<String> list = new ArrayList<>();
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
        ArrayList<String> list = new ArrayList<>();
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

    public static ArrayList<String> getStudentList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Dosichwaradynaina");     //Dos i chwarady nain 	 Go finger your granny         ;
        list.add("Cocoen");
        list.add("Anwsblewoga");
        return list;
    }
}
