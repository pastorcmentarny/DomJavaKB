package dms.pastor.spring.vocabulizator.notes;

import org.springframework.data.annotation.Id;

/**
 * Author Dominik Symonowicz
 * Created 27/10/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
class Note {
    @Id
    private String id;

    private final String title;
    private final String content;
    private final String tags;
    private final String date;

    public Note(String title, String content, String tags, String date) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    public String getDate() {
        return date;
    }

}
