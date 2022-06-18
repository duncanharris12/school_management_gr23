package za.ac.cput.repository.details.interfaces;

/**
 * Name: Onele Tomson
 * Student number: 219483280
 *CountryRepository
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.details.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
