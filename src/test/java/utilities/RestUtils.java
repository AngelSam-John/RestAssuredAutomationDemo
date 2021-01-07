package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

    public static String employeeName()
    {
        String generatedString=RandomStringUtils.randomAlphabetic(1);
        return ("John"+generatedString);
    }

    public static String employeeSalary()
    {
        String generatedString=RandomStringUtils.randomNumeric(5);
        return (generatedString);
    }

    public static String employeeAge()
    {
        String generatedString=RandomStringUtils.randomNumeric(2);
        return (generatedString);
    }
}
