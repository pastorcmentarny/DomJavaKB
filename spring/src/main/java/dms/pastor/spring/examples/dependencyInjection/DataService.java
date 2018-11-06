package dms.pastor.spring.examples.dependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
@Service
class DataService {

    private DataValidator dataValidator;

    @Autowired
    public DataService(DataValidator dataValidator) {
        this.dataValidator = dataValidator;
    }

    String getData(String text) {
        return dataValidator.validate(text) ? " It is a long string" : "too short";
    }
}
