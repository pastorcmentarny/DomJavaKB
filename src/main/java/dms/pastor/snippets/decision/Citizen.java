package dms.pastor.snippets.decision;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class Citizen {
    private String name;
    private int age;
    private boolean isResident;

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
