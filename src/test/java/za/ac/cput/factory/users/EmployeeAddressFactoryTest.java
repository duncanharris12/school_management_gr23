/*  Davin Carstens 220021333
 */
package za.ac.cput.factory.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.controller.details.EmployeeAddressController;
import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.details.City;
import za.ac.cput.domain.details.Country;
import za.ac.cput.domain.users.EmployeeAddress;
import za.ac.cput.factory.details.AddressFactory;
import za.ac.cput.factory.details.CityFactory;
import za.ac.cput.factory.details.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    private City city;
    private Country country;
    private Address address;

    @BeforeEach
    void setUp() {
        this.country = CountryFactory.createCountry("213", "SA");
        assertNotNull(country);
        this.city = CityFactory.createCity("432", "CPT", country);
        assertNotNull(city);
        this.address =  AddressFactory.build("1", "dav","91", "nina", 2190, city);
        assertNotNull(address);

    }

    @Test
    void buildWithSuccess() {
        EmployeeAddress employeeAddress = EmployeeAddressFactory.build("4352", address);
        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    void buildWithError(){
        EmployeeAddress employeeAddress =
                 EmployeeAddressFactory.build("4352", address);
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> EmployeeAddressFactory.build("3445566", address));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("User email is required", exceptionMessage);
    }
}