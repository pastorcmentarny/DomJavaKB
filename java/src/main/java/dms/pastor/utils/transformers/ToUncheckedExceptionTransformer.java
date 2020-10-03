package dms.pastor.utils.transformers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * Author Dominik Symonowicz
 * Created 02/01/2019
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
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
