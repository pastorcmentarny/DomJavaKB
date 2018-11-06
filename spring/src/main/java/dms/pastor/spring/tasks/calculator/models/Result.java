package dms.pastor.spring.tasks.calculator.models;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Result {

    private final long id;
    private final int answer;

    public Result(long id, int answer) {
        this.id = id;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public long getAnswer() {
        return answer;
    }


}
