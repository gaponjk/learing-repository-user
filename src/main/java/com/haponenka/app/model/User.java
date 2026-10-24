package com.haponenka.app.model;

import io.hypersistence.tsid.TSID;

import java.util.Objects;

public class User {
    private final Long id;
    private final String name;
    private boolean active;

    public User(String name) {
        this.name = name;
        active = true;
        id = TSID.fast().toLong();
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public void activate() {
        active = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return active == user.active && Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", active=" + active +
            '}';
  }
}
