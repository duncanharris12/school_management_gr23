package za.ac.cput.service.users.impl;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Address Service Implementation
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.repository.users.interfaces.StudentAddressRepository;
import za.ac.cput.service.users.interfaces.StudentAddressIService;

import java.util.List;

@Service
public class StudentAddressServiceImpl implements StudentAddressIService
{
    private final StudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(StudentAddressRepository studentAddressRepository)
    {
        this.repository = studentAddressRepository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return this.repository.save(studentAddress);
    }

    @Override
    public StudentAddress read(String studentId) {
        return this.repository.getById(studentId);
    }

    @Override
    public void delete(String studentId)
    {
        this.repository.deleteById(studentId);
    }

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }
}
