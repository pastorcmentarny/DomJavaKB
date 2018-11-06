package dms.pastor.spring.examples.mongo;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * MongoDB stores data in collections. Spring Data MongoDB will map the class Course into a collection called course.
 */
public class Course {

    @Id //needed by mongodb as primary key
    private String id;
    private UUID courseId;
    private String name;
    private int points;
    private BigDecimal cost;
    private boolean mandatory;

    @Deprecated  //jackson serialization use only
    public Course() {
        this(null, 0, null, false);
    }

    public Course(String name, int points, BigDecimal cost, boolean mandatory) {
        this.courseId = UUID.randomUUID();
        this.name = name;
        this.points = points;
        this.cost = cost;
        this.mandatory = mandatory;
    }

    public Course(UUID courseId, String name, int points, BigDecimal cost, boolean mandatory) {
        this.courseId = courseId;
        this.name = name;
        this.points = points;
        this.cost = cost;
        this.mandatory = mandatory;
    }

    public UUID getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    @Override
    public String toString() {
        return format("Course{courseId=%s, name='%s', points=%d, cost=%s, mandatory=%s}", courseId, name, points, cost, mandatory);
    }
}
