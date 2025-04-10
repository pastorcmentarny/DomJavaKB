package dms.pastor.prototypes.dcs.cards;

import dms.pastor.prototypes.dcs.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@SuppressWarnings("AbstractClassWithoutAbstractMethods") // Class is abstract to prevent init
public abstract class Card extends Entity {

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

    private CardType getCardType() {
        return cardType;
    }

    protected void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

}
