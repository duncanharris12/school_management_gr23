package za.ac.cput.controller.users;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Address Controller
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.users.StudentAddress;
import za.ac.cput.service.users.impl.StudentAddressServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/school_management/studentAddress/")
@Slf4j
public class StudentAddressController
{
    private final StudentAddressServiceImpl service;

    private StudentAddressController(StudentAddressServiceImpl studentAddressService)
    {
        this.service = studentAddressService;
    }

    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@Valid @RequestBody StudentAddress studentAddress)
    {
        log.info("Save Request: {}", studentAddress);
        StudentAddress save = this.service.save(studentAddress);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            StudentAddress read = this.service.read(id);
            return ResponseEntity.ok(read);
        }
        catch (IllegalArgumentException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<StudentAddress>> findAll()
    {
        List<StudentAddress> studentAddressList = this.service.findAll();
        return ResponseEntity.ok(studentAddressList);
    }
}
