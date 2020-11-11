package dms.pastor.examples.patterns.strategy;

import dms.pastor.examples.patterns.PatternRunner;
import dms.pastor.examples.patterns.domain.Animal;
import dms.pastor.examples.patterns.domain.Bird;
import dms.pastor.examples.patterns.domain.CanFly;
import dms.pastor.examples.patterns.domain.Dog;

public class StrategyPatternRunner {

    private PatternRunner patternRunner = PatternRunner.builder()
            .name("Strategy")
            .type("Behavioral")
            .description("It lets the algorithm vary independently from client that uses it. It defines a family of algorithms, encapsulate eac one, and make them interchangeable. It is good for reduce conditions,avoid duplicate code but it will increase number of classes.")
            .example("Collections.sort()")
            .build();


    public void run() {
        patternRunner.displayDefinition();
        Animal doggy = new Dog();
        Animal tweety = new Bird();
        doggy.displayFlyAbility();
        tweety.displayFlyAbility();
        doggy.setFlyingType(new CanFly());
        doggy.displayFlyAbility();
    }

    public static void main(String[] args) {
        new StrategyPatternRunner().run();
    }
}
