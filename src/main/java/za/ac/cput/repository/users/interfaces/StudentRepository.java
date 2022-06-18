package za.ac.cput.repository.users.interfaces;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Repository
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.users.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>
{

}
