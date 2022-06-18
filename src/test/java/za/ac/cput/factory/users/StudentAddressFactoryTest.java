package za.ac.cput.factory.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.users.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;

class studentAddressFactoryTest
{
    private Country country;
    private City city;
    private Address address;

    @BeforeEach
    void setUp()
    {

        this.country = CountryFactory.build("1", "SA");
        assertNotNull(country);
        this.city = CityFactory.build("12", "Cpt", country);
        assertNotNull(city);
        this.address = AddressFactory.createAddress("1",
                "cName"
                ,"27"
                ,"flak"
                ,7729
                ,city);
        assertNotNull(address);
    }

    @Test
    void buildWithSuccess()
    {
        StudentAddress studentAddress = StudentAddressFactory.build
                ("220110530"
                        ,address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }

    @Test
    void buildWithFailure()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentAddressFactory.build
                        (null
                                ,address));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }
}