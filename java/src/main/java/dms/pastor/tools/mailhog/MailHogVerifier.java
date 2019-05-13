package dms.pastor.tools.mailhog;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.ArrayList;
import java.util.List;

public class MailHogVerifier {

    public static final String API_PORT_KEY = "API_PORT";
    public static final String DEFAULT_API_PORT_VALUE = "8025";
    private Response response;

    private MailHogVerifier() {
        this.response = getMessages();
    }

    private static Response getMessages() {
        RestAssured.baseURI = System.getProperty("API_URL", "http://localhost");
        RestAssured.port = Integer.valueOf(System.getProperty(API_PORT_KEY, DEFAULT_API_PORT_VALUE));
        return RestAssured.get("/api/v2/messages");
    }

    private static Response deleteAllMessages() {
        RestAssured.baseURI = System.getProperty("API_URL", "http://localhost");
        RestAssured.port = Integer.valueOf(System.getProperty(API_PORT_KEY, DEFAULT_API_PORT_VALUE));
        return RestAssured.delete("/api/v1/messages");
    }

    public Integer getTotalEmails() {
        return response.getBody().path("total");
        //getMessages().then().body("total", equalTo(totalEmails));
    }

    public Message getFirstMessage() {
        ResponseBody responseBody = getMessages().getBody();
        return new Message(responseBody.path("items[0].Content.Headers.To").toString(),
            responseBody.path("items[0].Content.Headers.Subject").toString(),
            responseBody.path("items[0].Content.Body").toString());

    }

    public Message getLastMessage() {
        ResponseBody responseBody = getMessages().getBody();
        int counter = getTotalEmails() < 1 ? 0 : getTotalEmails() - 1;
        return new Message(responseBody.path("items[" + counter + "].Content.Headers.To").toString(),
            responseBody.path("items[" + counter + "].Content.Headers.Subject").toString(),
            responseBody.path("items[" + counter + "].Content.Body").toString());

    }

    public List<Message> getAllMessages() {
        var messages = new ArrayList<Message>();
        ResponseBody responseBody = getMessages().getBody();

        for (int i = 0; i < getTotalEmails(); i++) {
            final var message = new Message(responseBody.path("items[" + i + "].Content.Headers.To").toString(),
                responseBody.path("items[" + i + "].Content.Headers.Subject").toString(),
                responseBody.path("items[" + i + "].Content.Body").toString());
            messages.add(message);
        }
        return messages;
    }


    public static void main(String[] args) {
        final var verifier = new MailHogVerifier();

        System.out.println(verifier.getTotalEmails() == 3);
        verifier.getAllMessages().forEach(System.out::println);
        System.out.println("first: " + verifier.getFirstMessage().toString());
        System.out.println("last: " + verifier.getLastMessage().toString());

        MailHogVerifier.deleteAllMessages();
        System.out.println(verifier.getTotalEmails() == 0);
        System.out.println(verifier.getTotalEmails());
    }
}
