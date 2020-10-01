package dms.pastor.spring.examples.json;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 10/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@ExtendWith(SpringExtension.class)
@JsonTest
public class JsonTestExample {

    @Autowired
    private JacksonTester<JsonObject> json; //it is used for conversion

    @Test
    public void shouldDeserializeJson() throws Exception {
        // given
        String content = "{\n" +
                "  \"name\" : \"name\",\n" +
                "  \"version\" : 1,\n" +
                "  \"ok\" : true\n" +
                "}";
        // when
        final ObjectContent<JsonObject> jsonContent = json.parse(content);

        // then
        assertThat(jsonContent).isEqualTo(new JsonObject("name", 1, true));

    }
}
