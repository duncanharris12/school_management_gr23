package za.ac.cput.service.details.impl;

/**
 * Name: Onele Tomson
 * Student number: 219483280
 *CountryService
 */

import za.ac.cput.domain.details.Country;
import za.ac.cput.service.IService;

import java.util.List;

public interface CountryService extends IService<Country, String> {
    public List<Country> getAll();

}
