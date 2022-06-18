package za.ac.cput.service.details.impl;

/**
 * Name: Onele Tomson
 * Student number: 219483280
 *CountryServiceImpl
 */

import org.springframework.stereotype.Service;
import za.ac.cput.domain.details.Country;
import za.ac.cput.repository.details.interfaces.CountryRepository;
import java.util.Collections;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> getAll(){
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(Country country){
        return this.countryRepository.save(country);
    }

    @Override
    public Country read(String countryId){
        return this.countryRepository.getById(countryId);
    }

    @Override
    public Country update(Country country) {
        return null;
    }

    @Override
    public void delete(String countryId){
        this.countryRepository.deleteAllById(Collections.singleton(countryId));
    }

}

