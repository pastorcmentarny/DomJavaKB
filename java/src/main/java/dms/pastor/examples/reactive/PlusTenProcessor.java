package dms.pastor.examples.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * Author Dominik Symonowicz
 * Created 02/10/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
class PlusTenProcessor extends SubmissionPublisher<Integer> implements Flow.Subscriber<Integer> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        submit(item + 10);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable error) {
        System.out.println("PlusTenProcessor throw Error: " + error.getMessage());
        closeExceptionally(error);
    }

    @Override
    public void onComplete() {
        System.out.println("PlusTenProcessor completed");
        close();
    }
}
