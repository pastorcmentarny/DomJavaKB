package dms.pastor.spring.examples.retry;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetryService {

    public class ConfigureNetworkService {
        @Autowired
        private RetryTemplate retryTemplate;
        int counter =0;
        private void configureNetworkSystem(){
        retryTemplate.execute(
                context -> {
                    verifyNwConfiguration();
                    return true;
                });
    }
        private void verifyNwConfiguration(){
        counter++;
        log.info("N/W configuration Service Failed "+ counter);
        throw new RuntimeException();
    }

    }
}
