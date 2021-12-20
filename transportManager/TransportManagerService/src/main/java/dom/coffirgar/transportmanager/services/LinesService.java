package dom.coffirgar.transportmanager.services;

import dom.coffirgar.transportmanager.domain.tube.lines.Line;
import dom.coffirgar.transportmanager.domain.tube.lines.Lines;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Service
public class LinesService {

    public List<String> getAllTubeLinesName() {
        return Lines.getLines().stream().map(Line::name).collect(toList());
    }
}
