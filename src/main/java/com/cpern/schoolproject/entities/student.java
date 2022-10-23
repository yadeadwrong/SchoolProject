package com.cpern.schoolproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String Nome;
    String Cognome;
    int annoDiNascita;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classe_id")
    classroom classe;

    public student() {
    }

    public student(long id, String nome, String cognome, int annoDiNascita, classroom classe) {
        this.id = id;
        Nome = nome;
        Cognome = cognome;
        this.annoDiNascita = annoDiNascita;
        this.classe = classe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public int getAnnoDiNascita() {
        return annoDiNascita;
    }

    public void setAnnoDiNascita(int annoDiNascita) {
        this.annoDiNascita = annoDiNascita;
    }

    public classroom getClasse() {
        return classe;
    }

    public void setClasse(classroom classe) {
        this.classe = classe;
    }
}

