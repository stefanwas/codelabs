package com.stefan.training.hibernate.lab1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="user") // optional if entity name == table name

public class User implements Serializable {
  /**
   * Serializable interface is necessary to be able to use hibernate Session CRUD methods.
   */

  private String id;
  private String name;
  private String password;

  public User() {
  }

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public User(String id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  @Id
  @Column(name="user_id", unique=true, nullable=false) // optional if field name == column name
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
