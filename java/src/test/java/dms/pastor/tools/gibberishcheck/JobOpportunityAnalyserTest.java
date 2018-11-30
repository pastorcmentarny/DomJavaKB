package dms.pastor.tools.gibberishcheck;


import org.junit.Test;

import static dms.pastor.tools.gibberishcheck.GibberishCheckApplication.BASE_PATH;
import static org.assertj.core.api.Assertions.assertThat;

public class JobOpportunityAnalyserTest {

    private JobOpportunityAnalyser analyser;

    @Test
    public void analyseShouldRespondWithCrapJobOpportunity() {
        // given
        final String[] args = {"/src/test/resources/jobs/test-db.txt", BASE_PATH + "/src/test/resources/jobs/crap.txt"};
        analyser = new JobOpportunityAnalyser(args);
        final String expectedResult = "This job description contains too much recruiter's gibberish to be worth consider. Result 42%.";

        // when
        final String result = analyser.analyse();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}