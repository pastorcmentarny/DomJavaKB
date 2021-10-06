package dms.pastor.examples.java17.random;

import java.util.random.RandomGeneratorFactory;

import static java.text.MessageFormat.format;

public class EnhancedPseudoRandomNumberGeneratorsExample {

    private static final String EMPTY = "";

    public static void main(String[] args) {
        printAll();
    }

    private static void printAll() {
        RandomGeneratorFactory.all()
                .map(randomGeneratorFactory -> format("{0}:{1}(stateBits: {2})  '{'{3}{4}{5}{6}{7}{8}{9}{10} '}'",
                        randomGeneratorFactory.group(),
                        randomGeneratorFactory.name(),
                        randomGeneratorFactory.stateBits(),
                        randomGeneratorFactory.isSplittable() ? " splitable" : EMPTY,
                        randomGeneratorFactory.isStreamable() ? " streamable" : EMPTY,
                        randomGeneratorFactory.isJumpable() ? " jumpable" : EMPTY,
                        randomGeneratorFactory.isArbitrarilyJumpable() ? " arbitrary-jumpable" : EMPTY,
                        randomGeneratorFactory.isLeapable() ? " leapable" : EMPTY,
                        randomGeneratorFactory.isHardware() ? " hardware" : EMPTY,
                        randomGeneratorFactory.isStatistical() ? " statistical" : EMPTY,
                        randomGeneratorFactory.isStochastic() ? " stochastic" : EMPTY)
                )
                .sorted().forEach(System.out::println);
    }
}
