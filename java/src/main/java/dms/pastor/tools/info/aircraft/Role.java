package dms.pastor.tools.info.aircraft;

import dms.pastor.domain.exception.NotFoundException;
import dms.pastor.utils.ValidatorUtils;

import java.util.Arrays;

public enum Role {
    SHORT_HAUL("s", "short haul"),
    MEDIUM_HAUL("m", "medium haul"),
    SHORT_MEDIUM_HAUL("sm", "short to medium haul"),
    MEDIUM_LONG_HAUL("ml", "medium to long,k haul"),
    LONG_HAUL("l", "long haul");

    private String letter;
    private String description;

    Role(String letter, String description) {
        this.letter = letter;
        this.description = description;
    }

    public String getLetter() {
        return letter;
    }
    public String getDescription() {
        return description;
    }

    public static Role getTypeFromLetter(String letter) {
        ValidatorUtils.validateIfObjectValueIsNotNull(letter);
        return Arrays.stream(Role.values()).filter(value -> value.getLetter().equalsIgnoreCase(letter)).findFirst().orElseThrow(() -> new NotFoundException(letter));
    }

}
