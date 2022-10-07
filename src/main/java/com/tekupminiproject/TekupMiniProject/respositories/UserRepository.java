package com.tekupminiproject.TekupMiniProject.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tekupminiproject.TekupMiniProject.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {

}
