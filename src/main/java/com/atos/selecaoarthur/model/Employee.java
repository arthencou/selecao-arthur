package com.atos.selecaoarthur.model;

import java.util.List;
import java.util.Set;

//TODO Make Entity
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

    public enum Gcm {
        GCM1,
        GCM2,
        GCM3,
        GCM4,
        GCM5
    }

    private Long id;
    private String name;
    private EmployeeRole role;
    private Double salary;
    private Employee manager;
    private Gcm gcm;
    private List<Project> projects;
    //FIXME Change to Skill type
    private Set<String> skills;
    private List<String> certification;

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

    public Gcm getGcm() {
        return gcm;
    }

    public void setGcm(Gcm gcm) {
        this.gcm = gcm;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public List<String> getCertification() {
        return certification;
    }

    public void setCertification(List<String> certification) {
        this.certification = certification;
    }
}
