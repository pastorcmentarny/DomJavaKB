package dms.pastor.examples.java8;

import dms.pastor.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

final class DomCodec {

    private static final String ENCODING = "UTF-8";

    private String data = """
            text \s
              objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
                    objectMapper.registerModule(new JavaTimeModule());

            \t\t
            \t\t@WritingConverter
            public class UUIDToStringConverter implements Converter<UUID, String> {

                @Override
                public String convert(UUID source) {
                    return source.toString();
                }
            \t
            \t
            \t    @Override
                public CustomConversions customConversions() {
                    return new CustomConversions(newArrayList(
                            new StringToUUIDConverter(),
                            new UUIDToStringConverter()
                    ));
                }
            \t
            \t    @ExceptionHandler(AccessDeniedException.class)
                @ResponseStatus(FORBIDDEN)
                void accessDenied(final AccessDeniedException accessDeniedException) {
                    LOGGER.error("Uncaught Exception", accessDeniedException);
            \t\t
            \t\t
            \t\t
                targetCompatibility = JavaVersion.VERSION_1_8
                sourceCompatibility = JavaVersion.VERSION_1_8

            }


            task singleServiceTests(type: Test, group: 'Test', dependsOn: ['startActiveMqInstances']) {
                systemProperties['broker.url'] = brokerUrl
                systemProperties['orbit.redis.schema'] = redisDbIndex;

                include '**/*SingleServiceTest.class'

                jvmArgs += ["-XX:MaxPermSize=256m"]
            }""";

    public static void main(String[] args) throws UnsupportedEncodingException {

        DomCodec domCodec = new DomCodec();
        domCodec.encode();
        domCodec.displayMessageAfterProcessing();
        domCodec.decode();
        domCodec.displayMessageAfterProcessing();
    }

    private void displayMessageAfterProcessing() {
        System.out.println("Encoded data:\n" + data);
    }

    private void encode() throws UnsupportedEncodingException {
        encodeInBase64();
        data = StringUtils.swapCaseLettersInString(data);
        data = reverse();
    }

    private void decode() throws UnsupportedEncodingException {
        data = reverse();
        data = StringUtils.swapCaseLettersInString(data);
        decodeInBase64();
    }


    private void encodeInBase64() throws UnsupportedEncodingException {
        data = new String(Base64.getEncoder().encode(data.getBytes(ENCODING)));
    }

    private void decodeInBase64() throws UnsupportedEncodingException {
        data = new String(Base64.getDecoder().decode(data.getBytes(ENCODING)));
    }

    private String reverse() {
        return new StringBuilder(data).reverse().toString();
    }

}
