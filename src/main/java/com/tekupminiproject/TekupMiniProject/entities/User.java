package com.tekupminiproject.TekupMiniProject.entities;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;

    User() {}

    public User(String firstName, String lastName) {

      this.firstName = firstName;
      this.lastName = lastName;
    }


    public void setId(Long id) {
        this.id = id;
      }

      public void setFirstName(String firstName) {
        this.firstName = firstName;
      }

      public void setLastName(String lastName) {
        this.lastName = lastName;
      }

      public String getFirstName() {
        return this.firstName;
      }

      public String getLastName() {
        return this.lastName;
      }


}
