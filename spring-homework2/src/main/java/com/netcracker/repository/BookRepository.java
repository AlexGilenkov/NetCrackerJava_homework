package com.netcracker.repository;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.netcracker.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select name, price from books", nativeQuery = true)
    List<String> findAllNameAndPriceForBooks();

    @Query(value = "select name, price from books b where b.price > :edge", nativeQuery = true)
    List<String> findBooksHighlyEdgeByPrice(@Param("edge") Integer edge);

    @Query(value = "select name, price from books b where cast(position(:subname in b.name) as boolean)", nativeQuery = true)
    List<String> findBooksBySubname(@Param("subname") String subname);

}
