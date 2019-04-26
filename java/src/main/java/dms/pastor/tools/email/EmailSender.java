package dms.pastor.tools.email;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

import static dms.pastor.utils.randoms.PersonalDataGenerator.generateEmail;
import static dms.pastor.utils.randoms.PersonalDataGenerator.generateName;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateRandomParagraph;
import static dms.pastor.utils.randoms.RandomDataGenerator.generateString;
import static org.simplejavamail.mailer.config.TransportStrategy.SMTP;

// Used to send test email in various project
public class EmailSender {
    private static String DUMMY_PERSON = generateName();
    private static String DUMMY_EMAIL = generateEmail();
    private static String SMTP_HOST = "localhost";
    private static int SMTP_PORT = 48888;

    public static void main(String[] args) {
        Email email = EmailBuilder.startingBlank()
            .from(DUMMY_PERSON, DUMMY_EMAIL)
            .to(DUMMY_PERSON, DUMMY_EMAIL)
            .withSubject(generateString(8, 24))
            .withPlainText(generateRandomParagraph())
            .buildEmail();

        Mailer mailer = MailerBuilder
            .withSMTPServer(SMTP_HOST, SMTP_PORT)
            .withTransportStrategy(SMTP)
            .withSessionTimeout(10 * 1000)
            .clearEmailAddressCriteria() // turns off email validation
            .withDebugLogging(true)
            .buildMailer();

        mailer.sendMail(email);
    }
}
