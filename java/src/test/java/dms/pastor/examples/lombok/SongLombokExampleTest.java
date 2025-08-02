package dms.pastor.examples.lombok;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static dms.pastor.examples.lombok.Genre.ELECTRONIC;
import static org.assertj.core.api.Assertions.assertThat;

class SongLombokExampleTest {
    private static final String TITLE = "Halcyon On and On";
    private static final String ARTIST = "Orbital";
    private static final int TIME = 9 * 6 + 27;
    private static final LocalDate RELEASE_DATE = LocalDate.of(1992, 1, 1);
    SongLombokExample example = SongLombokExample.builder()
            .title(TITLE)
            .artist(ARTIST)
            .genre(ELECTRONIC)
            .time(TIME)
            .digitalOnly(false)
            .released(RELEASE_DATE)
            .build();

    @Test
    void  songLombokExampleAcceptanceTest() {
        // given
        SongLombokExample result = new SongLombokExample(TITLE,ARTIST,ELECTRONIC,RELEASE_DATE,TIME,false);

        // when and then
        assertThat(result).isEqualTo(example);
    }

    @Test
    void  songLombokExampleCreateNoArgsConstructor() {
        // given
        SongLombokExample result = new SongLombokExample();

        // when and then
        assertThat(result.getArtist()).isNull();
        assertThat(result.getTitle()).isNull();
        assertThat(result.getGenre()).isNull();
        assertThat(result.getTime()).isZero();
        assertThat(result.isDigitalOnly()).isFalse();
        assertThat(result.getReleased()).isNull();
    }

}