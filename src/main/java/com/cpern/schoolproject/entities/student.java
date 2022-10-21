package com.cpern.schoolproject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String Nome;
    String Cognome;
    int annoDiNascita;
    String classe;

    public student() {
    }

    public student(long id, String nome, String cognome, int annoDiNascita, String classe) {
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}

