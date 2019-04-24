package com.example.demo.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * UserRepository extends the CrudRepository interface. The type of entity and ID that it works
 * with,User and Long, are specified in the generic parameters on CrudRepository. By extending
 * CrudRepository, UserRepository inherits several methods for working with User persistence,
 * including methods for saving, deleting, and finding User entities.
 *
 * In a typical Java application, you’d expect to write a class that implements
 * UserRepository. But that’s what makes Spring Data JPA so powerful: You don’t have to write an
 * implementation of the repository interface. Spring Data JPA creates an implementation on the fly
 * when you run the application
 */
public interface UserRepository extends CrudRepository<User, Long> {

  /**
   * Spring Data JPA also allows you to define other query methods by simply declaring their method
   * signature. In the case of UserRepository, this is shown with a findByLastName() method.
   *
   * @param lastName
   * @return
   */
  List<User> findByLastName(String lastName);
}
