package za.ac.cput.service.details.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.details.City;
import za.ac.cput.factory.details.CityFactory;
import za.ac.cput.factory.details.CountryFactory;
import za.ac.cput.service.details.interfaces.ICityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*CityServiceImpl.java
@Author Nolubabalo Ndongeni 219319464
Date: 14 June 2022
*/
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CityServiceTest {

    private final City city = CityFactory.buildCity("city002", "Pretoria", CountryFactory.builder("country002", "South Africa"));
    private City cityId = CityFactory.buildCity(city.getId(),"Cape Town", CountryFactory.builder("country002", "South Africa"));
    @Autowired
    private ICityService service;



    @Test
    @Order(1)
    void save(){
        City saved = this.service.save(city);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(city, saved);

    }


    @Test
    @Order(2)
    void read() {
        Optional<City> read = this.service.read(this.city.getId());
        System.out.println(read);
        assertTrue(read.isPresent());
        assertEquals(this.city,read.get());

    }

    @Test
    @Order(4)
    void deleteById(){
        String cityId = this.cityId.getId();
        this.service.delete(cityId);
    }



    @Test
    @Order(5)
    void findAll(){
        List<City> cityList = this.service.findAll();
        System.out.println(cityList);
        assertSame(0, cityList.size());
    }

    @Test
    @Order(3)
    void findById(){
        String cityId = this.cityId.getId();
        Optional<City> cityList = this.service.findById(cityId);
        assertSame(1, cityList);
    }
}