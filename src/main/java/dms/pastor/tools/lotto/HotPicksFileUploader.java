package dms.pastor.tools.lotto;

import dms.pastor.utils.DateUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 18/09/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class HotPicksFileUploader {
    private static final Logger LOG = Logger.getLogger(HotPicksFileUploader.class);
    private static final String DASH = "-";
    private final List<HotPickDraw> hotPickDrawList;

    HotPicksFileUploader() {
        hotPickDrawList = new ArrayList<>();
    }

    List<HotPickDraw> loadHotPicksDrawHistoryFile(String filePath) throws IOException {
        validateFilePath(filePath);

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(this::addIfLineValid);
        }
        return hotPickDrawList;
    }

    private void addIfLineValid(String line) {
        Optional<HotPickDraw> hotPickDraw = getHotPickDrawFromLine(line);
        hotPickDraw.ifPresent(hotPickDrawList::add);
    }

    //Normally this will throw exception BUT for sake of practice Java8 I will return
    private Optional<HotPickDraw> getHotPickDrawFromLine(String line) {
        if (line == null || line.isEmpty()) {
            return Optional.empty();
        }
        final String[] row = line.split(",");
        final int rowLength = 10;
        if (row.length != rowLength) {
            //TODO how to test logs ?
            LOG.warn(format("Row is invalid due wrong number of elements. Should be %d but was %d", rowLength, row.length));
            return Optional.empty();
        }
        LocalDate drawDate;
        int ball1;
        int ball2;
        int ball3;
        int ball4;
        int ball5;
        int ball6;
        int ballSet;
        String machine;
        int drawNumber;

        try {
            drawDate = parseLocalDate(row[0]);
            ball1 = validateBall(row[1]);
            ball2 = validateBall(row[2]);
            ball3 = validateBall(row[3]);
            ball4 = validateBall(row[4]);
            ball5 = validateBall(row[5]);
            ball6 = validateBall(row[6]);
            ballSet = Integer.parseInt(row[7]);
            machine = row[8];
            drawNumber = Integer.parseInt(row[9]);
        } catch (IllegalArgumentException iae) {
            LOG.warn("validation failed due " + iae.getMessage());
            return Optional.empty();
        }

        return Optional.of(new HotPickDraw(drawDate, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, machine, drawNumber));
    }

    LocalDate parseLocalDate(String drawDate) {
        validateDate(drawDate);
        final String[] date = drawDate.split(DASH);
        return LocalDate.of(Integer.parseInt(date[2]), DateUtils.getMonthNumberFromShortedName(date[1]), Integer.parseInt(date[0]));
    }

    private void validateDate(String drawDate) {

        if (drawDate == null || drawDate.isEmpty() || drawDate.split(DASH).length != 3) {
            throw new IllegalArgumentException(format("Date format is not valid.It should be dd-MMM-YYYY (for example 01-JAN-2016) but it was %s", drawDate));
        }
        final String[] date = drawDate.split(DASH);
        try {
            LocalDate.of(Integer.parseInt(date[2]), DateUtils.getMonthNumberFromShortedName(date[1]), Integer.parseInt(date[0]));
        } catch (Exception e) {
            LOG.warn(format("validation failed due %s", e.getMessage()), e);
            throw new IllegalArgumentException(e);
        }
    }

    private int validateBall(String ball) {
        final int ballNumber;
        try {
            ballNumber = Integer.parseInt(ball);
        } catch (Exception e) {
            throw new IllegalArgumentException("Data is corrupted .Ball is not a valid number  " + ball);
        }
        return ballNumber;
    }

    private void validateFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("Path shouldn't be null or empty");
        }

        if (isFileDoesNotExist(filePath)) {
            throw new IllegalArgumentException("Path is invalid or is not a file");
        }

        if (!new File(filePath).getAbsolutePath().endsWith(".csv")) {
            throw new IllegalArgumentException("It must be a csv file.");
        }
    }

    private boolean isFileDoesNotExist(String filePath) {
        return !(new File(filePath).exists() && new File(filePath).isFile());
    }

}
