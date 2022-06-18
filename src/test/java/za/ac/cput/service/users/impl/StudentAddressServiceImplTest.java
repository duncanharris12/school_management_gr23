package za.ac.cput.service.users.impl;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.details.Address;
import za.ac.cput.factory.details.CityFactory;
import za.ac.cput.repository.users.interfaces.StudentAddressRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplTest {

    private StudentAddressRepository repository;

    private StudentAddressServiceImpl studentAddressService;

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
    @Order(1)
    void save()
    {

    }

    @Test
    @Order(2)
    void read()
    {

    }

    @Test
    @Order(4)
    void delete()
    {

    }

    @Test
    @Order(3)
    void findAll()
    {

    }
}