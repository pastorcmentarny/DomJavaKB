package dms.pastor.spring.examples.json;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Author Dominik Symonowicz
 * Created 10/03/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
@RunWith(SpringRunner.class)
@JsonTest
public class JsonTestExample {

    @Autowired
    private JacksonTester<JsonObject> json; //it is used for conversion

    @Test
    public void shouldSerializeJson() throws Exception {
        // given
        final String name = "name";
        JsonObject jsonObject = new JsonObject(name, 1, true);
        final String jsonKeyName = "@.name";

        // when
        final JsonContent<JsonObject> jsonObjectJsonContent = json.write(jsonObject);

        // then
        assertThat(json.write(jsonObject)).isEqualToJson("expected.json");
        assertThat(jsonObjectJsonContent).hasJsonPathStringValue(jsonKeyName);
        assertThat(jsonObjectJsonContent).extractingJsonPathStringValue(jsonKeyName).isEqualTo(name);
    }

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
