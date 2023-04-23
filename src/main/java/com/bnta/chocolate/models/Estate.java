package com.bnta.chocolate.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity( name = "estates")
public class Estate {
// i think the @id, generatedvalue, column, entity annotations are all from 'Hibernate'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "countries")
    private String country;

    @OneToMany(mappedBy = "estate")
    @JsonIgnoreProperties({"estate"}) // to stop the serialisation/recurring process/cycle of get the estate->get the relevant chocolate -> oh these chocolates have an estate_id -> oh these have chocolates -> these have an estate etc etc
    private List<Chocolate> chocolates;
// I think we do jsonignoreproperties on the estate because estate is a dependency. i.e. we cant have a chocolate without an estate, so estate is the starting point, then chocolate and then back to estate again so we are ignoring the estate to stop the serialisation cycle/process

    public Estate(String name, String country) {
        this.name = name;
        this.country = country;
        this.chocolates = new ArrayList<Chocolate>();
    }

    public Estate() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public List<Chocolate> getChocolates() {
        return chocolates;
    }

    public void setChocolates(List<Chocolate> chocolates) {
        this.chocolates = chocolates;
    }
}
