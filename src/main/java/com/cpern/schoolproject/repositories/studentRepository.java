package com.cpern.schoolproject.repositories;
import com.cpern.schoolproject.entities.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface studentRepository extends JpaRepository<student, Long> {


}
