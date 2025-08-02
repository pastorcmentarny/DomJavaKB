package dms.pastor.utils.transformers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 02/01/2019
 * tag-lambada tag-checked-exception
 */
public interface ToUncheckedExceptionTransformer<T, R, E extends Throwable> {
    Logger LOGGER = LoggerFactory.getLogger(ToUncheckedExceptionTransformer.class);

    static <T, R, E extends Throwable> Function<T, R> transformToUncheckedException(ToUncheckedExceptionTransformer<T, R, E> function) {
        return exception -> {
            try {
                return function.apply(exception);
            } catch (Throwable throwable) {
                LOGGER.error(throwable.getMessage());
                throw new RuntimeException(throwable);
            }
        };
    }

    R apply(T t) throws E;
}
