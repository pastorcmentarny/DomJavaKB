package dms.pastor.spring.examples.healthcheck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import static dms.pastor.spring.DomUtils.*;

//TODO fix it
@Slf4j
@Component
@Endpoint(id = "server-info")
public class ServerInformationActuatorEndpoint {


    private static final String JAVA_VERSION_PROPERTY = "java.version";
    private static final String OS_NAME_PROPERTY = "os.name";


    private String getMacAddress() throws SocketException, UnknownHostException {
        NetworkInterface network = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
        byte[] mac = network.getHardwareAddress();
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < mac.length; index++) {
            stringBuilder.append(String.format("%02X%s", mac[index], (index < mac.length - 1) ? DASH : EMPTY_STRING));
        }
        return stringBuilder.toString();
    }

    private int getJavaVersion() {
        String version = System.getProperty(JAVA_VERSION_PROPERTY);
        if (version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(".");
            if (dot != NO_VALUE) {
                version = version.substring(0, dot);
            }
        }
        return Integer.parseInt(version);
    }
}