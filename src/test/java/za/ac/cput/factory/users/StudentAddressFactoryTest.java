package za.ac.cput.factory.users;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Test
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.details.City;
import za.ac.cput.domain.details.Country;
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.factory.details.AddressFactory;
import za.ac.cput.factory.details.CityFactory;
import za.ac.cput.factory.details.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressFactoryTest
{
    private Country country;
    private City city;
    private Address address;

    @BeforeEach
    void setUp()
    {

        this.country = CountryFactory.createCountry("1", "SA");
        assertNotNull(country);
        this.city = CityFactory.buildCity("12", "Cpt", country);
        assertNotNull(city);
        this.address = AddressFactory.createAddressFactory("1",
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