package za.ac.cput.factory.users;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Test
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.details.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.factory.details.NameFactory;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    private Name name;

    @BeforeEach
    void setUp()
    {
        this.name = NameFactory.buildName("Duncan"
                ,"Benjamin"
                ,"Harris");
        assertNotNull(name);
    }

    @Test
    void testWithSuccess()
    {
        Student student = StudentFactory.build("220110530"
                ,"dummyEmail@mail.com"
                ,name);
        System.out.println(student);
        assertNotNull(student);
    }

    @Test
    void testWithFailure()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StudentFactory.build(null,
                        "dummyEmail@mail.com",
                        name));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
    }
}