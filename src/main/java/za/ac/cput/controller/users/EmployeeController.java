/*  Davin Carstens 220021333
 */
package za.ac.cput.controller.users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.users.EmployeeAPI;
import za.ac.cput.domain.users.Employee;
import za.ac.cput.service.users.impl.EmployeeServiceImp;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("school_management/employee/")
@Slf4j
public class EmployeeController {
    private final EmployeeServiceImp employeeService;
    private final EmployeeAPI api;


    @Autowired
    EmployeeController(EmployeeServiceImp employeeService, EmployeeAPI api) {
        this.employeeService = employeeService;
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save(@Valid @RequestBody Employee saveEmployee){
        log.info("Save request: {}",saveEmployee);
        try{
            Employee newEmp = this.api.save(saveEmployee);
            return ResponseEntity.ok(newEmp);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readEmployee/{staffId}")
    public ResponseEntity<Employee> read(@PathVariable String staffId){
        log.info("Read request: {}",staffId);

        try {
            Employee readEmployee = employeeService.read(staffId);
            return ResponseEntity.ok(readEmployee);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("delete/{staffId}")
    public ResponseEntity<Employee> delete(@PathVariable String staffId){
        log.info("Delete request: {}",staffId);
        this.employeeService.delete(staffId);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> list = this.employeeService.findAll();
        return ResponseEntity.ok(list);
    }
}
