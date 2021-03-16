package dms.pastor.spring.examples.json;

import dms.pastor.spring.examples.rest.CuteDomainObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static dms.pastor.spring.DomUtils.generateString;
import static dms.pastor.spring.examples.ExamplesURL.JSON;
import static dms.pastor.spring.examples.json.JsonObjectBuilder.jsonObjectBuilder;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 * <p>
 * This is an example how to use RestController and Json
 */
@Slf4j
@RestController
public class JsonExampleController {

    @GetMapping(JSON + "/example1")
    public JsonObject returnJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.setName("Dom App");
        jsonObject.setVersion(1);
        jsonObject.setOk(true);
        jsonObject.setIgnoredField(generateString());
        return jsonObject;
    }

    @GetMapping(JSON + "/example2")
    public JsonExampleWrapper returnJsonList() {
        JsonObject jsonObject = jsonObjectBuilder().build();
        JsonObject jsonObject2 = jsonObjectBuilder().build();
        JsonObject jsonObject3 = jsonObjectBuilder().build();

        List<JsonObject> jsonObjectList = new ArrayList<>(Arrays.asList(jsonObject, jsonObject2, jsonObject3));

        return new JsonExampleWrapper("Example", jsonObjectList);
    }


    @GetMapping("/json")
    public CuteDomainObject getCuteDomainObjectAsJson() {
        CuteDomainObject cuteDomainObject = new CuteDomainObject("Name", new Random().nextInt(32));
        log.info("Getting Cute Domain Object with data: " + cuteDomainObject.toString());
        return cuteDomainObject;
    }

    @GetMapping(value = "/xml", produces = {"application/xml", "text/xml"})
    public CuteDomainObject getCuteDomainObjectAsXml() {
        CuteDomainObject cuteDomainObject = new CuteDomainObject("Name", new Random().nextInt(32));
        log.info("Getting Cute Domain Object with data: " + cuteDomainObject.toString());
        return cuteDomainObject;
    }

}
