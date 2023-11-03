package dms.pastor.examples.java21;

import java.util.LinkedHashSet;

//These interfaces come with additional methods that provide improved access and manipulation capabilities for collections.
public class SequencedCollectionsExamples {

    //Sequenced Collections feature, accessing the first and last elements becomes more consistent and straightforward.
    public static void main(String[] args) {
        runSequencedCollectionsExample();
    }

    private static void runSequencedCollectionsExample() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("London");
        linkedHashSet.add("Bath");
        linkedHashSet.add("York");
        linkedHashSet.add("Cardiff");
        linkedHashSet.add("Edinburgh");
        linkedHashSet.add("Glasgow");
        linkedHashSet.add("Cambridge");


        System.out.println(linkedHashSet.getFirst());
        System.out.println(linkedHashSet.getLast());

        System.out.println(linkedHashSet.size());
        System.out.println(linkedHashSet.removeFirst());
        System.out.println(linkedHashSet.removeLast());
        System.out.println(linkedHashSet.size());
        System.out.println(linkedHashSet);
        System.out.println(linkedHashSet.reversed());

    }
}
