package com.nabila.sideproject.todo.server.respository;

import com.nabila.sideproject.todo.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
