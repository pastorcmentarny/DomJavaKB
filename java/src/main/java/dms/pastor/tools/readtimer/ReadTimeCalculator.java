package dms.pastor.tools.readtimer;

import static dms.pastor.utils.DateUtils.HOUR;
import static dms.pastor.utils.DateUtils.MINUTE;
import static dms.pastor.utils.StringUtils.*;

/**
 * Author Dominik Symonowicz
 * Created 06/04/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class ReadTimeCalculator {

    private final String text;
    private final int wordsPerMinute;

    ReadTimeCalculator(String text, int wordsPerMinute) {
        this.text = text;
        this.wordsPerMinute = wordsPerMinute;
    }

    int calculateTimeNeedToReadFor() {
        validateIfStringIsNotBlank(text);
        final String[] words = splitContentIntoWords(text);
        int wordCount = WordCounter.countFullWords(words);
        return calculateTimeInSeconds(wordCount, wordsPerMinute);
    }

    String displayTimeNeededToRead() {
        int time = calculateTimeNeedToReadFor();
        int timeLeft = time;

        if (time <= 0) {
            return "Unable to calculate time due invalid time given.";
        } else if (time == 1) {
            return "1 second to read.";
        } else {
            int hours = timeLeft / HOUR;
            timeLeft -= (hours * HOUR);
            int minutes = timeLeft / MINUTE;
            timeLeft -= (minutes * MINUTE);
            String timeAsString = EMPTY_STRING;
            if (hours > 0) {
                timeAsString += hours + " hour" + plural(hours);
            }
            if (minutes > 0) {
                timeAsString += addAnd(hours);
                timeAsString += minutes + " minute" + plural(minutes);
            }
            if (timeLeft > 0) {
                timeAsString = addColonAndAnd(timeAsString, hours, minutes, timeLeft);
                timeAsString += timeLeft + " second" + plural(timeLeft);
            }
            return timeAsString + "to read.";
        }
    }

    private String addColonAndAnd(String text, int hours, int minutes, int seconds) {
        String output = text;
        if (hours > 0 && minutes > 0) {
            output = text.replaceAll(" and", ",");
        }
        if (hours > 0 || minutes > 0) {
            return output + addAnd(seconds);
        } else {
            return output;
        }
    }

    private void validateIfStringIsNotBlank(String text) {
        if (isStringBlank(text)) {
            throw new IllegalArgumentException("It must contain not empty text with size bigger than 1 character");
        }
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext") // accuracy do not matter
    private int calculateTimeInSeconds(int words, int wordsPerMinute) {
        if (wordsPerMinute < MINUTE) {
            throw new IllegalArgumentException("Speed of reading must be equal or higher than 60  words per minute");
        }
        double wordsPerSeconds = wordsPerMinute / MINUTE;
        return Double.valueOf(words / wordsPerSeconds).intValue();
    }

    private String addAnd(int time) {
        return time > 0 ? "and " : EMPTY_STRING;
    }

    private String plural(int minutes) {
        return minutes > 1 ? "s " : WHITESPACE;
    }
}
