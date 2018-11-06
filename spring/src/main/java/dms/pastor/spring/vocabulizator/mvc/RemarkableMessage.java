package dms.pastor.spring.vocabulizator.mvc;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static dms.pastor.spring.utils.RandomDataGenerator.generateString;


/**
 * Author Dominik Symonowicz
 * Created 09/04/2016
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 */
public class RemarkableMessage {
    private final LocalDateTime created;
    private final UUID id;
    private final String title;
    private final String message;
    private final boolean important;

    public RemarkableMessage(LocalDateTime created, UUID id, String title, String message, boolean important) {
        this.created = created;
        this.id = id;
        this.title = title;
        this.message = message;
        this.important = important;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public boolean isImportant() {
        return important;
    }

    public static RemarkableMessage generateRandomMessage() {
        return new RemarkableMessage(LocalDateTime.now(), UUID.randomUUID(),generateString(10),generateString(128),new Random().nextBoolean());
    }
}
