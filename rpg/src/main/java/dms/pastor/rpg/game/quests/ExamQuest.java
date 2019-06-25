package dms.pastor.rpg.game.quests;

import dms.pastor.rpg.game.Bonus;
import dms.pastor.rpg.game.cfg.Config;
import dms.pastor.rpg.game.exceptions.GameOverException;
import dms.pastor.rpg.game.places.Bank;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Pastor Created Jan 18, 2015 at 7:32:59 PM
 */
public class ExamQuest extends Quest {
//TODO mini gra w ktorej trzeba odpowiedziec na 10 pytan z 100
    //TODO if you fail exams "It is a humiliating blunder that u fail exam.We are holding your feet to the fire on needed improvements".

    //static Logger log = Logger.getLogger(ExamQuest.class);
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private int a;
    private int b;
    private int answer;
    private static final int NUMBER_OF_POSSIBLE_QUESTIONS = 3;
    private int question = 0;
    private static final int questions = 10;
    private static final int RANGE_EASY = 100;
    private static final int RANGE_HARD = 1000;
    private int corrects = 0;
    private int wrongs = 0;
    private final boolean passed = false;

    //if fail student loan increase by 1000
    private void question(int range) {
        a = random.nextInt(range);
        b = random.nextInt(range);
        System.out.println("Question no." + question);
        boolean answered;
        switch (random.nextInt(NUMBER_OF_POSSIBLE_QUESTIONS) + 1) {
            case 1:
                answered = addQuestion();
                break;
            case 2:
                answered = substractionQuestion();
                break;
            case 3:
                answered = multiQuestion();
                break;
            case 4:
                answered = divisionQuestion(range);
                break;
            default:
                //FIXME log.warn("did you forgot add case for question ?");
                answered = false;
                break;

        }

        //TODO random messages for success and fails
        if (answered) {
            System.out.println("That's correct..");
            corrects++;
        } else {
            System.out.println("WRONG!");
            wrongs++;
        }
    }

    private boolean addQuestion() {

        System.out.println("What is sum of " + a + " " + b);
        try {
            answer = scanner.nextInt();
        } catch (Exception e) {
            //FIXME log.info("User typed some gibberish... ");
            return false;
        }
        return answer == a + b;
    }

    private boolean substractionQuestion() {
        if (b > a) {
            swap();
        }
        System.out.println("What is substraction of " + a + " " + b);
        try {
            answer = scanner.nextInt();
        } catch (Exception e) {
            //FIXME log.info("User typed some gibberish... ");
            return false;
        }
        return answer == a - b;
    }

    private boolean multiQuestion() {
        System.out.println("What is multiplication of " + a + " " + b);
        try {
            answer = scanner.nextInt();
        } catch (Exception e) {
            //FIXME log.info("User typed some gibberish... ");
            return false;
        }
        return answer == a * b;
    }

    private boolean divisionQuestion(int range) {
        while (a == 0 || b == 0) {
            if (a == 0) {
                a = random.nextInt(range);
            }
            if (b == 0) {
                b = random.nextInt(range);
            }
        }
        int c = a * b;
        System.out.println("What is result of " + c + "/" + b + "?");
        try {
            answer = scanner.nextInt();
        } catch (Exception e) {
            //FIXME log.info("User typed some gibberish... ");
            return false;
        }
        return answer == c / b;
    }

    private void swap() {
        int tmp = a;
        a = b;
        b = tmp;
    }

    //TODO create countdown
    @Override
    public void startAQuest() {
        System.out.println("Are you ready for exams? No? Lazy bastard!You lazy cows are never prepared,but it's your problem .. BUAHAHAHA.");
        System.out.println("Rules:\n\t10 Questions!\n\tYou make 3 mistakes and you FAIL. No mercy!\n\tYou have 5 seconds for response.");
        System.out.println("GOOD LUCK LOSERS!");
        boolean hasNextQuestion = true;
        question = 1;
        while (hasNextQuestion) {
            if (question <= questions - 3) {
                question(RANGE_EASY);
            } else {
                question(RANGE_HARD);
            }

            if (question >= questions || wrongs >= 3) {
                hasNextQuestion = false;
            }
            question++;
        }
        System.out.println("End of exam.You" + (passed ? " passed!Well done!" : " failed"));

    }

    @Override
    public Bonus getReward() {
        int bonus = 3 * corrects - 5 * wrongs;
        return new Bonus(bonus, 0);
    }

    private void penaltyFare() throws GameOverException {
        System.out.println("You failed your exam.You need redo exam and " + Config.EXAM_FAIL_PENALTY + " coins will be added to your loan");
        Bank.getBank().addLoad(Config.EXAM_FAIL_PENALTY);
    }

    @Override
    public boolean canQuestBeActivated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateQuestState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
