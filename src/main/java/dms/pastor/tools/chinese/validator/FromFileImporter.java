package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;
import dms.pastor.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static dms.pastor.domain.Result.fail;
import static dms.pastor.domain.Result.success;
import static dms.pastor.tools.chinese.validator.WordValidator.validateWord;

/**
 * Author Dominik Symonowicz
 * Created 11/10/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class FromFileImporter implements Importer {
    private static final String IGNORED_WORD = "////";
    private static final String COLUMN_SEPERATOR = ";;";
    private static final String GROUP_SEPERATOR = "~~";
    private static final Logger LOGGER = LoggerFactory.getLogger(FromFileImporter.class);

    private static void closeReaderQueitly(Reader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.warn("Unable to close  due " + e.getMessage(), e);
        }
    }

    private static String getLine(String line) {
        return line != null ? "[" + line + "]" : "line is empty.";
    }

    public Result importDictionary(String filePath, String[] requestedCategories) {
        LOGGER.info("Loading words to dictionary from file");
        List<Word> wordsList = new ArrayList<>();

        File file = new File(filePath);
        if (!file.exists()) {
            return fail("File to dictionary not found");
        }

        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return returnFailResultOnException("File not found", e);
        }
        BufferedReader br;
        InputStreamReader isr;
        String line;
        String[] data;
        Word word;
        int nr = 0;
        try {
            isr = new InputStreamReader(fileInputStream);
            br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                if (lineIsNotIgnored(line)) {
                    data = line.split(COLUMN_SEPERATOR);
                    try {
                        word = parseWord(data);
                        if (validateWord(word)) {
                            nr = addWordToWordList(wordsList, requestedCategories, getWordCategories(data), word, nr); //TODO imporve nr
                        } else {
                            LOGGER.error("Word is corrupted(Line:" + getCurrentLine(nr) + ".It is something wrong with Dictionary." + getLine(line));
                            return fail("Validation failed as Word is invalid at line: " + (getCurrentLine(nr)) + ")\n.Problem occurred in: " + getLine(line));
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException nfe) {
                        return returnFailResultOnException(line, nr, nfe);
                    }
                } else {
                    LOGGER.warn("This line is ignored: Dictionary :", line);
                    //TODO add total ignored line
                }
            }
        } catch (IOException e) {
            return returnFailResultOnException("IOException", nr, e);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            return returnFailResultOnException("ArrayIndexOutOfBoundsException", nr, aioobe);
        }
        closeReaderQueitly(isr);
        closeReaderQueitly(br);
        return success("Dictionary loaded successfully.");
    }

    private Result returnFailResultOnException(String errorMessage, Exception exception) {
        return returnFailResultOnException(errorMessage, Integer.MIN_VALUE, exception);
    }

    private Result returnFailResultOnException(String errorMessage, int nr, Exception exception) {
        String msg = getErrorIntroMessage(nr) + exception.getMessage() + " in " + errorMessage;// getLine??
        LOGGER.warn(msg);
        return fail(msg);
    }

    private String[] getWordCategories(String[] data) {
        return data[7].split(GROUP_SEPERATOR);
    }

    private boolean lineIsNotIgnored(String strLine) {
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
        return new Word(Integer.parseInt(data[1]), data[2], data[3], Integer.parseInt(data[4]), data[5], data[6], groups, data[8], difficulty);
    }

    private int getDifficulty(String difficulty) {
        return NumberUtils.parseNullSafeIntegerAsString(difficulty, Integer.MIN_VALUE);
    }

    private int addWordToWordList(List<Word> wordsList, String[] requestedCategories, String[] wordCategoriesList, Word word, int nr) {
        if (requestedCategories != null) {
            for (String requestedCategory : requestedCategories) {
                for (String wordCategory : wordCategoriesList) {
                    if (wordCategory.equals(requestedCategory)) {
                        wordsList.add(word);
                        nr++;
                    }
                }
            }
        } else {
            wordsList.add(word);
            nr++;
        }
        return nr;
    }

}
