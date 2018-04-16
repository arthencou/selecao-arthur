package com.atos.selecaoarthur.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "PROJECT")
public class Project {

    @JsonIgnore
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String customer;
    //TODO Format decimal to include dots as grouping symbol and commas as decimal separator
    private Double valueOfProject;
    //TODO Format timestamps to include GMT
    private Timestamp dtBegin;
    private Timestamp dtEnd;

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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Double getValueOfProject() {
        return valueOfProject;
    }

    public void setValueOfProject(Double valueOfProject) {
        this.valueOfProject = valueOfProject;
    }

    public Timestamp getDtBegin() {
        return dtBegin;
    }

    public void setDtBegin(Timestamp dtBegin) {
        this.dtBegin = dtBegin;
    }

    public Timestamp getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Timestamp dtEnd) {
        this.dtEnd = dtEnd;
    }
}
