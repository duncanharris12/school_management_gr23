package za.ac.cput.controller.users;
/*
    Name: Duncan Benjamin Harris
    Student Number: 220110530
    Group Number: 23
    Student Controller
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.users.Student;
import za.ac.cput.service.users.impl.StudentServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/school_management/student/")
@Slf4j
public class StudentController
{
    private final StudentServiceImpl service;

    @Autowired
    private StudentController(StudentServiceImpl studentService)
    {
        this.service = studentService;
    }

    @PostMapping("save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student)
    {
        log.info("Save Request: {}", student);
        Student save = this.service.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Student> read(@PathVariable String id)
    {
        log.info("Read Request: {}", id);
        try
        {
            Student read = this.service.read(id);
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
        log.info("Delete Request: {}", id);
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> findAll()
    {
        List<Student> studentList = this.service.findAll();
        return ResponseEntity.ok(studentList);
    }
}
