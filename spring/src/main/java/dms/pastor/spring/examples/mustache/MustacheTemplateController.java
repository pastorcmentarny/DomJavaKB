package dms.pastor.spring.examples.mustache;


import dms.pastor.spring.model.BritishTrainsList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MustacheTemplateController {

    @GetMapping(value = "/examples/mustache/")
    public String getTrainsWithMustacheTemplate(Map<String, Object> model) {
        model.put("title", "British Trains List");
        model.put("trainList", BritishTrainsList.getAllBritishTrains());
        return "trains";
    }

}
