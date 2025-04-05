package dms.pastor.examples.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data //contains @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
@Builder( toBuilder = true)
public class SongLombokExample {
    private String title;
    private String artist;
    private Genre genre;
    private LocalDate released;
    private int time;
    private boolean digitalOnly;

}
