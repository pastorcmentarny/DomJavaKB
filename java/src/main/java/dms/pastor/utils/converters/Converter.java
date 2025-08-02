package dms.pastor.utils.converters;

/**
 * Author: Dominik Symonowicz
 * Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
 * LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
 * GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 * Created 07.05.2020
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
