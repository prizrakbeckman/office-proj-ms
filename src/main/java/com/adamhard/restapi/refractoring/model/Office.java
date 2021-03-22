package com.adamhard.restapi.refractoring.model;

import javax.persistence.*;

@Entity
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column
    public String name;

    @Column
    public String city;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }
}
