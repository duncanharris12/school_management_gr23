package za.ac.cput.service.users.impl;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Test
 */

import org.junit.jupiter.api.*;
import za.ac.cput.domain.details.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.factory.details.NameFactory;
import za.ac.cput.factory.users.StudentFactory;
import za.ac.cput.repository.users.interfaces.StudentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplTest {

    private StudentRepository repository;

    private StudentServiceImpl service;

    private Student student;

    private Name name;
    @BeforeEach
    void setUp()
    {
        this.service = new StudentServiceImpl(repository);
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
       Student save = this.repository.save(this.student);
       assertEquals(this.student, save);
   }

   @Test
   @Order(2)
   void read()
   {
        Student read = this.repository.getById(this.student.getStudentId());
        assertEquals(this.student, read);
   }

   @Test
   @Order(4)
   void delete()
   {
       this.repository.deleteById(this.student.getStudentId());
       List<Student> studentList = this.repository.findAll();
       assertSame(0, studentList.size());
   }

   @Test
   @Order(3)
   void findAll()
   {
       List<Student> studentList = this.repository.findAll();
       assertSame(1, studentList.size());
   }
}