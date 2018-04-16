package com.atos.selecaoarthur.model;

import javax.persistence.*;

@Entity
@Table(name = "SKILL", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Skill {

    @Id @GeneratedValue
    private Long id;
    private String name;

    public Skill() {}

    public Skill(String name) {
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
