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
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class Player extends Unit {

    private static final Logger LOGGER = getLogger(Player.class);

    private final UserInputReader userInputReader;

    private final Spells spells = new Spells();

    public Player(boolean shielded, int sp, Elements elements, int hp, ArrayList<Card> cards, boolean player, String name, int maxHp, int arm, Condition condition, String description, UserInputReader userInputReader) {
        super(shielded, sp, elements, hp, cards, player, name, maxHp, arm, condition, description);
        this.userInputReader = userInputReader;
    }

    public Player(String name, UserInputReader userInputReader) {
        setName(name);
        setPlayer(true);
        setShielded(true);
        setSp(24);
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
        Scanner scanner = new Scanner(System.in);
        String spell = scanner.next();

        String[] input = spell.split(";");
        DebugUtils.displayInput(input);
        Elements spellElements;
        try {
            int a = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int f = Integer.parseInt(input[2]);
            int w = Integer.parseInt(input[3]);
            int l = Integer.parseInt(input[4]);
            int d = Integer.parseInt(input[5]);
            spellElements = new Elements(a, e, f, w, l, d);
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