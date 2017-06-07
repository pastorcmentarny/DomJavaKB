package dms.pastor.tools.lotto;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author Dominik Symonowicz
 * Created 10/03/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HotPickLeastPlayedCoupleFinder {

    //generate all possible combination of pair numbers between 1-59
    Set<Couple> generateAllUniqueCombinationFor(int[] numbersRange) {
        final int capacity = new Double(numbersRange.length * numbersRange.length * 1.3).intValue();
        HashSet<Couple> couples = new HashSet<>(capacity);
        for (int i : numbersRange) {
            for (int j : numbersRange) {
                if (i != j) {
                    couples.add(Couple.createWithOrderedNumbers(i, j));
                }
            }
        }
        return couples;
    }


    Set<Couple> generateCouplesFromDraws(List<HotPickDraw> draws) {
        Set<Couple> coupleSet = new HashSet<>();
        for(HotPickDraw draw : draws){
            coupleSet.addAll(generateCouplesFromDraw(draw));
        }
        return coupleSet;
    }

    //get all combination from last X games
    Set<Couple> generateCouplesFromDraw(HotPickDraw draw) {
        return new HashSet<>(generateAllUniqueCombinationFor(draw.getAllBalls()));
    }

    // check how many of them played
    Map<Couple, Integer> countCouplesInAllDraws(List<HotPickDraw> draws, int[] numbersRange) {
        Map<Couple, Integer> coupleMap = generateCoupleMap(numbersRange);

        for (HotPickDraw draw : draws) {
            final Set<Couple> couples = generateCouplesFromDraw(draw);
            for (Couple couple : couples) {
                coupleMap.put(couple, coupleMap.get(couple) + 1);
            }
        }
        return coupleMap;
    }

    private Map<Couple, Integer> generateCoupleMap(int[] numbersRange) {
        final Set<Couple> couples = generateAllUniqueCombinationFor(numbersRange);
        Map<Couple, Integer> coupleCounterMap = new HashMap<>();
        for (Couple couple : couples) {
            coupleCounterMap.put(couple, 0);
        }
        return coupleCounterMap;
    }

    // say which combination didn't play based on how rarely 2 numbers played
    List<Couple> getLeastPlayedCouple(List<HotPickDraw> draws, int[] numbersRange) {
        final Map<Couple, Integer> coupleCounterMap = countCouplesInAllDraws(draws, numbersRange);
        return coupleCounterMap.entrySet()
                .stream()
                .filter(element -> element.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
