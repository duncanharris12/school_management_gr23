///*  Davin Carstens 220021333
// */
//package za.ac.cput.controller.users;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import za.ac.cput.domain.users.EmployeeAddress;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class EmployeeAddressControllerTest {
//
//    @LocalServerPort
//    private int portNum;
//    @Autowired
//    EmployeeAddressController employeeAddressController;
//    @Autowired private TestRestTemplate testRestTemplate;
//
//    private EmployeeAddress employeeAddress;
//    private String urlBase;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    @Order(1)
//    void save() {
//    }
//
//    @Test
//    @Order(1)
//    void read() {
//    }
//
//    @Test
//    @Order(1)
//    void delete() {
//    }
//
//    @Test
//    @Order(1)
//    void findAll() {
//    }
//}