package dms.pastor.snippets.error;

/**
 * Author Dominik Symonowicz
 * Created 24/12/2017
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class ErrorResponse {
    {
        "errorCode":12345,
            "message":
        "A human readable, useful description of what went wrong.  Ideally with hints about what might fix it.",
                "moreInfo":"http://wiki.orbitbenefits.capita/PROJ/api/errors/12345",
            "errors": [
        {
            "field":"name",
                "code":10,
                "message":"human readable description of the validation error."
        }
  ]
    }

}
