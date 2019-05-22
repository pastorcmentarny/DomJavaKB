package dms.pastor.spring.examples.mongo;

import java.util.List;
import java.util.Objects;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class CourseResponse {

    private final List<Course> courses;

    @Deprecated  //jackson serialization use only
    public CourseResponse() {
        this(null);
    }

    public CourseResponse(List<Course> courses) {
        this.courses = courses;
    }

    private List<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseResponse that = (CourseResponse) o;
        return Objects.equals(getCourses(), that.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourses());
    }

    @Override
    public String toString() {
        return "CourseResponse{" +
            "courses=" + courses +
            '}';
    }
}
