package za.ac.cput.controller.details;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.details.City;
import za.ac.cput.factory.details.CityFactory;
import za.ac.cput.factory.details.CountryFactory;

import static org.junit.jupiter.api.Assertions.*;
/*CityControllerTest.java
@Author Nolubabalo Ndongeni 219319464
Date: 15 June 2022
*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private CityController cityController;
    @Autowired
    private TestRestTemplate restTemplate;
    private City city;
    private String BASE_URL;


    @BeforeEach
    void setUp(){
        this.city = CityFactory.buildCity("city003","Gauteng", CountryFactory.builder("country003","South Africa"));
        this.BASE_URL = "http://localhost:"+this.port+"/school_management/city/";
        save();
    }

    @Test
    @Order(2)
    void save(){
        String url=BASE_URL+"save";
        ResponseEntity<City> saveRes = this.restTemplate.postForEntity(url,this.city, City.class);
        System.out.println("Response" + saveRes);
        assertNotNull(saveRes);
    }

    @Test
    @Order(3)
    void read(){
        String url = BASE_URL+"read"+city.getId();
        ResponseEntity<City> readRes = this.restTemplate.getForEntity(url,City.class);
        System.out.println("Response" + readRes);

    }

    @Test
    @Order(4)
    void findAll(){
        String url = BASE_URL+ "all";
        this.restTemplate.delete(url, city);
    }

    @Test
    @Order(5)
    void delete(){
        String url = BASE_URL+"delete";
        ResponseEntity<City>deleteRes = this.restTemplate.getForEntity(url,City.class);
        System.out.println("Response" + deleteRes);
        assertNotNull(deleteRes);
    }

}