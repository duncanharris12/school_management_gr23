package za.ac.cput.factory.details;

import za.ac.cput.domain.details.Name;
import za.ac.cput.util.StringHelper;

public class NameFactory {

    public static Name buildName (String firstName,String middleName,String lastName) {
        StringHelper.checkStringParam("firstName", firstName);
        StringHelper.setEmptyIfNull(middleName);
        StringHelper.checkStringParam("lastName", lastName);

        return new Name.Builder().FirstName(firstName).MiddleName(middleName)
                .LastName(lastName).build();
    }
}
