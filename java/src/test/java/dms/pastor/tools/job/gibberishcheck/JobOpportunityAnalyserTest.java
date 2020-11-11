package dms.pastor.tools.job.gibberishcheck;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JobOpportunityAnalyserTest {

    @Disabled //work in progress
    @Test
    public void analyseShouldRespondWithCrapJobOpportunity() {
        // given
        final String[] args = {"/src/test/resources/jobs/test-db.txt", "/src/test/resources/jobs/crap.txt"};
        JobOpportunityAnalyser analyser = new JobOpportunityAnalyser(args);
        final String expectedResult = "This job description contains too much recruiter's gibberish to be worth consider. Result 42%.";
        // when
        final String result = analyser.analyse();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}