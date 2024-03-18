package com.arabic.tgcc.Etudiant;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/std")
public class EtudiantController {


    @Autowired
    private EtudiantService etudiantService;

    @GetMapping(value = {"","/"})
    public ResponseEntity<List<Student>> getAllstudents()
    { List<Student> result = etudiantService.findAll();
      return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {

        Student result =  etudiantService.getById(id);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping(value = {"","/"})
    public ResponseEntity<Student> createNewStudent(@Valid @RequestBody Student student) {
        Student result = etudiantService.save(student);
        return new ResponseEntity<Student>(result, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id)
    {


        etudiantService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}
