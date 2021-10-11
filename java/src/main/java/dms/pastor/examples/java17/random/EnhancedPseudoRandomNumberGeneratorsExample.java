package dms.pastor.examples.java17.random;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import static java.text.MessageFormat.format;

public class EnhancedPseudoRandomNumberGeneratorsExample {

    private static final String EMPTY = "";

    public static void main(String[] args) {
        printAllRandomGeneratorFactories();
        newDefaultGenerator();
    }

    private static void printAllRandomGeneratorFactories() {
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

    private static void newDefaultGenerator() {
        RandomGenerator randomGenerator = RandomGenerator.getDefault(); // new way to get trandom
        System.out.println(randomGenerator.nextFloat());
        System.out.println(randomGenerator.nextFloat(10));
        System.out.println(randomGenerator.nextFloat(10, 20));
        System.out.println(randomGenerator.isDeprecated());
        System.out.println(randomGenerator.nextBoolean());
        System.out.println(randomGenerator.nextDouble());
        System.out.println(randomGenerator.nextDouble(10));
        System.out.println(randomGenerator.nextDouble(10, 20));
        System.out.println(randomGenerator.nextExponential());
        System.out.println(randomGenerator.nextGaussian());
        randomGenerator.doubles(25, 0, 0.5)
                .sorted()
                .forEach(System.out::println);
        randomGenerator.ints(25, 0, 100)
                .sorted()
                .forEach(System.out::println);
        randomGenerator.longs(25, 0, 10000000L)
                .sorted()
                .forEach(System.out::println);
    }
}
