package com.cpern.schoolproject.controllers;


import com.cpern.schoolproject.entities.student;
import com.cpern.schoolproject.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class studentController {
    @Autowired
    studentRepository studentRepository;
    @GetMapping("/studente")
    public ResponseEntity<Page<student>> getAllStudents(@RequestParam(defaultValue = "0") Integer page)
    {
            try {
                Page<student> studentPage = studentRepository.findAll(PageRequest.of(page, 3));
                return new ResponseEntity<>(studentPage, HttpStatus.OK);
            } catch (Exception e) {
                return ResponseEntity.internalServerError().build();
            }
    }
    @GetMapping("/studente/{id}")
    public  ResponseEntity getSingleStudent(@PathVariable("id") long id){
        try
        {
            Optional<student> retStudent;
            retStudent = this.studentRepository.findById(id);
            if(retStudent.isEmpty())
            {
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok(retStudent);
            }
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/studente/add")
    public ResponseEntity addStudent(@RequestBody  student studenteDaAgg)
    {
        studentRepository.save(studenteDaAgg);
        return new ResponseEntity<>("Studente Aggiunto", HttpStatus.OK);
    }





}
