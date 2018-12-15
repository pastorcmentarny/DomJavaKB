package dms.pastor.learn.basics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class StreamExamples {

    public static Map<String, Integer> getExampleData() {
        final Map<String, Integer> itemsPrice = new HashMap<>();
        itemsPrice.put("garlic", 25);
        itemsPrice.put("cheesecake", 140);
        itemsPrice.put("cheese", 112);
        itemsPrice.put("lemon", 22);
        itemsPrice.put("honey", 45);
        return itemsPrice;
    }


    // Sort a Map by Value example
    // TODO convert to java11, add test for this
    public static Map<String, Integer> sortByPrice(Map<String, Integer> items) {
        return items.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
