package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Data
public class Shop {

    @Id
    @PrimaryKeyJoinColumn
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "area", nullable = false)
    private String area;
    @Column(name = "commission", nullable = false)
    private int commission;

}
