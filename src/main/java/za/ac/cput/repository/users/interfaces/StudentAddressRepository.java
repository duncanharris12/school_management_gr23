package za.ac.cput.repository.users.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.users.StudentAddress;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, String>
{

}
