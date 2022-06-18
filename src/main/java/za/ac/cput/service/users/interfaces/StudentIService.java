package za.ac.cput.service.users.interfaces;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Service Interface
 */
import za.ac.cput.domain.users.Student;
import za.ac.cput.service.IService;

import java.util.List;

public interface StudentIService extends IService<Student, String>
{
    List<Student> findAll();
}
