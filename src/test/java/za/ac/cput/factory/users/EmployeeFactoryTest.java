/*  Davin Carstens 220021333
 */
package za.ac.cput.factory.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.details.Name;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.factory.details.NameFactory;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    private Name name;
    // = NameFactory.build("Davin", "Shaun", "Carstens");
    private Employee employee;
    // = EmployeeFactory.build("21333", "davincarstens@gmail.com", name);


    @BeforeEach
    void setUp() {
        this.name = NameFactory.buildName("Davin", "Shaun", "Carstens");
        assertNotNull(name);
        this.employee = EmployeeFactory.build("21333", "davincarstens@gmail.com", name);
        assertNotNull(employee);
        System.out.println(employee);
    }

    @Test
    void buildWithSuccess() {
        Name name =
                NameFactory.buildName("Davin", "Shaun", "Carstens");
        assertNotNull(name);
        Employee employee =
                EmployeeFactory.build("21333", "davincarstens@gmail.com", name);
        System.out.println(employee);
        assertNotNull(employee);
    }

    @Test
    void buildWithError() {
        Name name =
                NameFactory.buildName("Davin", "Shaun", "Carstens");
        Exception exception = assertThrows(IllegalArgumentException.class,
                ()-> EmployeeFactory.build("3445566", "davincarstens@gmail.com", name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("User email is required", exceptionMessage);
    }
}