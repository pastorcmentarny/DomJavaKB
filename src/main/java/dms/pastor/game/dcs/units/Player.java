package dms.pastor.game.dcs.units;

import dms.pastor.game.dcs.Elements;
import dms.pastor.game.dcs.Menus;
import dms.pastor.game.dcs.cards.Card;
import dms.pastor.game.dcs.conditions.Condition;
import dms.pastor.game.dcs.spells.Spell;
import dms.pastor.game.dcs.spells.Spells;
import dms.pastor.game.dcs.utils.DebugUtils;
import dms.pastor.game.dcs.utils.UserInputReader;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-25
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Player extends Unit {

    private static final Logger LOGGER = getLogger(Player.class);

    private final UserInputReader userInputReader;

    private final Spells spells = new Spells();

    public Player(int sp, Elements elements, int hp, ArrayList<Card> cards, boolean player, String name, int maxHp, int arm, Condition condition, String description, UserInputReader userInputReader) {
        super(sp, elements, hp, cards, player, name, maxHp, arm, condition, description);
        this.userInputReader = userInputReader;
    }

    public Player(String name, UserInputReader userInputReader) {
        setName(name);
        setPlayer();
        setShielded(false);
        this.userInputReader = userInputReader;
    }

    @Override
    public void turn(Unit unit) {

        Menus.displayPlayerActions();

        int text;

        try {
            text = userInputReader.getIntegerInput();
        } catch (Exception e) {
            System.out.print("Oh cock!" + e.getMessage());
            text = 0;
        }

        switch (text) {
            case 1:
                castSpell(unit);
                break;
            case 0:
                System.out.println("End of turn.");
                break;
            default:
                System.out.println("End of turn.");
                LOGGER.warn("Unknown choice");
                break;
        }
    }

    private void castSpell(Unit enemy) {
        Menus.castSpell();
        Elements spellElements;
        try (Scanner scanner = new Scanner(System.in)) {
            String spell = scanner.next();

            String[] input = spell.split(";");
            DebugUtils.displayInput(input);


            int a = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int f = Integer.parseInt(input[2]);
            int w = Integer.parseInt(input[3]);
            spellElements = new Elements(a, e, f, w);
        } catch (Exception e) {
            LOGGER.info("Whoops! " + e.getMessage());
            spellElements = Elements.noElements();
        }

        Spell aSpell = spells.findSpell(spellElements);
        if (aSpell != null) {
            if (aSpell.hasEnoughElementsToCovertToSpell(getElements())) {
                aSpell.castSpell(this, enemy);
                getElements().useElements(aSpell.getElements());
            } else {
                System.out.println("Not enough mana to cast " + aSpell.getName());
            }
        } else {
            System.out.println("Spell not found");
        }
    }
}
