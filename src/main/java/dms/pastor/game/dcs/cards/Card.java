package dms.pastor.game.dcs.cards;


import java.util.ArrayList;

/**
 * Author Dominik Symonowicz
 * Created 2015-07-23
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public abstract class Card {
    protected String name;
    private String description = "No description";
    private CardType cardType;

    public static ArrayList<Card> getAllCardsFor(CardType type, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        if (cards != null && !cards.isEmpty()) {
            for (Card card : cards) {
                if (card.cardType.name().equalsIgnoreCase(type.name())) {
                    result.add(card);
                }
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CardType getCardType() {
        return cardType;
    }

    protected void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

}
