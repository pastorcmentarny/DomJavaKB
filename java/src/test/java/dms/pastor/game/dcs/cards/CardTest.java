package dms.pastor.game.dcs.cards;

import dms.pastor.game.dcs.events.AirElementEvent;
import dms.pastor.game.dcs.spells.LightingBoltSpell;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public final class CardTest {

    @Test
    public void getAllCardsForShouldReturnEventCards() {
        // given
        final AirElementEvent event = new AirElementEvent();

        List<Card> cards = new ArrayList<>();
        cards.add(new LightingBoltSpell());
        cards.add(event);

        // when
        final List<Card> cardFound = Card.getAllCardsFor(CardType.EVENT, cards);

        // then
        assertThat(cardFound).hasSize(1);
        assertThat(cardFound.contains(event));

    }
}