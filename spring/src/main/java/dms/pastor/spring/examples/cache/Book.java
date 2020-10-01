package dms.pastor.spring.examples.cache;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Book {
    private String isbn;
    private String title;
}
