package dms.pastor.prototypes.dcs.cards;

import dms.pastor.prototypes.dcs.events.AirElementEvent;
import dms.pastor.prototypes.dcs.spells.LightingBoltSpell;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(cardFound).hasSize(1);
        assertThat(cardFound.contains(event));

    }
}