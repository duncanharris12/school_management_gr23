/*  Davin Carstens 220021333
 */
package za.ac.cput.controller.users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.users.EmployeeAddressAPI;
import za.ac.cput.domain.users.EmployeeAddress;
import za.ac.cput.service.users.impl.EmployeeAddressServiceImp;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/employee_Address/")
@Slf4j
public class EmployeeAddressController {
    private final EmployeeAddressServiceImp employeeAddressService;
    private final EmployeeAddressAPI addressAPI;

    @Autowired
    public EmployeeAddressController(EmployeeAddressServiceImp employeeAddressService, EmployeeAddressAPI addressAPI) {
        this.employeeAddressService = employeeAddressService;
        this.addressAPI = addressAPI;
    }

    @PostMapping("save")
    public ResponseEntity<EmployeeAddress> save(@Valid @RequestBody EmployeeAddress saveEmployeeAddress){
        log.info("Save request: {}",saveEmployeeAddress);
        try{
            EmployeeAddress newEmpAdd= this.addressAPI.save(saveEmployeeAddress);
            return ResponseEntity.ok(newEmpAdd);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readEmployeeAddress/{empID}")
    public ResponseEntity<EmployeeAddress> read(@PathVariable String empID){
        log.info("Read request: {}",empID);

        try{
            EmployeeAddress readEmployeeAddress = employeeAddressService.read(empID);
            return ResponseEntity.ok(readEmployeeAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteEmployeeAddress/{empID}")
    public ResponseEntity<EmployeeAddress> delete(@PathVariable String empID){
        log.info("Delete request: {}",empID);

        this.employeeAddressService.delete(empID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeeAddress>> findAll(){
        List<EmployeeAddress> listEmployeeAddress = this.employeeAddressService.findAll();
        return ResponseEntity.ok(listEmployeeAddress);
    }
}
