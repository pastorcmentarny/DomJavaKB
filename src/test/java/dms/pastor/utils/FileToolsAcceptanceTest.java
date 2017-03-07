package dms.pastor.utils;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static dms.pastor.TestConfig.BASE_PATH;
import static dms.pastor.utils.FileTools.saveListToFile;
import static dms.pastor.utils.RandomDataGenerator.generateString;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 16/11/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class FileToolsAcceptanceTest {


    private static final int MAX_STRING_LENGTH = 20;
    private static final String FILE_PATH = BASE_PATH + "savesListToFile.txt";
    private static final Path path = Paths.get(FILE_PATH);

    /* //TODO FIX IT
    java.nio.file.AccessDeniedException: D:\Dropbox\dsProjects\DomJavaKB\src\main\resources\savesListToFile.txt

        at sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:83)
        at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:97)
        at sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:102)
        at sun.nio.fs.WindowsFileSystemProvider.implDelete(WindowsFileSystemProvider.java:269)
        at sun.nio.fs.AbstractFileSystemProvider.deleteIfExists(AbstractFileSystemProvider.java:108)
        at java.nio.file.Files.deleteIfExists(Files.java:1165)
        at dms.pastor.utils.FileToolsAcceptanceTest.setUp(FileToolsAcceptanceTest.java:33)
        at sun.reflect.GeneratedMethodAccessor405.invoke(Unknown Source)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:497)
        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
        at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:24)
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
    @Before //TODO FIX IT
    public void setUp() throws Exception {
        Files.deleteIfExists(path); //TODO FIX IT AS IT IS FLAKY!

    }

    @Test //TODO FIX IT
    public void savesStringListToFile() throws Exception {
        // given
        final ArrayList<String> stringArrayList = new ArrayList<>();
        final String text1 = generateString(MAX_STRING_LENGTH);
        final String text2 = generateString(MAX_STRING_LENGTH);
        final String text3 = generateString(MAX_STRING_LENGTH);

        stringArrayList.add(text1);
        stringArrayList.add(text2);
        stringArrayList.add(text3);

        // when
        saveListToFile(stringArrayList, FILE_PATH);

        // then
        assertThat(Files.exists(path)).isTrue();
        Files.lines(path).forEach(System.out::println);
        assertThat(Files.lines(path).count()).isEqualTo(stringArrayList.size());
    }

}