/*  Davin Carstens 220021333
 */
package za.ac.cput.controller.users;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.factory.details.NameFactory;
import za.ac.cput.factory.users.EmployeeFactory;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {

    @LocalServerPort private int portNum;
    @Autowired private EmployeeController employeeController;
    @Autowired private TestRestTemplate testRestTemplate;
    private Employee employee;
    private String urlBase;

    @BeforeEach
    void setUp() {
        assertNotNull(employeeController);
        this.employee = EmployeeFactory.build("21333", "davincarstens@gmail.com",
                NameFactory.buildName("Davin", "Shaun", "Carstens"));
        this.urlBase = "http://localhost:" + this.portNum + "/school_management/employee/";
    }

    @Test
    @Order(1)
    void save() {
        String url = urlBase + "save_employee";
        System.out.println(url);

        ResponseEntity<Employee> responseEntity = this.testRestTemplate
                .postForEntity(url,this.employee,Employee.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()),
                () -> assertSame("21333",employee.getStaffId()),
                () -> assertSame("davincarstens@gmail.com",employee.getEmail()),
                () -> assertSame("Davin",employee.getName().getFirstName()),
                () -> assertSame("Shaun",employee.getName().getMiddleName()),
                () -> assertSame("Carstens",employee.getName().getLastName())
        );
    }

    @Test
    @Order(2)
    void read() {
        String url = urlBase + "readEmployee/" + employee.getStaffId();
        ResponseEntity<Employee> responseEntity = this.testRestTemplate
                .getForEntity(url,Employee.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()),
                () -> assertSame("21333",employee.getStaffId()),
                () -> assertSame("davincarstens@gmail.com",employee.getEmail()),
                () -> assertSame("Davin",employee.getName().getFirstName()),
                () -> assertSame("Shaun",employee.getName().getMiddleName()),
                () -> assertSame("Carstens",employee.getName().getLastName())
        );
    }

    @Test
    @Order(4)
    void delete() {
        String url = urlBase + "deleteEmployee/" + employee.getStaffId();
        this.testRestTemplate.delete(url);
        System.out.println("Deleted");
        assertAll(
                () -> assertSame("21333",employee.getStaffId()),
                () -> assertSame("davincarstens@gmail.com",employee.getEmail()),
                () -> assertSame("Davin",employee.getName().getFirstName()),
                () -> assertSame("Shaun",employee.getName().getMiddleName()),
                () -> assertSame("Carstens",employee.getName().getLastName())
        );
    }

    @Test
    @Order(3)
    void findAll() {
        String url = urlBase + "getAllEmployees";
        System.out.println(url);

        ResponseEntity<Employee[]> responseEntity = this.testRestTemplate
                .getForEntity(url,Employee[].class);

        System.out.println(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));

        assertAll(
                () -> assertEquals(HttpStatus.OK,responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0),
                () -> assertNotNull(responseEntity)
        );

        System.out.println("Test has passed");
    }
}