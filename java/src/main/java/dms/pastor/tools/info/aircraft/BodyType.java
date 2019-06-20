package dms.pastor.tools.info.aircraft;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.utils.ValidatorUtils;

import java.util.Arrays;

public enum BodyType {
    W("wide-body aircraft"),
    N("narrow-body aircraft"),
    D("double deck, wide-body aircraft");

    private final String description;

    BodyType(String description) {
        this.description = description;
    }

    public static BodyType getTypeFromLetter(String letter) {
        ValidatorUtils.validateIfObjectValueIsNotNull(letter);
        return Arrays.stream(BodyType.values()).filter(value -> value.name().equalsIgnoreCase(letter)).findFirst().orElseThrow(() -> new NotFoundException(letter));
    }

    public String getDescription() {
        return description;
    }
}
