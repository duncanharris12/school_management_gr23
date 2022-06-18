package za.ac.cput.service.details.interfaces;

/**
 * Name: Onele Tomson
 * Student number: 219483280
 *CityCountryService
 */

import za.ac.cput.domain.details.City;
import za.ac.cput.domain.details.Country;

import java.util.List;

public interface CityCountryService
{
    List<City> findByCityIdAndCountryId(String cityId, String countryId);
}
