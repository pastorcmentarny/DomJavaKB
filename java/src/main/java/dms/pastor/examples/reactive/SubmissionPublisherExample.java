package dms.pastor.examples.reactive;

import java.util.concurrent.SubmissionPublisher;

/**
 * Author Dominik Symonowicz
 * Created 02/10/2018
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
public class SubmissionPublisherExample {
    public void example() throws Exception {
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        PlusTenProcessor processor = new PlusTenProcessor();
        PrintSubscriber subscriber = new PrintSubscriber();
        publisher.subscribe(processor);
        processor.subscribe(subscriber);
        System.out.println("Submitting items...");
        for (int i = 0; i < 10; i++) {
            publisher.submit(i);
        }
        Thread.sleep(100);
        publisher.close();
    }
}