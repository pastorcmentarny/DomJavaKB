package dms.pastor.tools.store;

import org.jasypt.util.text.BasicTextEncryptor;

import static java.lang.String.format;

public class ValueOperations {
    private final StorageManager dataStorage;
    private final BasicTextEncryptor dataTranslator;

    public ValueOperations(StorageManager dataStorage, String verifier) {
        this.dataStorage = dataStorage;
        this.dataTranslator = new BasicTextEncryptor();
        dataTranslator.setPassword(verifier);
    }

    void displayValueFor(String key) {
        System.out.println(dataTranslator.decrypt(dataStorage.get(key).orElse(format("No value found for key: %s", key))));
    }

    void addValueForKey(String key, String value) {
        dataStorage.put(key, dataTranslator.encrypt(value));
    }
}
