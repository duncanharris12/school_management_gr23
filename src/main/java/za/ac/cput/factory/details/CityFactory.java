package za.ac.cput.factory.details;

import za.ac.cput.domain.details.City;
import za.ac.cput.domain.details.Country;
import za.ac.cput.util.StringHelper;

/*CityFactory.java
@Author Nolubabalo Ndongeni 219319464
Date: 10 June 2022
*/
public class CityFactory {
    public static City buildCity(String id, String name, Country country){
        StringHelper.checkStringParam("id", id);
        StringHelper.checkStringParam("name", name);

        return new City.Builder()
                .setId(id)
                .setName(name)
                .setCountry(country)
                .build();
    }


}
