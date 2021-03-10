package dms.pastor.examples.principles;

import dms.pastor.domain.ExampleObject;

public class DependencyInjectionViaConstructor {
    private ExampleObject exampleObject;

    public DependencyInjectionViaConstructor(ExampleObject example){
        exampleObject = example;
    }
}