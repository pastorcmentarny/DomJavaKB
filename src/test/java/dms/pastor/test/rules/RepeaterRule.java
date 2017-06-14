package dms.pastor.test.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Author Dominik Symonowicz
 * Created 17/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * Rule used to run the same method many times
 * <p>
 * Inspired by Frank Appel(https://gist.github.com/fappel)
 */
public class RepeaterRule implements TestRule {
    public static RepeaterRule use() {
        return new RepeaterRule();
    }

    @Override
    public Statement apply(Statement statement, Description description) {
        Statement result = statement;
        Repeat repeat = description.getAnnotation(Repeat.class);
        if (repeat != null) {
            int times = repeat.times();
            result = new RepeatStatement(times, statement);
        }
        return result;
    }
}
