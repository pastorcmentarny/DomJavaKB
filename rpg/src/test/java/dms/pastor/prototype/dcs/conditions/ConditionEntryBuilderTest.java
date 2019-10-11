package dms.pastor.prototype.dcs.conditions;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class ConditionEntryBuilderTest {

    @Test
    public void buildPersistentConditionShouldCreatePersistentCondition() {
        // when
        final ConditionEntry conditionEntry = ConditionEntryBuilder.conditionEntryBuilder().buildPersistentCondition();

        // then
        assertThat(conditionEntry.isPersistent()).isTrue();
    }

    @Test
    public void buildPersistentConditionShouldCreateTemporaryCondition() {
        // when
        final ConditionEntry conditionEntry = ConditionEntryBuilder.conditionEntryBuilder().buildTemporaryCondition();

        // then
        assertThat(conditionEntry.isPersistent()).isFalse();
    }
}