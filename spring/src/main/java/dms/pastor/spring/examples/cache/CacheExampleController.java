package dms.pastor.spring.examples.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheExampleController {

    private final BookRepository bookRepository;

    @Autowired
    public CacheExampleController(@Qualifier("dummyBookRepository") BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/example/cache")
    public String getBook() {
        return bookRepository.getByIsbn("1000").toString();
    }
}
