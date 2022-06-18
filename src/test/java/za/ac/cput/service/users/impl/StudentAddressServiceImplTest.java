package za.ac.cput.service.users.impl;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Test
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.details.City;
import za.ac.cput.domain.details.Country;
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.factory.details.AddressFactory;
import za.ac.cput.factory.details.CityFactory;
import za.ac.cput.factory.details.CountryFactory;
import za.ac.cput.factory.users.StudentAddressFactory;
import za.ac.cput.repository.users.interfaces.StudentAddressRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplTest {

    private StudentAddressRepository repository;

    private StudentAddressServiceImpl service;

    private Country country;
    private City city;
    private Address address;

    private StudentAddress studentAddress;
    @BeforeEach
    void setUp()
    {
        service = new StudentAddressServiceImpl(repository);
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
        this.studentAddress = StudentAddressFactory.build("220110530"
                ,address);
        assertNotNull(studentAddress);
    }

    @Test
    @Order(1)
    void save()
    {
        StudentAddress save = this.repository.save(studentAddress);
        assertEquals(this.studentAddress, save);
    }

    @Test
    @Order(2)
    void read()
    {
        StudentAddress read = this.repository.getById(this.studentAddress.getStudentId());
        assertEquals(this.studentAddress, read);
    }

    @Test
    @Order(4)
    void delete()
    {
        this.repository.deleteById(this.studentAddress.getStudentId());
        List<StudentAddress> studentAddressList = this.repository.findAll();
        assertEquals(0, studentAddressList.size());
    }

    @Test
    @Order(3)
    void findAll()
    {
        List<StudentAddress> studentAddressList = this.repository.findAll();
        assertEquals(1, studentAddressList.size());
    }
}