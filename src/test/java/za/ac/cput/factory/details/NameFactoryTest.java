/*
 * Name       : Chante Lee Davids
 * Student num: 220246688
 * Description: Tests the creation the Name objects
 * */

package za.ac.cput.factory.details;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.details.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {
    @Test
    public void buildSuccess_a(){
        Name name = NameFactory.build("Mary","Kate","James");
        System.out.println(name);
        assertNotNull(name);

    }

    @Test
    public void buildSuccess_b(){
        Name name = NameFactory.build("Mary","","James");
        System.out.println(name);
        assertNotNull(name);
    }

    @Test
    public void buildSuccess_c(){
        //middleName can be empty [it is not a mandatory attribute]
        //when middleName = null, it won't be saved but set to an empty string instead
        Name name = NameFactory.build("Mary",null,"James");
        System.out.println(name);
        assertNotNull(name);
    }

    @Test
    public void buildError_a(){
        Name name = NameFactory.build("","","");
        System.out.println(name);
        assertNotNull(name);
    }

    @Test
    public void buildError_b(){
        Name name = NameFactory.build("Kate","","");
        System.out.println(name);
        assertNotNull(name);
    }
}