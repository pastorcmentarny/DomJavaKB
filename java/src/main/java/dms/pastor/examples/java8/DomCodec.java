package dms.pastor.examples.java8;

import dms.pastor.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

final class DomCodec {

    private static final String ENCODING = "UTF-8";

    private String data = "text  \n" +
            "  objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);\n" +
            "        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);\n" +
            "        objectMapper.registerModule(new JavaTimeModule());\n" +
            "\n" +
            "\t\t\n" +
            "\t\t@WritingConverter\n" +
            "public class UUIDToStringConverter implements Converter<UUID, String> {\n" +
            "\n" +
            "    @Override\n" +
            "    public String convert(UUID source) {\n" +
            "        return source.toString();\n" +
            "    }\n" +
            "\t\n" +
            "\t\n" +
            "\t    @Override\n" +
            "    public CustomConversions customConversions() {\n" +
            "        return new CustomConversions(newArrayList(\n" +
            "                new StringToUUIDConverter(),\n" +
            "                new UUIDToStringConverter()\n" +
            "        ));\n" +
            "    }\n" +
            "\t\n" +
            "\t    @ExceptionHandler(AccessDeniedException.class)\n" +
            "    @ResponseStatus(FORBIDDEN)\n" +
            "    void accessDenied(final AccessDeniedException accessDeniedException) {\n" +
            "        LOGGER.error(\"Uncaught Exception\", accessDeniedException);\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t\t\n" +
            "    targetCompatibility = JavaVersion.VERSION_1_8\n" +
            "    sourceCompatibility = JavaVersion.VERSION_1_8\n" +
            "\n" +
            "}\n" +
            "\n" +
            "\n" +
            "task singleServiceTests(type: Test, group: 'Test', dependsOn: ['startActiveMqInstances']) {\n" +
            "    systemProperties['broker.url'] = brokerUrl\n" +
            "    systemProperties['orbit.redis.schema'] = redisDbIndex;\n" +
            "\n" +
            "    include '**/*SingleServiceTest.class'\n" +
            "\n" +
            "    jvmArgs += [\"-XX:MaxPermSize=256m\"]\n" +
            "}";

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
