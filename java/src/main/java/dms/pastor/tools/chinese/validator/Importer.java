package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;

/**
 * Author Dominik Symonowicz
 * Created 11/10/2017
* Website: <a href="https://dominiksymonowicz.com/">Home Page</a>
* LinkedIn: <a href="https://www.linkedin.com/in/dominik-symonowicz">LinkedIn</a>
* GitHub: <a href="https://github.com/pastorcmentarny">GitHub</a>
 */
interface Importer<T> {
    Result<T> importDictionary(String source, String[] requestedCategories);
}
