package za.ac.cput.service.details.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.details.City;
import za.ac.cput.repository.details.interfaces.ICityRepository;
import za.ac.cput.service.details.interfaces.ICityService;

import java.util.List;
import java.util.Optional;

/*CityService.java
@Author Nolubabalo Ndongeni 219319464
Date: 12 June 2022
*/
@Service
public class CityService implements ICityService {
    private final ICityRepository repository;


    @Autowired
    public CityService(ICityRepository repository){
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String id) {
        return this.repository.findById(id);
    }

   @Override
    public void delete(String id) {
        this.repository.deleteById(id);

    }


    @Override
    public List<City> findAll(){
        return this.repository.findAll();
    }

    @Override
    public Optional<City> findById(String cityId){
        return this.repository.findById(cityId);
    }
}



