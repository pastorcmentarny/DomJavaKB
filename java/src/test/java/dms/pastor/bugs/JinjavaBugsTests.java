package dms.pastor.bugs;

import com.google.common.collect.Lists;
import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.interpret.Context;
import com.hubspot.jinjava.interpret.FatalTemplateErrorsException;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class JinjavaBugsTests {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test //test if bug still exists
    public void floatNumberBug() {
        // expect
        exception.expect(FatalTemplateErrorsException.class);
        // given
        Jinjava jinjava = new Jinjava();

        // when
        final String renderedResult = jinjava.render("&pound; {{ '%,f'|format(10000) }}", new HashMap<>());
        // then
        assertThat(renderedResult).isEqualTo("&pound; 10,000");
    }

    @Test //test if bug still exists
    public void namespaceNotImplementedYet() {
        // expect
        exception.expect(FatalTemplateErrorsException.class);

        // given
        Jinjava jinjava = new Jinjava();
        JinjavaInterpreter interpreter = jinjava.newInterpreter();
        Context context = interpreter.getContext();
        String template = "{% set ns = namespace(found=false) %}" +
            "{% for item in items %}" +
            "{% if item=='B' %}" +
            "{% set ns.found=true %}" +
            "{% endif %}" +
            "{% endfor %}" +
            "Found item having something: {{ ns.found }}";

        context.put("items", Lists.newArrayList("A", "B"));

        // when
        String rendered = jinjava.render(template, context);

        // debug
        System.out.println(rendered);

        // then
        assertThat(rendered).isEqualTo("Found item having something: true");

    }


}
