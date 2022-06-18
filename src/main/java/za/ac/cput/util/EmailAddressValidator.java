package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailAddressValidator
{
    public static boolean isValid(String email)
    {
        return EmailValidator.getInstance().isValid(email);
    }

    public static void validator(String paramName, String paramValues)
    {
        if(!isValid(paramValues))
        {
            throw new IllegalArgumentException(String.format("Invalid value for param: %s", paramName));
        }
    }

}
