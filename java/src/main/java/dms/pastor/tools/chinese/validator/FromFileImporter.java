package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;
import dms.pastor.utils.NumberUtils;
import dms.pastor.utils.file.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static dms.pastor.tools.chinese.validator.WordValidator.isWordValid;
import static dms.pastor.utils.StringUtils.COLUMN_SEPARATOR;
import static java.lang.String.format;

/**
 * Author Dominik Symonowicz
 * Created 11/10/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FromFileImporter implements Importer<List<Word>> {
    private static final String IGNORED_WORD = "////";
    private static final String GROUP_SEPARATOR = "~~";
    private static final Logger LOGGER = LoggerFactory.getLogger(FromFileImporter.class);
    public static final int COLUMNS = 11;
    private final List<Word> wordsList = new ArrayList<>();
    private int nr = 0;
    private int ignored = 0;

    private static String getLine(String line) {
        return line != null ? "[" + line + "]" : "line is empty.";
    }

    @SuppressWarnings("ProhibitedExceptionCaught") //it catch malformed line
    public Result<List<Word>> importDictionary(String filePath, String[] requestedCategories) {
        LOGGER.info("Loading words to rpg from file");
        clear();

        if (FileUtils.isFileNotExists(filePath)) {
            return new Result<>(false, "Path to file " + filePath + " do not exists.");
        }

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fileInputStream);
             BufferedReader br = new BufferedReader(isr)

        ) {
            String line;
            String[] data;

            while ((line = br.readLine()) != null) {
                if (isLineNotIgnored(line)) {
                    data = line.split(COLUMN_SEPARATOR);
                    Result<List<Word>> result = processLine(requestedCategories, line, data);
                    if (result.isFail()) return result;
                } else {
                    LOGGER.warn("This line is ignored: Dictionary :{}", line);
                    ignored++;
                }
            }
        } catch (FileNotFoundException e) {
            return returnFailResultOnException(e);
        } catch (IOException e) {
            return returnFailResultOnException("IOException", nr, e, wordsList);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return returnFailResultOnException("ArrayIndexOutOfBoundsException", nr, arrayIndexOutOfBoundsException, wordsList);
        }
        return new Result<>(true, format("Dictionary loaded successfully.(Words loaded: %d, Ignored: %d)", wordsList.size(), ignored), wordsList);
    }

    @SuppressWarnings("ProhibitedExceptionCaught") // Catch this exception to show error to user
    private Result<List<Word>> processLine(String[] requestedCategories, String line, String[] data) {
        Word word;
        try {
            if (data.length != COLUMNS) {
                final String msg = String.format("wrong number of elements. Should be %d but was %d", COLUMNS, data.length);
                LOGGER.error(msg);
                return new Result<>(false, msg);
            }
            word = parseWord(data);
            if (isWordValid(word)) {
                addWordToWordList(requestedCategories, getWordCategories(data), word);
            } else {
                LOGGER.error("Word is corrupted(Line:" + getCurrentLine(nr) + ".It is something wrong with Dictionary." + getLine(line));
                return new Result<>(false, "Validation failed as Word is invalid at line: " + (getCurrentLine(nr)) + ")\n.Problem occurred in: " + getLine(line));
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException nfe) {
            return returnFailResultOnException(line, nr, nfe, Collections.emptyList());
        }
        return new Result<>(true);
    }

    private void clear() {
        wordsList.clear();
        nr = 0;
        ignored = 0;
    }

    private Result<List<Word>> returnFailResultOnException(Exception exception) {
        return returnFailResultOnException("File not found", Integer.MIN_VALUE, exception, Collections.emptyList());
    }

    private Result<List<Word>> returnFailResultOnException(String errorMessage, int nr, Exception exception, List<Word> wordsList) {
        String msg = getErrorIntroMessage(nr) + exception.getMessage() + " in " + errorMessage;// getLine??
        LOGGER.warn(msg);
        return new Result<>(false, msg, wordsList);
    }

    private String[] getWordCategories(String[] data) {
        return data[7].split(GROUP_SEPARATOR);
    }

    private boolean isLineNotIgnored(String strLine) {
        return !strLine.startsWith(IGNORED_WORD);
    }

    private int getCurrentLine(int nr) {
        return nr + 1;
    }

    private String getErrorIntroMessage(int nr) {
        if (nr == Integer.MIN_VALUE) {
            return "Error: ";
        } else {
            return "Error at line: " + nr + " caused by ";
        }
    }

    private Word parseWord(String[] data) {
        int difficulty = getDifficulty(data[9]);
        String[] groups = getWordCategories(data);
        return new Word(Integer.parseInt(data[1]), data[2], data[3], Integer.parseInt(data[4]), data[5], data[6], groups, data[8], difficulty, data[10]);
    }

    private int getDifficulty(String difficulty) {
        return NumberUtils.parseNullSafeIntegerAsString(difficulty, Integer.MIN_VALUE);
    }

    private void addWordToWordList(String[] requestedCategories, String[] wordCategoriesList, Word word) {
        if (requestedCategories != null) {
            addWordIfExistsInRequestedCategories(requestedCategories, wordCategoriesList, word);
        } else {
            addWordToList(word);
        }
    }

    private void addWordIfExistsInRequestedCategories(String[] requestedCategories, String[] wordCategoriesList, Word word) {
        for (String requestedCategory : requestedCategories) {
            addWordIfExistInRequestedCategory(wordCategoriesList, word, requestedCategory);
        }
    }

    private void addWordIfExistInRequestedCategory(String[] wordCategoriesList, Word word, String requestedCategory) {
        for (String wordCategory : wordCategoriesList) {
            if (wordCategory.equals(requestedCategory)) {
                addWordToList(word);
            }
        }
    }

    private void addWordToList(Word word) {
        wordsList.add(word);
        addLineNumber();
    }

    private void addLineNumber() {
        nr++;
    }

}
