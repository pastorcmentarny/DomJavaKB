package dms.pastor.learn.pattern.builder.testdata;

import org.junit.Test;

import java.util.UUID;

import static dms.pastor.learn.pattern.builder.testdata.SkillsBuilder.skillsBuilder;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/05/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Test Data Builder pattern is based on Builder Pattern.
 * It is used to generate data for test,so you don't need setup things with default implementation with customisation needed
 * for particular test case.
 * It helps set data correctly and quicker (Specially for larger object values)
 * It helps you maintain tests as default value can be set in one place and it will highlight what side effect it may have
 * in your code.
 */
public class TestDataBuilderPatternAcceptanceTest {

    @Test
    public void unitBuilderShouldReturnUnitWithRandomPopulatedData() {

        // when
        final Unit result = UnitBuilder.unitBuilder().build();

        // then
        assertThat(result).isNotNull();

        // debug info
        System.out.println(result.toString());
    }


    @Test
    public void unitBuilderShouldReturnUnitWithDefinedData() throws Exception {
        // given
        final String name = "name";
        final int armor = 1;
        final int healthPoints = 2;
        final UUID id = randomUUID();
        final int minimumDamage = 3;
        final int maximumDamage = 4;
        final Skills skills = skillsBuilder().build();
        final Unit expectedResult = new Unit(name, id, skills, healthPoints, minimumDamage, maximumDamage, armor);

        // when
        final Unit result = UnitBuilder.unitBuilder()
                .setName(name)
                .setArmor(armor)
                .setHealthPoints(healthPoints)
                .setId(id)
                .setMinimumDamage(minimumDamage)
                .setMaximumDamage(maximumDamage)
                .setSkills(skills)
                .build();

        // then
        assertThat(result).isEqualTo(expectedResult);

    }

}