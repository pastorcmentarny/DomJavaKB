package dms.pastor.spring.examples.mongo;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

import static dms.pastor.spring.utils.RandomDataGenerator.generateString;
import static dms.pastor.spring.utils.RandomDataGenerator.randomInteger;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CourseBuilder {
    public static final int MAX = 8;
    private Random random = new Random();

    private UUID courseId = UUID.randomUUID();
    private String name = generateString(MAX);
    private int points = randomInteger(MAX);
    private BigDecimal cost = new BigDecimal(random.nextFloat() * 100);
    private boolean mandatory = random.nextBoolean();

    private CourseBuilder() {
    }

    public static CourseBuilder courseBuilder() {
        return new CourseBuilder();
    }

    public Course build() {
        return new Course(courseId, name, points, cost, mandatory);
    }

    public CourseBuilder name(String name) {
        this.name = name;
        return this;
    }

    public CourseBuilder courseId(UUID courseId) {
        this.courseId = courseId;
        return this;
    }

    public CourseBuilder points(int points) {
        this.points = points;
        return this;
    }

    public CourseBuilder cost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public CourseBuilder mandatory(boolean mandatory) {
        this.mandatory = mandatory;
        return this;
    }
}
