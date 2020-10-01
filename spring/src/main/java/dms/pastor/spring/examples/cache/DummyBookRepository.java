package dms.pastor.spring.examples.cache;

import dms.pastor.spring.commons.exceptions.SomethingWentWrongException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DummyBookRepository implements BookRepository{

    @Override
    @Cacheable("book")
    public Book getByIsbn(String isbn) {
        relax();
        return new Book(isbn,"The title of the book");
    }

    private void relax() {
        log.info("Relaxing...");
        long time = 1000L;
        try {
            Thread.sleep(time);
        } catch (InterruptedException interruptedException) {
            throw new SomethingWentWrongException("Relaxing too long",interruptedException);
        }

    }


}
