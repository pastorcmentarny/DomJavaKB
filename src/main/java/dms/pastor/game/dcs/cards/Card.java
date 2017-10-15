package dms.pastor.game.dcs.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 *
 * Class is abstract to prevent init
 */
public abstract class Card {

    protected String name;
    private String description = "No description";
    private CardType cardType;

    public static List<Card> getAllCardsFor(CardType type, List<Card> cards) {
        List<Card> result = new ArrayList<>();
        if (isCardListNotEmpty(cards)) {
            for (Card card : cards) {
                if (card.getCardType().name().equalsIgnoreCase(type.name())) {
                    result.add(card);
                }
            }
        }
        return result;
    }

    private static boolean isCardListNotEmpty(List<Card> cards) {
        return cards != null && !cards.isEmpty();
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected CardType getCardType() {
        return cardType;
    }

    protected void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

}
