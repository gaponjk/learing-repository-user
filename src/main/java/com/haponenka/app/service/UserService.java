package com.haponenka.app.service;

import com.haponenka.app.exception.CustomUserNotFoundException;
import com.haponenka.app.model.User;
import com.haponenka.app.repository.UserRepository;

import java.util.Optional;

public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void deactivateUser(Long id) {
    User user =
        userRepository
            .findById(id)
            .orElseThrow(
                () -> new CustomUserNotFoundException("Пользователь с id " + id + " не найден"));
    user.deactivate();
    userRepository.save(user);
  }

    public void activateUser(Long id) {
        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new CustomUserNotFoundException("Пользователь с id " + id + " не найден"));
        user.activate();
        userRepository.save(user);
    }

  public Long createUser(String name){
      if(name==null || name.isBlank()){
          throw new IllegalArgumentException("Имя не может быть пустым");
      }
      User user=new User(name);
      userRepository.save(user);
      return user.getId();
  }
  public void removeUser(Long id){
      userRepository.deleteById(id);
  }
  public Optional<User> getUser(Long id){
      return userRepository.findById(id);
  }
}
