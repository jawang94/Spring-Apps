package com.wang.relationships.project.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private String fullName;
    public String getFullName() { return fullName; }
    public void setFullName(String first, String last) {
        this.fullName = first + " " + last;
    }
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="person", cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    private License license;
    public License getLicense() {
        return license;
    }
    public void setLicense(License license) {
        this.license = license;
    }

    public Person() {

    }


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
