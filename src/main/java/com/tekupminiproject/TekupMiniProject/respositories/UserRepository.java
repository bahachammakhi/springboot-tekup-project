package com.tekupminiproject.TekupMiniProject.respositories;

import com.tekupminiproject.TekupMiniProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);


}

