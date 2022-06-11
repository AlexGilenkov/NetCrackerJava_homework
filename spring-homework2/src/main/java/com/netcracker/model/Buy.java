package com.netcracker.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "buys")
@Data
public class Buy {

    @Id
    @Column(name = "number", nullable = false, unique = true)
    @PrimaryKeyJoinColumn
    private int number;
    @Column(name = "date", nullable = false)
    private LocalDate date;
    @Column(name = "seller", nullable = false)
    private int seller;
    @Column(name = "buyer", nullable = false)
    private int buyer;
    @Column(name = "book", nullable = false)
    private int book;
    @Column(name = "count", nullable = false)
    private int count;
    @Column(name = "summ", nullable = false)
    private int summ;

}
