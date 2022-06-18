/*  Davin Carstens 220021333
 */
package za.ac.cput.service.users.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.details.Name;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.factory.details.NameFactory;
import za.ac.cput.factory.users.EmployeeFactory;
import za.ac.cput.repository.users.interfaces.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class EmployeeServiceImpTest {
        private Employee employee;
        private Name name;

        private EmployeeRepository repository;
        private EmployeeServiceImp service;

        @BeforeEach void setUp(){
            service = new EmployeeServiceImp(repository);
            this.name = NameFactory.buildName("Daavin", "Shaun", "Carstens");
            assertNotNull(name);
            this.employee = EmployeeFactory.build("2345", "davincarstens@gmail.com", name);
            assertNotNull(employee);

        }

        @Test
        @Order(2)
        void read() {
            Employee read = this.repository.getById(this.employee.getStaffId());
            assertEquals(this.employee, read);

        }

        @Test
        @Order(1)
        void save() {
            Employee save = this.repository.save(this.employee);
            assertEquals(this.employee, save);
        }

        @Test
        @Order(4)
        void delete() {
            this.repository.deleteById(this.employee.getStaffId());
            List<Employee> employeeList = this.repository.findAll();
            assertSame(0, employeeList.size());
        }

        @Test
        @Order(3)
        void readAll() {
            List<Employee> employeeList = this.repository.findAll();
            assertSame(1, employeeList.size());
        }
    }
