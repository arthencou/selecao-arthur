package com.atos.selecaoarthur.model;

import com.atos.selecaoarthur.util.json.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    public enum EmployeeRole {

        TI_ARCHITECT("TI Architect"),
        SOFTWARE_ENGINEER("Software Engineer"),
        MANAGER("Manager");

        private final String roleName;

        EmployeeRole(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        public String toString() {
            return this.roleName;
        }
    }

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_SEQ")
    @SequenceGenerator(name = "EMPLOYEE_SEQ", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
    private Long id;

    private String name;

    @JsonDeserialize(using = EmployeeRoleDeserializer.class)
    private EmployeeRole role;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = BrazilianCurrencyStringToDoubleDeserializer.class)
    @JsonSerialize(using = BrazilianCurrencyDoubleToStringSerializer.class)
    private Double salary;

    @OneToOne
    @JoinColumn
    @JsonSerialize(using = EmployeeManagerSerializer.class)
    private Employee manager;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = ZeroPaddedIntToStringSerializer.class)
    //TODO Declare Max and Min validation
    private Integer gcm;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_PROJECT",
            joinColumns = {@JoinColumn(name = "EMPLOYEE")},
            inverseJoinColumns = {@JoinColumn(name = "PROJECT")})
    private List<Project> projects;

    @ManyToMany
    @JoinTable(name = "EMPLOYEE_SKILL",
            joinColumns = {@JoinColumn(name = "EMPLOYEE")},
            inverseJoinColumns = {@JoinColumn(name = "SKILL")})
    @JsonSerialize(using = EmployeeSkillsSerializer.class)
    //TODO Include deserializer from String array of skill names.
//    @JsonDeserialize(using = EmployeeSkillsDeserializer.class)
    private List<Skill> skills;

    @OneToMany
    @JoinColumn(name = "EMPLOYEE")
    @JsonSerialize(using = EmployeeCertificationsSerializer.class)
    private List<Certification> certification;

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

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Integer getGcm() {
        return gcm;
    }

    public void setGcm(Integer gcm) {
        this.gcm = gcm;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Certification> getCertification() {
        return certification;
    }

    public void setCertification(List<Certification> certification) {
        this.certification = certification;
    }
}
