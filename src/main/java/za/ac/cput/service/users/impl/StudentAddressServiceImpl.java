package za.ac.cput.service.users.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.repository.users.interfaces.StudentAddressRepository;
import za.ac.cput.service.users.interfaces.StudentAddressIService;

import java.util.List;

@Service
public class StudentAddressServiceImpl implements StudentAddressIService
{
    private StudentAddressRepository repository;

    private StudentAddressServiceImpl(StudentAddressRepository studentAddressRepository)
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
