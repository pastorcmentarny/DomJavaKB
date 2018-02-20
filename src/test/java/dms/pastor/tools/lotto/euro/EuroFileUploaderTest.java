package dms.pastor.tools.lotto.euro;

import dms.pastor.tools.lotto.hotpick.DrawList;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EuroFileUploaderTest {


    @Test
    @Ignore
    public void uploadShouldLoadDrawsFromFileTest() {
        // given
        final EuroFileUploader euroFileUploader = new EuroFileUploader();
        final String path = null;

        // when
        final DrawList drawList = euroFileUploader.loadDrawHistoryFile(path);

        // then
        assertThat(drawList.getDrawList()).hasSize(10);
    }
}