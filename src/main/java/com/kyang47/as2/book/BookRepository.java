package com.kyang47.as2.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM book b WHERE b.title =?1", nativeQuery = true)
    Optional<List<Book>> findBookByName(String title);
}
