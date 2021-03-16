package dms.pastor.utils.converters;

/**
 * Author Dominik Symonowicz
 * Created 07.05.2020
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
