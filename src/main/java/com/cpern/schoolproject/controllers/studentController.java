package com.cpern.schoolproject.controllers;


import com.cpern.schoolproject.entities.student;
import com.cpern.schoolproject.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/studente")
public class studentController {
    @Autowired
    studentRepository studentRepository;
    @GetMapping
    public ResponseEntity getAllStudents(@RequestParam(defaultValue = "0") Integer page)
    {
            try {
                Page<student> studentPage = studentRepository.findAll(PageRequest.of(page, 3));

                return new ResponseEntity<>(studentPage, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
    @GetMapping("/{id}")
    public  ResponseEntity getSingleStudent(@PathVariable("id") long id){
        try
        {
            Optional<student> retStudent;
            retStudent = this.studentRepository.findById(id);
            if(retStudent.isEmpty())
            {
                return new ResponseEntity<>("Studente non trovato", HttpStatus.NOT_FOUND);
            }
            else {
                return ResponseEntity.ok(retStudent);
            }
        }
        catch (Exception e) {

            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody  student studenteDaAgg)
    {
       try {

           studentRepository.save(studenteDaAgg);
           return new ResponseEntity<>("Studente Aggiunto", HttpStatus.OK);
       }catch (Exception e)
       {
           return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") long id)
    {
        try{

                studentRepository.deleteById(id);
                return new ResponseEntity<>("Studente Eliminato", HttpStatus.OK);


        }
        catch (EmptyResultDataAccessException e)
        {
            return new ResponseEntity<>("Studente Non Trovato", HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {

            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }




}
