package za.ac.cput.controller.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.details.City;
import za.ac.cput.service.details.interfaces.ICityService;

import java.util.List;
import java.util.Optional;

/*CityServiceImpl.java
@Author Nolubabalo Ndongeni 219319464
Date: 14 June 2022
*/
@RestController
@RequestMapping ("/school-management-gr23/cities")
public class CityController {
    private final ICityService ICityService;

    @Autowired
    public CityController(ICityService ICityService){
        this.ICityService = ICityService;
    }

    private Optional<City> getById(String cityId){
        return this.ICityService.read(cityId);
    }

    @PostMapping("save")
    public ResponseEntity<City> save (@Validated @RequestBody City city){
        City save = ICityService.save(city);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{cityId}")
    public ResponseEntity<City> read(@PathVariable String cityId){
        City city = getById(cityId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete/{cityId}")
    public ResponseEntity<Void> delete(@PathVariable String cityId){
        Optional<City> city = getById(cityId);
        if (city.isPresent()){
            this.ICityService.delete(cityId);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<City>> findAll(){
        List<City> cities = this.ICityService.findAll();
        return ResponseEntity.ok(cities);

    }


}



