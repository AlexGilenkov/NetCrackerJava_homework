package com.netcracker.repository;

import com.netcracker.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    @Query(value = "select name from shops s where s.area = :area", nativeQuery = true)
    List<String> findShopsByArea(@Param("area") String area );
}
