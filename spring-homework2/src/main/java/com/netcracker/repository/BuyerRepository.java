package com.netcracker.repository;

import com.netcracker.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {

    @Query(value = "select area from buyers", nativeQuery = true)
    Set<String> findAllAreasWhereLiveBuyers();

    @Query(value = "select family, discount from buyers b where b.area = :area", nativeQuery = true)
    List<String> findBuyersByArea(@Param("area") String area);
}
