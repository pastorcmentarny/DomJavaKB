package dms.pastor.test.rules;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Author Dominik Symonowicz
 * Created 17/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Inspired by Frank Appel(https://gist.github.com/fappel)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ANNOTATION_TYPE, METHOD})
public @interface Repeat {
    int times() default 1;
}
