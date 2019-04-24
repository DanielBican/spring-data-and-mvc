package com.example.demo.data;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

  private final UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/users")
  public List<User> users() {
    return (List<User>) repository.findAll();
  }

  @PostMapping("/users")
  User newUser(@RequestBody User newUser) {
    return repository.save(newUser);
  }

  @GetMapping("/users/{id}")
  public User user(@PathVariable long id) {
    return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @PutMapping("/users/{id}")
  User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

    return repository
        .findById(id)
        .map(
            user -> {
              user.setFirstName(newUser.getFirstName());
              user.setLastName(newUser.getLastName());
              return repository.save(user);
            })
        .orElseGet(
            () -> {
              newUser.setId(id);
              return repository.save(newUser);
            });
  }

  @DeleteMapping("/users/{id}")
  void deleteUsers(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
