package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @PrimaryKeyJoinColumn
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private int price;
    @Column(name = "stock", nullable = false)
    private  String stock;
    @Column(name = "count", nullable = false)
    private int count;
}
