package dms.pastor.spring.examples.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public interface CourseRepository extends MongoRepository<Course, UUID> {
    Course findByCourseId(UUID uuid);

    List<Course> findByMandatory(boolean mandatory);

    Course findByName(String name);

    List<Course> findByPoints(int points);
}
