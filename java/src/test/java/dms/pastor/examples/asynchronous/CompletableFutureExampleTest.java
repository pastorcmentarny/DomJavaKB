package dms.pastor.examples.asynchronous;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.assertj.core.api.Assertions.assertThat;

class CompletableFutureExampleTest {
    CompletableFutureExample completableFutureExample = new CompletableFutureExample();

    @Test
    public void simpleCompletableFutureExampleTest() throws InterruptedException, ExecutionException {
        Future<String> completableFuture = completableFutureExample.calculateAsync();

        String result = completableFuture.get();
        assertThat(result).isEqualTo("Hello");

    }

    @Test
    public void parallelRunningOfMultipleFuturesAcceptanceTest() throws ExecutionException, InterruptedException {
        final var result = completableFutureExample.parallelRunningOfMultipleFutures();
        assertThat(result).isEqualTo("Hello Beautiful World");
    }

    @Test
    public void errorHandlingDuringInCompletableFutureAcceptanceTest() throws ExecutionException, InterruptedException {
        final var completableFutureResult = completableFutureExample.errorHandlingDuringInCompletableFuture(null);
        assertThat(completableFutureResult.get()).isEqualTo("Hello, Stranger!");
    }
}