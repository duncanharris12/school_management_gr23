
package za.ac.cput.factory.details;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.details.Address;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @uthor Chuma Nxazonke
 * Student number: 219181187
 * Date: 13 June 2022
 */

class AddressFactoryTest {


    @Test
    void createAddressFactoryWithSuccess(){
        Address address = AddressFactory.createAddressFactory("FG235","South Point",

                "22","Barack Street",

                8001, null);

        assertAll(
                () -> assertNotNull(address),
                () -> assertNotNull(address.getComplexName())
        );
        System.out.println(address);
    }

    @Test
    void createAddressFactoryWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> AddressFactory.createAddressFactory("255","South Plain","","Comfimvaba",8005, null));
        System.out.println(exception.getMessage());

    }





}