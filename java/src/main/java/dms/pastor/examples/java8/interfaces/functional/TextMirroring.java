package dms.pastor.kb.java8.interfaces.functional;

@FunctionalInterface
public interface TextMirroring<F, T> {
    T manipulate(F from);
}
