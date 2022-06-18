package za.ac.cput.factory.users;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Factory
 */

import za.ac.cput.domain.details.Name;
import za.ac.cput.domain.users.Student;
import za.ac.cput.util.EmailAddressValidator;
import za.ac.cput.util.StringHelper;

public class StudentFactory
{
    public static Student build(String studentId, String email, Name name)
    {
        StringHelper.checkStringParam("studentId", studentId);
        StringHelper.checkStringParam("email", email);
        //EmailAddressValidator ensures that valid email addresses are inputted
        EmailAddressValidator.validator("email", email);
        return new Student.Builder()
                .setStudentId(studentId)
                .setEmail(email)
                .setName(name)
                .build();
    }
}
