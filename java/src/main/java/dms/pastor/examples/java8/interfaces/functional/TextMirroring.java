package dms.pastor.examples.java8.interfaces.functional;

@FunctionalInterface
public interface TextMirroring<F, T> {
    T manipulate(F from);
}
