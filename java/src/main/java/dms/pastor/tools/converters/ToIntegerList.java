package dms.pastor.tools.converters;

import java.util.List;
import java.util.stream.Collectors;

import static dms.pastor.utils.ValidatorUtils.validateIfListHasIntegersOnly;

public class ToIntegerList {
    public static List<Integer> transform(List<String> integerAsStringList) {
        validateIfListHasIntegersOnly(integerAsStringList);
        return integerAsStringList.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }


}
