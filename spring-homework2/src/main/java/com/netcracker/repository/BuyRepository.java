package com.netcracker.repository;

import com.netcracker.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BuyRepository extends JpaRepository<Buy, Integer> {

    @Query(value = "select date from buys", nativeQuery = true)
    List<Date> findAllDateOfBuys();

}
