package dms.pastor.tools.lotto.euro;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.tools.lotto.hotpick.DrawList;
import dms.pastor.tools.lotto.hotpick.FileUploader;
import dms.pastor.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static dms.pastor.tools.lotto.LottoConstants.*;
import static dms.pastor.tools.lotto.LottoFilePathValidator.validateFilePath;
import static dms.pastor.tools.lotto.common.LottoValidator.validateDate;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class EuroFileUploader implements FileUploader {

    private static final Logger LOGGER = LoggerFactory.getLogger(EuroFileUploader.class);

    private final List<EuroDraw> euroDrawList;

    public EuroFileUploader() {
        euroDrawList = new ArrayList<>();
    }

    public DrawList loadDrawHistoryFile(String filePath) {
        validateFilePath(filePath);
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(this::addIfLineValid);
        } catch (IOException e) {
            throw new SomethingWentWrongException("Getting lines from file", e);
        }
        LOGGER.debug("File contains " + euroDrawList.size() + " draws.");
        return new DrawList<>(euroDrawList);
    }

    private void addIfLineValid(String line) {
        Optional<EuroDraw> euroDraw = getDrawFromLine(line);
        euroDraw.ifPresent(euroDrawList::add);
    }

    //Normally this will throw exception BUT for sake of practice Java8 I will return
    private Optional<EuroDraw> getDrawFromLine(String line) {
        if (line == null || line.isEmpty()) {
            return Optional.empty();
        }
        final String[] row = line.split(",");
        if (checkRowLength(row)) {
            return Optional.empty();
        }
        LocalDate drawDate;
        int ball1;
        int ball2;
        int ball3;
        int ball4;
        int ball5;
        int luckyStar1;
        int luckyStar2;
        String ukMillionaireMaker = "";
        int drawNumber = 0;

        try {
            drawDate = parseLocalDate(row[0]);
            ball1 = validateBall(row[1]);
            ball2 = validateBall(row[2]);
            ball3 = validateBall(row[3]);
            ball4 = validateBall(row[4]);
            ball5 = validateBall(row[5]);
            luckyStar1 = validateLuckyStar(row[6]);
            luckyStar2 = validateLuckyStar(row[7]);
            //ukMillionaireMaker = row[8];
            //drawNumber = Integer.parseInt(row[9]);
        } catch (IllegalArgumentException iae) {
            LOGGER.warn("validation failed due " + iae.getMessage());
            return Optional.empty();
        }

        return Optional.of(new EuroDraw(drawDate, ball1, ball2, ball3, ball4, ball5, luckyStar1, luckyStar2, ukMillionaireMaker, drawNumber));
    }

    private boolean checkRowLength(String[] row) {
        final int rowLength = 11;
        if (row.length != rowLength) {
            //TODO how to test logs ?
            LOGGER.warn(format("Row is invalid due wrong number of elements. Should be %d but was %d", rowLength, row.length));
            return true;
        }
        return false;
    }

    private LocalDate parseLocalDate(String drawDate) {
        validateDate(drawDate);
        final String[] date = drawDate.split(DASH);
        return LocalDate.of(Integer.parseInt(date[2]), DateUtils.getMonthNumberFromShortedName(date[1]), Integer.parseInt(date[0]));
    }


    private int validateBall(String ball) {
        final int ballNumber;
        try {
            ballNumber = Integer.parseInt(ball.trim());
            if (ballNumber < EURO_BALL_MINIMUM_VALUE || ballNumber > EURO_BALL_MAXIMUM_VALUE) {
                throw new IllegalArgumentException(String.format("Lucky Star is not in range. Should be between %d and %d but was %d.", EURO_BALL_MINIMUM_VALUE, EURO_BALL_MAXIMUM_VALUE, ballNumber));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Data is corrupted .Ball is not a valid number  " + ball, e);
        }
        return ballNumber;
    }

    private int validateLuckyStar(String ball) {
        final int ballNumber;
        try {
            ballNumber = Integer.parseInt(ball.trim());
            if (ballNumber < LUCKY_STAR_MIN || ballNumber > LUCKY_STAR_MAX) {
                throw new IllegalArgumentException(String.format("Lucky Star is not in range. Should be between %d and %d but was %d.", LUCKY_STAR_MIN, LUCKY_STAR_MAX, ballNumber));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Data is corrupted .Lucky star is not a valid number  " + ball, e);
        }
        return ballNumber;
    }


}
