package dms.pastor.utils;

import dms.pastor.utils.transformers.ToUncheckedExceptionTransformer;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Author Dominik Symonowicz
 * Created 03/01/2019
 * WWW:	https://dominiksymonowicz.com/
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class ToUncheckedExceptionTransformerTest {


    @Test
    public void shouldThrowRuntimeExceptionWhenCheckedExceptionIsThrown() {
        // given
        List<String> urlsToCrawl = Arrays.asList("https://dominiksymonowicz.com", "whoops");

        // when
        assertThrows(RuntimeException.class, () -> urlsToCrawl.stream()
                .map(ToUncheckedExceptionTransformer.transformToUncheckedException(FileWriter::new))
                .forEach(fileWriter -> System.out.println(fileWriter.toString())));
    }

}