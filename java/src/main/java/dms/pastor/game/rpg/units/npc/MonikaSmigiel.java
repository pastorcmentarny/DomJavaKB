package dms.pastor.game.rpg.units.npc;

import dms.pastor.game.rpg.cfg.Config;
import dms.pastor.game.rpg.quests.QuestMonitor;
import dms.pastor.game.rpg.quests.QuestState;
import dms.pastor.game.rpg.units.Hero;

import java.util.Random;


public class MonikaSmigiel extends NPC {

    private final QuestMonitor progress = QuestMonitor.getQuestMonitor();
    private final String[] reasons = {"soup was too salty.", " because today.", "is ugly.", "my nail is broken", "I tried to rush my bf to go to valentine's dinner and his response was ... 'give me a second darling I just finishing  m.. ting "};

    public MonikaSmigiel() {
        setName("Monika");
        setDescription("A mysterious lady that is connect to virtual world to be able to share pictures ... of food.What slim people knows about delicious food?");
    }

    @Override
    public void talk() {
        if (progress.sleepingMonika.equals(QuestState.COMPLETED)) {
            System.out.println("You met a random person who say thank you for to made this town much happier while Monika sleeping.");
        } else {
            System.out.println("You meet Monika.You asked ... how are you ?");
            System.out.println("She replied : " + getDepressionReason());
            System.out.println(" You -  ... ");
            if (progress.sleepingMonika.equals(QuestState.AVAILABLE)) {
                System.out.println("Somebody just pass you and monika and said ...I wish she just stop moaning.");
                progress.sleepingMonika = QuestState.INPROGRESS;

            } else if (progress.sleepingMonika.equals(QuestState.INPROGRESS)) {
                if (Hero.getHero().inventory.hasItem("Anesthesia Flower")) {
                    System.out.println("I understand you,but no worries .I have a flower for you");
                    Hero.getHero().inventory.getItemByName("Anesthesia Flower");
                    System.out.println("Monika says .. thank you ,smell the flower ... anf fall asleep. Somebody next to you say thank you!");
                    System.out.println("You got " + Config.MINOR_EXP_REWARD + " exp for solve this ");
                    Hero.getHero().addExp(Config.MINOR_EXP_REWARD);
                    progress.sleepingMonika = QuestState.COMPLETED;
                }
            } else {
                //TODO
            }
        }

    }

    private String getDepressionReason() {
        return reasons[new Random().nextInt(reasons.length)];
    }

    @Override
    public void smallTalk() {
        System.out.println(" You wanted to say hello to Monika,but you heard her doing *sigh* ,which means she is not in mood today,again,so you decided to be wise and don't talk to her.");
    }

    @Override
    public String getRandomPreTalk() {
        return "Monika just *sigh*";
    }
}
