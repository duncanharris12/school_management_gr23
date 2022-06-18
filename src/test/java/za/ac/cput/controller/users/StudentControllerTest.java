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
import za.ac.cput.domain.details.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.factory.details.NameFactory;
import za.ac.cput.factory.users.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest
{
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudentController controller;

    private Student student;

    private Name name;

    private final String baseUrl = "http://localhost:"+this.port+"/school_management/student/";

    @BeforeEach
    void setUp()
    {
        this.name = NameFactory.buildName("Duncan"
                ,"Benjamin"
                ,"Harris");
        assertNotNull(name);
        this.student = StudentFactory.build("220110530",
                "dummyEmail@gmail.com"
                ,name);
        assertNotNull(student);
    }

    @Test
    @Order(1)
    void save()
    {
        String url = this.baseUrl+"save";
        ResponseEntity<Student> response = this.restTemplate
                .postForEntity(url, this.student, Student.class);
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
        String url = this.baseUrl+"read/"+this.student.getStudentId();
        ResponseEntity<Student> response = this.restTemplate
                .getForEntity(url, Student.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Order(4)
    void delete()
    {
        String url = this.baseUrl+"delete/"+this.student.getStudentId();
        this.restTemplate.delete(url);
    }

    @Test
    @Order(3)
    void findAll()
    {
        String url = this.baseUrl+"all";
        ResponseEntity<Student[]> response = this.restTemplate
                .getForEntity(url, Student[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll
                (
                        () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                        () -> assertTrue(response.getBody().length == 1)
                );
    }
}