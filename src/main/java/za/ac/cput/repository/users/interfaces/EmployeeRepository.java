/*  Davin Carstens 220021333
 */
package za.ac.cput.repository.users.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.users.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByEmail(String email);

//    List<Employee> readAll();

//    List<Employee> findByEmail(Name name);
}
