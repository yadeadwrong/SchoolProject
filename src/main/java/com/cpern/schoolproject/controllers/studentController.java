package com.cpern.schoolproject.controllers;


import com.cpern.schoolproject.entities.student;
import com.cpern.schoolproject.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class studentController {
    @Autowired
    studentRepository studentRepository;
    @GetMapping("/studente")
    public ResponseEntity<Page<student>> getAllStudents()
    {
         Page<student>  studentPage = studentRepository.findAll(PageRequest.of(0,10));
         return new ResponseEntity<Page<student>>(studentPage, HttpStatus.OK);
    }
    @PostMapping("/studente/add")
    public ResponseEntity addStudent(@RequestBody  student studenteDaAgg)
    {
        studentRepository.save(studenteDaAgg);
        return new ResponseEntity<String>("Studente Aggiunto", HttpStatus.OK);
    }



}
