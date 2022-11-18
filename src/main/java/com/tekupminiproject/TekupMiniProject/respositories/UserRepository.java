package com.tekupminiproject.TekupMiniProject.respositories;

import org.springframework.data.repository.CrudRepository;

import com.tekupminiproject.TekupMiniProject.entities.User;



public interface UserRepository extends CrudRepository<User, Long> {

}
