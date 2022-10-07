package com.tekupminiproject.TekupMiniProject.loaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tekupminiproject.TekupMiniProject.respositories.UserRepository;
import com.tekupminiproject.TekupMiniProject.entities.User;


@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
    //   log.info("Preloading " + repository.save(new User("Bilbo Baggins", "burglar")));
    //   log.info("Preloading " + repository.save(new User("Frodo Baggins", "thief")));
    log.info("Preloading ");
    };
  }
}