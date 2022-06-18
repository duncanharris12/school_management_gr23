package za.ac.cput.factory.details;

/**
 * Name: Onele Tomson
 * Student number: 219483280
 *CountryFactory
 */

import za.ac.cput.domain.details.Country;
import za.ac.cput.util.StringHelper;


public class CountryFactory {
    public static Country createCountry(String countryName, String countryId) {

        if (StringHelper.isEmptyOrNull(countryId) || StringHelper.isEmptyOrNull(countryId)) {
            throw new IllegalArgumentException("Id And/Or Name is required");

        }

        return new Country.Builder()
                .id(countryId)
                .name(countryName)
                .build();

    }

    public static Country builder(String countryId, String countryName) {

        StringHelper.checkStringParam("1" , countryId);
        StringHelper.checkStringParam("2" , countryName);
        return new Country.Builder().id(countryId).name(countryName).build();
    }
}

