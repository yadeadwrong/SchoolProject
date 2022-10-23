package com.cpern.schoolproject.repositories;

import com.cpern.schoolproject.entities.classroom;
import com.cpern.schoolproject.entities.student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface classroomRepository extends JpaRepository<classroom, Long> {


}
