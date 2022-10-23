package com.cpern.schoolproject.controllers;

import com.cpern.schoolproject.entities.classroom;
import com.cpern.schoolproject.entities.student;
import com.cpern.schoolproject.repositories.classroomRepository;
import com.cpern.schoolproject.repositories.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/classe")

public class classroomController {
    @Autowired
    classroomRepository classroomRepo;
    @PostMapping("/add")
    public ResponseEntity addClassRoom(@RequestBody classroom classToAdd)
    {
        try
        {
            classroomRepo.save(classToAdd);
            return new ResponseEntity("Classroom added", HttpStatus.OK);

        }catch (Exception e)
        {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping()
    public ResponseEntity getClassRooms()
    {
        try
        {

            return new ResponseEntity(classroomRepo.findAll(), HttpStatus.OK);

        }catch (Exception e)
        {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
