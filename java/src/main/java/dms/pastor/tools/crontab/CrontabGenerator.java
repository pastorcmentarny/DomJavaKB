package dms.pastor.tools.crontab;

import dms.pastor.domain.exception.SomethingWentWrongException;
import dms.pastor.utils.StringUtils;

public class CrontabGenerator {

    public static String toCrontab(String timeAsText) {
        String result = "";
        if (StringUtils.isStringBlank(timeAsText) | StringUtils.notStartWith("Run",timeAsText)) {
            throw new SomethingWentWrongException("Invalid input %s".formatted(timeAsText));
        }

        String input = timeAsText.toLowerCase()
                .replace("Run".toLowerCase(),"")
                .trim();

        if(input.equalsIgnoreCase("every minute of every day")){
            return "* * * * *";
        }

        //"^every.*minute$"

        return null;
    }

    public static String fromCrontab(String crontabText) {
        if (StringUtils.isStringBlank(crontabText)) {
            throw new SomethingWentWrongException("Invalid input %s".formatted(crontabText));
        }
        return null;
    }
}
