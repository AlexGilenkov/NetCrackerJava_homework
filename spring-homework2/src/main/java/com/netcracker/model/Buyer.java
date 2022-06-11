package com.netcracker.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "buyers")
@Data
public class Buyer {

    @Id
    @PrimaryKeyJoinColumn
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "family", nullable = false)
    private String family;
    @Column(name = "area", nullable = false)
    private String area;
    @Column(name = "discount", nullable = false)
    private int discount;
}
