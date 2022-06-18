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
    public StudentAddress create(StudentAddress studentAddress) {
        return null;
    }

    @Override
    public StudentAddress read(String s) {
        return null;
    }

    @Override
    public StudentAddress update(StudentAddress studentAddress) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<StudentAddress> findAll() {
        return null;
    }
}
