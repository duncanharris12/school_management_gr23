/*
 * Name       : Chante Lee Davids
 * Student num: 220246688
 * Description: Creates name objects
 * */

package za.ac.cput.factory.details;

import za.ac.cput.domain.details.Name;
import za.ac.cput.util.StringHelper;

public class NameFactory {

    public static Name buildName(String firstName,String middleName,String lastName) {
        //First and last name are mandatory attributes
        if(StringHelper.isEmptyOrNull(firstName) || StringHelper.isEmptyOrNull(lastName))
            throw new IllegalArgumentException("First name and last name are required");

        //Middle name is not a mandatory attribute
        // no attribute should be saved as null
        //empty string is acceptable in place of null
        middleName = StringHelper.setEmptyIfNull(middleName);

        return new Name.Builder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
    }
}
