package com.wang.dojosandninjas.project.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="dojos")
public class Dojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    public List<Ninja> getNinjas() {
        return ninjas;
    }
    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }

    public Dojo() {

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
