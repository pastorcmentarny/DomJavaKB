package dms.pastor.prototypes.dcs.units;

import dms.pastor.prototypes.dcs.Elements;
import dms.pastor.prototypes.dcs.Menus;
import dms.pastor.prototypes.dcs.cards.Card;
import dms.pastor.prototypes.dcs.conditions.Condition;
import dms.pastor.prototypes.dcs.spells.Spell;
import dms.pastor.prototypes.dcs.spells.Spells;
import dms.pastor.prototypes.dcs.utils.DebugUtils;
import dms.pastor.prototypes.dcs.utils.UserInputReader;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

import static dms.pastor.prototypes.dcs.Elements.noElements;
import static dms.pastor.prototypes.dcs.Menus.displayPlayerActions;
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

    @SuppressWarnings({"AssignmentToNull", "ConstructorWithTooManyParameters"})
    public Player(int sp, Elements elements, Health health, ArrayList<Card> cards, String name, Condition condition, String description) {
        super(sp, elements, health, cards, name, condition, description);
        this.userInputReader = null;
        setPlayer();
    }

    public Player(String name, UserInputReader userInputReader) {
        setName(name);
        setPlayer();
        setShielded(false);
        this.userInputReader = userInputReader;
    }

    @Override
    public void turn(Unit unit) {
        displayPlayerActions();

        int integerInput;
        try {
            integerInput = userInputReader.getIntegerInput();
        } catch (Exception e) {
            System.out.print("Oh cock!" + e.getMessage());
            integerInput = 0;
        }

        switch (integerInput) {
            case 1 -> castSpell(unit);
            case 0 -> System.out.println("End of turn.");
            default -> {
                System.out.println("End of turn.");
                LOGGER.warn("Unknown choice");
            }
        }
    }

    private void castSpell(Unit enemy) {
        Menus.castSpell();
        Elements spellElements;
        try (Scanner scanner = new Scanner(System.in)) {
            String spell = scanner.next();

            String[] input = spell.split(";");
            DebugUtils.displayInput(input);

            spellElements = getElementsFromInput(input);
        } catch (Exception e) {
            LOGGER.info("Whoops! " + e.getMessage());
            spellElements = noElements();
        }

        final Spell aSpell = spells.findSpell(spellElements);
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

    private Elements getElementsFromInput(String[] input) {
        int a = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        int f = Integer.parseInt(input[2]);
        int w = Integer.parseInt(input[3]);
        return new Elements(a, e, f, w);
    }
}
