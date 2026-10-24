package com.haponenka.app;

import com.haponenka.app.repository.UserRepository;
import com.haponenka.app.repository.impl.InMemoryUserRepository;
import com.haponenka.app.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {

  private static final Logger LOGGER = LogManager.getLogger(Application.class);

  public static void main(String[] args) {
    UserRepository userRepository = new InMemoryUserRepository();
    UserService userService = new UserService(userRepository);

    Long yarikId = userService.createUser("Yarik");

    userService.deactivateUser(yarikId);
    printUserStatus(userService, yarikId);

    userService.activateUser(yarikId);
    printUserStatus(userService, yarikId);

    userService.removeUser(yarikId);
    printUserStatus(userService, yarikId);
  }

  private static void printUserStatus(UserService userService, Long userId) {
    userService.getUser(userId).ifPresentOrElse(
            user -> LOGGER.info("Пользователь найден: {}", user),
            () -> LOGGER.warn("Пользователь с ID {} не найден", userId)
    );
  }
}