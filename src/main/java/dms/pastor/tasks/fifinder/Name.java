package dms.pastor.tasks.fifinder;

/**
 * Author Dominik Symonowicz
 * Created 31/10/2016
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Name {

    private final String first;
    private final String middles;
    private final String last;

    public Name(String first, String middles, String last) {
        this.first = first;
        this.middles = middles;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getMiddles() {
        return middles;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "Name{" +
                "first='" + first + '\'' +
                ", middles='" + middles + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
