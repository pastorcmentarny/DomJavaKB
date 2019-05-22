package dms.pastor.spring.examples.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static dms.pastor.spring.examples.ExamplesURL.MONGO;
import static dms.pastor.spring.examples.mongo.CourseBuilder.courseBuilder;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@RestController
public class MongoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoController.class);
    private final CourseRepository courseRepository;
    private final MongoTemplate mongoTemplate;
    private static final List<Course> courses;

    static {
        courses = new ArrayList<>(4);
        courses.add(courseBuilder().build());
        courses.add(courseBuilder().build());
        courses.add(courseBuilder()
            .courseId(UUID.fromString("e0b9a62f-aa80-4526-b1d9-59843097a48d"))
            .name("mongo welcome.html course")
            .points(100)
            .cost(new BigDecimal("17250.99"))
            .mandatory(true)
            .build());
    }

    @Autowired
    public MongoController(CourseRepository courseRepository, MongoTemplate mongoTemplate) {
        this.courseRepository = courseRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping(MONGO)
    public CourseResponse getALlCourses() {
        LOGGER.info("Getting all courses");
        generateCoursers();
        final List<Course> allCourses = mongoTemplate.findAll(Course.class);
        allCourses.forEach(System.out::println);
        return new CourseResponse(courseRepository.findAll());
    }

    private List<Course> generateCoursers() {
        //delete all courses that was created before
        courseRepository.deleteAll();
        //courseRepository.save(courses);
        return courses;
    }
}
