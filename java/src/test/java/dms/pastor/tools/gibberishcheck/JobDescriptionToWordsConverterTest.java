package dms.pastor.tools.gibberishcheck;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JobDescriptionToWordsConverterTest {

    private static final String JOB_DESCRIPTION = "A Sarcastic Java Developer. Call me +44 0 712 345 6789";

    @Test
    public void shouldBe8Words() {
        // when
        var wordList = JobDescriptionToWordsConverter.convert(JOB_DESCRIPTION);

        // then
        assertThat(wordList).hasSize(8);
    }

    @Test
    public void shouldNotContainsExcludedCharacters() {

        // when
        var wordList = JobDescriptionToWordsConverter.convert(JOB_DESCRIPTION);

        // then
        assertThat(wordList).doesNotContain(".");
        assertThat(wordList).doesNotContain(" ");
        assertThat(wordList).doesNotContain("+44");
        assertThat(wordList).doesNotContain("0");
    }


}