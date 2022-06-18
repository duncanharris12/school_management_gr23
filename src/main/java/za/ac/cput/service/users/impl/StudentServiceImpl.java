package za.ac.cput.service.users.impl;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Service Implementation
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.Student;
import za.ac.cput.repository.users.interfaces.StudentRepository;
import za.ac.cput.service.users.interfaces.StudentIService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentIService
{
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository)
    {
        this.repository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return this.repository.save(student);
    }

    @Override
    public Student read(String studentId) {
        return this.repository.getById(studentId);
    }

    @Override
    public void delete(String studentId)
    {
        this.repository.deleteById(studentId);
    }

    @Override
    public List<Student> findAll() {
        return this.repository.findAll();
    }
}
