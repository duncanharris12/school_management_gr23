package za.ac.cput.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.Student;
import za.ac.cput.repository.users.interfaces.StudentRepository;
import za.ac.cput.service.users.interfaces.StudentIService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentIService
{
    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.repository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student read(String s) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
