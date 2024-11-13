package dms.pastor.snippets.decision;

/**
 * Author Dominik Symonowicz
 * WWW:	<a href="https://dominiksymonowicz.com/">HOME PAGE</a>
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * GitHub:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
class Citizen {
    private final String name;
    private final int age;
    private final boolean isResident;

    public Citizen(String name, int age, boolean isResident) {
        this.name = name;
        this.age = age;
        this.isResident = isResident;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isResident() {
        return isResident;
    }
}
