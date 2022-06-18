package za.ac.cput.repository.details.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.details.City;

import java.util.List;
import java.util.Optional;

/*ICityRepository.java
@Author Nolubabalo Ndongeni 219319464
Date: 14 June 2022
*/
@Repository
public interface ICityRepository extends JpaRepository<City, String> {
    //Finding the city list by name
    City findByName(String name);
}