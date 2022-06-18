package za.ac.cput.service.users.interfaces;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Address Service Interface
 */
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.service.IService;

import java.util.List;

public interface StudentAddressIService extends IService<StudentAddress, String>
{
    List<StudentAddress> findAll();
}
