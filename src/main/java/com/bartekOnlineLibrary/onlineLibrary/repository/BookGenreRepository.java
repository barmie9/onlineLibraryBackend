package com.bartekOnlineLibrary.onlineLibrary.repository;

import com.bartekOnlineLibrary.onlineLibrary.model.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre,Long> {
}
