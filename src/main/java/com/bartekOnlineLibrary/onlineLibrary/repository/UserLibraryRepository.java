package com.bartekOnlineLibrary.onlineLibrary.repository;

import com.bartekOnlineLibrary.onlineLibrary.model.UserLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface UserLibraryRepository extends JpaRepository<UserLibrary,Long> {
    UserLibrary findByUsernameAndPassword(String username, String password);

    UserLibrary findByUsername(String username);

//    @Modifying
//    @Query("UPDATE UserLibrary u SET u.name = :name, u.lastName = :surname, u.email = :email, u.dateOfBirth = :dob WHERE u.id = :userId")
//    void updateProfile(@Param("userId") Long userId, @Param("name") String name, @Param("surname") String surname, @Param("email") String email, @Param("dob") LocalDate dob);

    @Modifying
    @Transactional
    @Query("UPDATE UserLibrary u SET u.email = ?1, u.username = ?2, u.password = ?3, u.name = ?4, u.lastName = ?5, u.dateOfBirth = ?6, u.picture = ?7 WHERE u.id = ?8")
    void updateUser(String email, String username, String password, String name, String lastName, LocalDate dateOfBirth, byte[] picture, long id);
}
