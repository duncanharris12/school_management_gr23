package za.ac.cput.service.details.interfaces;

import za.ac.cput.domain.details.City;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

/*ICityService.java
@Author Nolubabalo Ndongeni 219319464
Date: 12 June 2022
*/

public interface ICityService extends IService<City, String> {

    List<City> findAll();

    Optional<City> findById(String id);
}