package dms.pastor.test.rules;

import org.junit.runners.model.Statement;

/**
 * Author Dominik Symonowicz
 * Created 17/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p/>
 * tag-repeat
 * <p>
 * Inspired by Frank Appel(https://gist.github.com/fappel)
 */
class RepeatStatement extends Statement {
    private final int times;
    private final Statement statement;

    RepeatStatement(int times, Statement statement) {
        this.times = times;
        this.statement = statement;
    }

    @Override
    public void evaluate() throws Throwable {
        for (int i = 0; i < times; i++) {
            statement.evaluate();
        }
    }
}
