package dms.pastor.tools.chinese.validator;

import dms.pastor.domain.Result;

/**
 * Author Dominik Symonowicz
 * Created 11/10/2017
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
interface Importer<T> {
    Result<T> importDictionary(String source, String[] requestedCategories);
}
