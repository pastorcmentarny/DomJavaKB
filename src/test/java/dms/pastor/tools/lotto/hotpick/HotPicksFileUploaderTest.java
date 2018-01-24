package dms.pastor.tools.lotto.hotpick;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.List;
import java.util.Random;

import static dms.pastor.tools.lotto.LottoConstants.HOT_PICK_BALL_MAXIMUM_VALUE;
import static dms.pastor.tools.lotto.LottoFilePathValidatorTest.generateFile;
import static dms.pastor.utils.StringUtils.EMPTY_STRING;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class HotPicksFileUploaderTest {

    private static final String USER_DIRECTORY = "user.dir";
    private static final int DRAW_NUMBER = 2164;
    private static final String MACHINE_NAME = "Merlin";
    private static final String EMPTY_CSV_FILE = System.getProperty(USER_DIRECTORY) + "\\src\\main\\resources\\lotto.csv";
    private static final String EMPTY_TEXT_FILE = System.getProperty(USER_DIRECTORY) + "lotto.txt";
    private static final String CSV_SEPARATOR = ",";
    private static final int MAX = 32;
    private final Random random = new Random();
    private final HotPicksFileUploader hotPicksFileUploader = new HotPicksFileUploader();
    private final File csvFile = new File(EMPTY_CSV_FILE);
    private final File textFile = new File(EMPTY_TEXT_FILE);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {

        deleteCSVFileIfExists();
        assertThat(csvFile.createNewFile()).isTrue();

        deleteTextFileIfExists();
        assertThat(textFile.createNewFile()).isTrue();

    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @After
    public void tearDown() throws Exception {
        new File(EMPTY_CSV_FILE).delete();
        new File(EMPTY_TEXT_FILE).delete();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.loadDrawHistoryFile(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathToFileIsEmpty() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.loadDrawHistoryFile(EMPTY_STRING);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathToFileIsInvalid() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.loadDrawHistoryFile(generateString(128));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenPathToFileIsDirectory() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.loadDrawHistoryFile(System.getProperty(USER_DIRECTORY));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileTypeIsNull() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Path cannot be null.");

        // given
        generateFile(null);

        // when
        hotPicksFileUploader.loadDrawHistoryFile(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFileTypeIsNotACsvFile() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("It must be a csv file.");

        // when
        hotPicksFileUploader.loadDrawHistoryFile(EMPTY_TEXT_FILE);
    }

    @Test
    public void shouldReturnEmptyListIfLineIsNull() throws Exception {
        // given
        String[] lines = new String[]{null};
        generateFile(EMPTY_CSV_FILE, lines);

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList).isNotNull();
        assertThat(hotPickDrawList.size()).isEqualTo(0);

    }

    /*
    2017-02-23 18:48:37 ERROR FileTools:117 - Unable to save source list to file: D:\Dropbox\dsProjects\DomJavaKBlotto.csv

java.lang.IllegalArgumentException: Path is invalid or is not a file

	at dms.pastor.tools.lotto.hotpick.HotPicksFileUploader.validateFilePath(HotPicksFileUploader.java:129)
	at dms.pastor.tools.lotto.hotpick.HotPicksFileUploader.loadDrawHistoryFile(HotPicksFileUploader.java:35)
	at dms.pastor.tools.lotto.hotpick.HotPicksFileUploaderTest.shouldReturnEmptyListIfLineIsEmpty(HotPicksFileUploaderTest.java:115)
	at sun.reflect.GeneratedMethodAccessor361.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.rules.ExpectedException$ExpectedExceptionStatement.evaluate(ExpectedException.java:239)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runners.Suite.runChild(Suite.java:128)
	at org.junit.runners.Suite.runChild(Suite.java:27)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:58)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
     */
    @Test
    public void shouldReturnEmptyListIfLineIsEmpty() throws Exception {
        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList).isNotNull();
        assertThat(hotPickDrawList.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnEmptyListIfRowHasNotTenElements() throws Exception {
        // given
        String[] lines = new String[]{"1,2,3,4,5,6,7,8,9"};
        generateFile(EMPTY_CSV_FILE, lines);

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList).isNotNull();
        assertThat(hotPickDrawList.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnEmptyListIfRowContainsNotValidBall() throws Exception {

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList).isNotNull();
        assertThat(hotPickDrawList.size()).isEqualTo(0);
    }

    @Test
    public void shouldLoadDrawHistoryFileForHotPicks() throws Exception {
        // given
        String date = "17-Sep-2016";
        final int ball1 = 25;
        final int ball2 = 54;
        final int ball3 = 52;
        final int ball4 = 10;
        final int ball5 = 14;
        final int ball6 = 29;
        final int ballSet = 3;
        final String machine = MACHINE_NAME;
        final int drawNumber = DRAW_NUMBER;
        String[] lines = new String[]{generateDrawLineAsString(date, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, machine, drawNumber)};
        deleteCSVFileIfExists();
        generateFile(EMPTY_CSV_FILE, lines);

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList).isNotNull();
        assertThat(hotPickDrawList.size()).isEqualTo(1);
        final HotPickDraw hotPickDraw = hotPickDrawList.get(0);
        assertHotPickDraw(hotPickDraw, date, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, machine, drawNumber);
    }

    @Test
    public void shouldHave1HotPickDrawWithoutInvalidLines() throws Exception {
        // given
        String date = "17-Sep-2016";
        final int ball1 = 25;
        final int ball2 = 54;
        final int ball3 = 52;
        final int ball4 = 10;
        final int ball5 = 14;
        final int ball6 = 29;
        final int ballSet = 3;
        final String machine = MACHINE_NAME;
        final int drawNumber = DRAW_NUMBER;
        String[] lines = new String[]{generateDrawLineAsString(date, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, machine, drawNumber),
                generateString(MAX),
                generateString(MAX)};
        deleteCSVFileIfExists();
        generateFile(EMPTY_CSV_FILE, lines);

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList).isNotNull();
        assertThat(hotPickDrawList.size()).isEqualTo(1);
        final HotPickDraw hotPickDraw = hotPickDrawList.get(0);
        assertHotPickDraw(hotPickDraw, date, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, machine, drawNumber);
    }

    @Test
    public void shouldHave3HotPickDraws() throws Exception {
        // given
        String date = "17-Sep-2016";
        final int lineOneBallOne = getRandomBallNumber();
        final int lineOneBallTwo = getRandomBallNumber();
        final int lineOneBallThree = getRandomBallNumber();
        final int lineOneBallFour = getRandomBallNumber();
        final int lineOneBallFive = getRandomBallNumber();
        final int lineOneBallSix = getRandomBallNumber();
        final int lineTwoBallOne = getRandomBallNumber();
        final int lineTwoBallTwo = getRandomBallNumber();
        final int lineTwoBallThree = getRandomBallNumber();
        final int lineTwoBallFour = getRandomBallNumber();
        final int lineTwoBallFive = getRandomBallNumber();
        final int lineTwoBallSix = getRandomBallNumber();
        final int lineThreeBallOne = getRandomBallNumber();
        final int lineThreeBallTwo = getRandomBallNumber();
        final int lineThreeBallThree = getRandomBallNumber();
        final int lineThreeBallFour = getRandomBallNumber();
        final int lineThreeBallFive = getRandomBallNumber();
        final int lineThreeBallSix = getRandomBallNumber();

        final int ballSet = 3;
        final int drawNumber1 = 2161;
        final int drawNumber2 = 2162;
        final int drawNumber3 = 2163;

        String[] lines = new String[]{generateDrawLineAsString(date, lineOneBallOne, lineOneBallTwo, lineOneBallThree, lineOneBallFour, lineOneBallFive, lineOneBallSix, ballSet, MACHINE_NAME, drawNumber1),
                generateDrawLineAsString(date, lineTwoBallOne, lineTwoBallTwo, lineTwoBallThree, lineTwoBallFour, lineTwoBallFive, lineTwoBallSix, ballSet, MACHINE_NAME, drawNumber2),
                generateDrawLineAsString(date, lineThreeBallOne, lineThreeBallTwo, lineThreeBallThree, lineThreeBallFour, lineThreeBallFive, lineThreeBallSix, ballSet, MACHINE_NAME, drawNumber3)};
        generateFile(EMPTY_CSV_FILE, lines);

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList.size()).isEqualTo(3);
        assertHotPickDraw(hotPickDrawList.get(0), date, lineOneBallOne, lineOneBallTwo, lineOneBallThree, lineOneBallFour, lineOneBallFive, lineOneBallSix, ballSet, MACHINE_NAME, drawNumber1);
        assertHotPickDraw(hotPickDrawList.get(1), date, lineTwoBallOne, lineTwoBallTwo, lineTwoBallThree, lineTwoBallFour, lineTwoBallFive, lineTwoBallSix, ballSet, MACHINE_NAME, drawNumber2);
        assertHotPickDraw(hotPickDrawList.get(2), date, lineThreeBallOne, lineThreeBallTwo, lineThreeBallThree, lineThreeBallFour, lineThreeBallFive, lineThreeBallSix, ballSet, MACHINE_NAME, drawNumber3);
    }

    @Test
    public void shouldReturnEmptyListIfLineContainsDateThatIsNullTest() throws Exception {

        // given
        final int ball1 = 25;
        final int ball2 = 54;
        final int ball3 = 52;
        final int ball4 = 10;
        final int ball5 = 14;
        final int ball6 = 29;
        final int ballSet = 3;
        String[] lines = new String[]{generateDrawLineAsString(null, ball1, ball2, ball3, ball4, ball5, ball6, ballSet, MACHINE_NAME, DRAW_NUMBER)};
        generateFile(EMPTY_CSV_FILE, lines);

        // when
        final List<HotPickDraw> hotPickDrawList = hotPicksFileUploader.loadDrawHistoryFile(EMPTY_CSV_FILE).getDrawList();

        // then
        assertThat(hotPickDrawList).isEmpty();
    }

    @Test
    public void shouldNotValidateWhenDateIsNull() throws Exception {
        // given
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.parseLocalDate(null);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenWhenParsingDateIsEmpty() throws Exception {
        // given
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.parseLocalDate(EMPTY_STRING);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenWhenParsingDateFormatIsWithoutDelimiter() throws Exception {
        // given
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.parseLocalDate("01JAN2015");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenParsingDateFormatHasTooManyDelimiters() throws Exception {
        // given
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.parseLocalDate("2-2-1-9");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenYearIsNotValid() throws Exception {
        // given
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.parseLocalDate("01-JAN-Year");

    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenMonthIsNotValid() throws Exception {
        // given
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.parseLocalDate("01-Ufo-2015");
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenDayIsNotValid() throws Exception {
        // given
        exception.expect(IllegalArgumentException.class);

        // when
        hotPicksFileUploader.parseLocalDate("331-Jan-2015");
    }

    @SuppressWarnings("MethodWithTooManyParameters")
    private void assertHotPickDraw(HotPickDraw hotPickDraw, String date, int ball1, int ball2, int ball3, int ball4, int ball5, int ball6, int ballSet, String machine, int drawNumber) {
        assertThat(hotPickDraw).isNotNull();
        System.out.println(date); //TODO date
        assertThat(ball1).isEqualTo(hotPickDraw.getBall1());
        assertThat(ball2).isEqualTo(hotPickDraw.getBall2());
        assertThat(ball3).isEqualTo(hotPickDraw.getBall3());
        assertThat(ball4).isEqualTo(hotPickDraw.getBall4());
        assertThat(ball5).isEqualTo(hotPickDraw.getBall5());
        assertThat(ball6).isEqualTo(hotPickDraw.getBall6());
        assertThat(ballSet).isEqualTo(hotPickDraw.getBallSet());
        assertThat(machine).isEqualTo(hotPickDraw.getMachine());
        assertThat(drawNumber).isEqualTo(hotPickDraw.getDrawNumber());
    }

    @SuppressWarnings("MethodWithTooManyParameters")
    private String generateDrawLineAsString(String date, int ball1, int ball2, int ball3, int ball4, int ball5, int ball6, int ballSet, String machine, int drawNumber) {
        return date + CSV_SEPARATOR + ball1 + CSV_SEPARATOR + ball2 + CSV_SEPARATOR + ball3 + CSV_SEPARATOR + ball4 + CSV_SEPARATOR + ball5 + CSV_SEPARATOR + ball6 + CSV_SEPARATOR + ballSet + CSV_SEPARATOR + machine + CSV_SEPARATOR + drawNumber;
    }

    private int getRandomBallNumber() {
        return random.nextInt(HOT_PICK_BALL_MAXIMUM_VALUE) + 1;
    }

    private void deleteTextFileIfExists() {
        if (textFile.exists()) {
            assertThat(textFile.delete()).isTrue();
        }
    }

    private void deleteCSVFileIfExists() {

        if (csvFile.exists()) {
            assertThat(csvFile.delete());
        }
    }
}