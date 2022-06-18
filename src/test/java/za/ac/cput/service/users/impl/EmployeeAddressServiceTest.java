package za.ac.cput.service.users.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.details.City;
import za.ac.cput.domain.details.Country;
import za.ac.cput.domain.users.EmployeeAddress;
import za.ac.cput.repository.users.interfaces.EmployeeAddressRepository;
import za.ac.cput.service.users.interfaces.EmployeeAddressService;

import java.util.List;

class EmployeeAddressServiceTest {

    private EmployeeAddressRepository repository;
    private EmployeeAddressService employeeAddressService;

    private Country country;
    private City city;
    private Address address;

    @BeforeEach
    void setUp() {

    }

    @Test
    @Order(1)
    void read() {
    }

    @Test
    @Order(4)
    void delete() {
    }

    @Test
    @Order(1)
    void save() {
    }

    @Test
    @Order(3)
    void findAll() {
    }
}