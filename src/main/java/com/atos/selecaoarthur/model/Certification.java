package com.atos.selecaoarthur.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "CERTIFICATION")
public class Certification {

    @JsonIgnore
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    public Certification() {}

    public Certification(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
