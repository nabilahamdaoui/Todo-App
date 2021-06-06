package com.nabila.sideproject.todo.server.respository;

import com.nabila.sideproject.todo.server.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
