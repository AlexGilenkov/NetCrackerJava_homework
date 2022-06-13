package com.netcracker.repository;

import com.netcracker.model.Buy;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BuyRepository extends JpaRepository<Buy, Integer> {

    @Query(value = "select date from buys", nativeQuery = true)
    List<Date> findAllDateOfBuys();

    @Query(value = "select number, date,bk.name as book,d.count,family,s.name as shop,summ from buys d " +
            "inner join buyers b on b.id = buyer  " +
            "inner join shops s on s.id = seller " +
            "inner join books bk on bk.id = book", nativeQuery = true)
    List<String> findAllBuysWithOtherTablesData();

    @Query(value = "select number, family, date from buys " +
            "inner join buyers b on b.id = buyer where summ >= :edge", nativeQuery = true)
    List<String> findBuysWithSummHighlyEdge (@Param("edge") Integer edge);

    @Query(value = "select family, b.area, date from buys " +
            "inner join buyers b on b.id = buyer " +
            "inner join shops s on s.id = seller " +
            "where b.area = s.area " +
            "order by date", nativeQuery = true)
    List<String> findBuysInBuyersArea();

    @Query(value = "select s.name, s.area from buys " +
            "inner join buyers b on b.id = buyer " +
            "inner join shops s on s.id = seller " +
            "where s.area != :outcast and " +
            "b.discount >= :bottomBound and b.discount <= :topBound" , nativeQuery = true)
    Set<String> findShopsBesidesSomeoneWithTopAndBottomBounds(
            @Param("outcast") String outcast,
            @Param("bottomBound") Integer bottomBound,
            @Param("topBound") Integer topBound);

    @Query(value = "select b.name, b.stock, b.count, b.price from buys bs " +
            "inner join books b on b.id = bs.book " +
            "inner join shops s on s.id = seller " +
            "where b.stock = s.area and b.count > :count " +
            "order by b.price" , nativeQuery = true)
    List<String> findAllBuysWhereShopAreaEqualsBookStock(@Param("count") Integer count);

}
