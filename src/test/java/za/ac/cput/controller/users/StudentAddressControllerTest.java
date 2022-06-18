package za.ac.cput.controller.users;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Test
 */

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.details.City;
import za.ac.cput.domain.details.Country;
import za.ac.cput.domain.users.Student;
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.factory.details.AddressFactory;
import za.ac.cput.factory.details.CityFactory;
import za.ac.cput.factory.details.CountryFactory;
import za.ac.cput.factory.users.StudentAddressFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudentAddressController controller;

    private Country country;
    private City city;
    private Address address;

    private StudentAddress studentAddress;

    private final String baseUrl = "http://localhost:"+this.port+"/school_management/studentAddress/";

    @BeforeEach
    void setUp()
    {
        this.country = CountryFactory.createCountry("1", "SA");
        assertNotNull(country);
        this.city = CityFactory.createCity("12", "Cpt", country);
        assertNotNull(city);
        this.address = AddressFactory.build("1",
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
        String url = this.baseUrl+"save";
        ResponseEntity<StudentAddress> response = this.restTemplate
                .postForEntity(url, this.studentAddress, StudentAddress.class);
        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertNotNull(response.getBody())
                );
    }

    @Test
    @Order(2)
    void read()
    {
        String url = this.baseUrl+"read/"+this.studentAddress.getStudentId();
        ResponseEntity<StudentAddress> response = this.restTemplate
                .getForEntity(url, StudentAddress.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = this.baseUrl+"delete/"+this.studentAddress.getStudentId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = this.baseUrl+"all";
        ResponseEntity<StudentAddress[]> response = this.restTemplate
                .getForEntity(url, StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertTrue(response.getBody().length == 1)
                );
    }
}
