package za.ac.cput.repository.users.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.users.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>
{

}
