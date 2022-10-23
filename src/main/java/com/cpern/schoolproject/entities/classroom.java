package com.cpern.schoolproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class classroom {

    @Id
    @GeneratedValue
    long id;
    @JsonIgnore
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<student> studentList;
    String code;


    public classroom() {
    }

    public classroom(long id, List<student> studentList, String code) {
        this.id = id;
        this.studentList = studentList;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<student> studentList) {
        this.studentList = studentList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}