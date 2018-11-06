package dms.pastor.spring.examples.failureanalyzer;

import dms.pastor.spring.commons.exceptions.SomethingWentWrongException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ShitHappensFailureAnalyzer extends AbstractFailureAnalyzer<SomethingWentWrongException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, SomethingWentWrongException cause) {
        return new FailureAnalysis(
                "This is randomly generated error.",
                "Simply re-run app and you have 98.7% chances,it will work",
                cause);
    }
}
