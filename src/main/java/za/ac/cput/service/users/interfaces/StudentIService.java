package za.ac.cput.service.users.interfaces;

import za.ac.cput.domain.users.Student;
import za.ac.cput.service.IService;

import java.util.List;

public interface StudentIService extends IService<Student, String>
{
    List<Student> findAll();
}
