package dms.pastor.spring.examples;

import lombok.extern.slf4j.Slf4j;

//It is a useful technique to do reduce garbage that need to be collected.
@Slf4j
public class GuardedLoggingStatements {

/*
    public void badExample(){
        logger.info("Binding JobFactory: " + jobFactory.getJobName());
    }

    public void goodExample(){
        if (logger.isInfoEnabled()) {
            logger.info("Binding JobFactory: " + jobFactory.getJobName());
        }
    }
 */
}
