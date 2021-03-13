package dms.pastor.examples;


import java.util.function.Supplier;

public final class Lazy<T> {
    private volatile T value;

    public T getOrCompute(Supplier<T> supplier) {

        final T result = value; // Just one volatile read

        return result == null ? maybeCompute(supplier) : result;

    }

    private synchronized T maybeCompute(Supplier<T> supplier) {

        if (value == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = supplier.get();

        }

        return value;

    }


}

