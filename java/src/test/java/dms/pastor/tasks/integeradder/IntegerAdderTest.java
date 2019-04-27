package dms.pastor.tasks.integeradder;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static dms.pastor.TestConfig.BASE_PATH;
import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class IntegerAdderTest {

    private static final String PATH = BASE_PATH + "adder" + separator;
    private static final String DEMO_FILE_1 = PATH + "test1.txt";
    private static final String DEMO_FILE_2 = PATH + "test2.txt";
    private static final String DEMO_FILE_3 = PATH + "test3.txt";
    private static final String DEMO_FILE_4 = PATH + "test4.txt";

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private IntegerAdder adder;

    @Before
    public void setUp() {
        adder = new IntegerAdder();
    }

    @Test
    public void testAdd() throws Exception {
        final int result = adder.add(DEMO_FILE_1);
        assertThat(result).isEqualTo(36);
    }

    @Test
    public void testCalculateTotalSum() throws Exception {
        String[] paths = new String[]{DEMO_FILE_1};
        int sum = adder.calculateTotalSum(paths);
        assertThat(sum).isEqualTo(36);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionTest() throws Exception {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("You need provide arguments that are numbers to add");

        // when
        adder.calculateTotalSum(null);
    }

    @Test
    public void basicTest() throws IOException {
        String[] paths = new String[]{DEMO_FILE_1, DEMO_FILE_2, DEMO_FILE_3};
        int sum = adder.calculateTotalSum(paths);
        assertThat(sum).isEqualTo(47);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsExceptionForNullInsteadOfPath() throws IOException {
        adder.add(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsExceptionForInvalidPath() throws IOException {
        adder.add("FakePath");
    }

    /*
    java.lang.AssertionError:
Expected: (an instance of java.lang.IllegalArgumentException and exception with message a string containing "Out od range")
     but: exception with message a string containing "Out od range" message was "For input string: "2147483649""
Stacktrace was: java.lang.NumberFormatException: For input string: "2147483649"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.base/java.lang.Integer.parseInt(Integer.java:656)
	at java.base/java.lang.Integer.valueOf(Integer.java:983)
	at dms.pastor.tasks.integeradder.IntegerAdder.loadIntegers(IntegerAdder.java:40)
	at dms.pastor.tasks.integeradder.IntegerAdder.add(IntegerAdder.java:30)
	at dms.pastor.tasks.integeradder.IntegerAdderTest.addTooBigNumbersShouldThrowException(IntegerAdderTest.java:86)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
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
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:115)
	at org.junit.vintage.engine.execution.RunnerExecutor.execute(RunnerExecutor.java:40)
     */
    @Ignore
    @Test
    public void addTooBigNumbersShouldThrowException() throws IOException {
        // expect
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Out od range");

        // when
        adder.add(DEMO_FILE_4);
    }
    //TODO test for too large int and negative
}
