package za.ac.cput.factory.users;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Address Factory
 */

import za.ac.cput.domain.details.Address;
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.util.StringHelper;

public class StudentAddressFactory
{
    public static StudentAddress build(String studentId, Address address)
    {
        StringHelper.checkStringParam("studentId", studentId);
        return new StudentAddress.Builder()
                .setStudentId(studentId)
                .setAddress(address)
                .build();
    }
}

