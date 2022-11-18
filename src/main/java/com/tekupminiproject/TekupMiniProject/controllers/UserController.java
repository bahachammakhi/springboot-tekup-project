package com.tekupminiproject.TekupMiniProject.controllers;

import org.slf4j.Logger;
import java.util.List;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tekupminiproject.TekupMiniProject.entities.User;
import com.tekupminiproject.TekupMiniProject.exceptions.UserNotFoundException;
import com.tekupminiproject.TekupMiniProject.respositories.UserRepository;

@RestController
class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
  private final UserRepository repository;

  UserController(UserRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/users")
  Iterable<User> all() {
    log.info("/Users Running");
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/users")
  User newEmployee(@RequestBody User newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item

  @GetMapping("/users/{id}")
  User one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/users/{id}")
  User replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {

    return repository.findById(id)
      .map(user -> {
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        return repository.save(user);
      })
      .orElseGet(() -> {
        newUser.setId(id);
        return repository.save(newUser);
      });
  }

  @DeleteMapping("/users/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}