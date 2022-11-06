package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code,Long> {
    List<Code> findAllByBook(Book book);
    @Query(nativeQuery = true,value = "select * from code c where c.book_id = :bookId and c.status_id = 2 limit :limitRecord")
    List<Code> getAllByBookId(@Param("bookId") Long id,@Param("limitRecord") Integer limitRecord);
}
