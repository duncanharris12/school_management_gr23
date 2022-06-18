package za.ac.cput.factory.details;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.details.City;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/*CityFactoryTest.java
@Author Nolubabalo Ndongeni 219319464
Date: 10 June 2022
*/

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityFactoryTest {
    ArrayList<City> city = new ArrayList<City>();
    private static final City city1 = CityFactory.buildCity("city001","Cape Town",CountryFactory.builder("country001","South Africa"));
    private static final City city2 = CityFactory.buildCity("city002","Pretoria",CountryFactory.builder("country002","South Africa"));
    private static final City city3 = CityFactory.buildCity("city003","Soweto",CountryFactory.builder("country003","South Africa"));

    @Test
    @Order(1)
    void builder(){
        city.add(city1);
        System.out.println(city.get(0) + "added");
        city.add(city2);
        System.out.println(city.get(1) + "added");
        city.add(city3);
        System.out.println(city.get(3) + "added");

        assertNotNull(city1);
        assertNotNull(city2);
        assertNotNull(city3);

        assertNotNull(city2.getName());
        assertNotNull(city3.getName());

    }
    @Test
    @Order(2)
    public void buildWithSuccess(){
        City city = CityFactory.buildCity("city001","Cape Town",CountryFactory.builder("country001","South Africa"));
        System.out.println(city);
        assertNotNull(city);
    }
    @Test
    @Order(3)
    public void buildWithError(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                CityFactory.buildCity(null,"Cape Town", CountryFactory.builder("country001", "South Africa")));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame(exceptionMessage, exceptionMessage);
    }




}