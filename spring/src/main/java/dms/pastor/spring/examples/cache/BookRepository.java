package dms.pastor.spring.examples.cache;

public interface BookRepository {
    Book getByIsbn(String isbn);
}
