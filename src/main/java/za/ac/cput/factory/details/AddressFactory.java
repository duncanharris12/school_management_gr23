//This is a worker class for  Address entity under factory package.
//In this class will implement an entity called Address using a factory pattern.
//This is AddressFactory.java

package za.ac.cput.factory.details;
/**
 * @author Chuma Nxazonke
 * Date: 11 June 2022
 * Student number: 219181187
 */
import za.ac.cput.domain.details.City;
import za.ac.cput.util.StringHelper;
import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.details.City;

public class AddressFactory {

    public static Address createAddressFactory(String unitNumber, String complexName, String streetNumber,String streetName, int postalCode , City city ){

        StringHelper.checkStringParam("streetNumber",streetNumber);
        StringHelper.checkStringParam("streetName",streetName);


        if(StringHelper.isEmptyOrNull(complexName))
            throw new IllegalArgumentException("Complex name is required");

        if (StringHelper.isEmptyOrNull(unitNumber))
            throw new IllegalArgumentException("Unit number is required");



        if (postalCode<999 || postalCode> 9999) {
            throw new IllegalArgumentException("Postal code has to be 4 digits");
        }

        Address address = new Address.Builder().UnitNumber(unitNumber)
                .ComplexName(complexName)
                .StreetNumber(streetNumber)
                .StreetName(streetName)
                .PostalCode(postalCode)
                .City(city)
                .build();

        return address;

    }

}
