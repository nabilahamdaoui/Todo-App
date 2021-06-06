package com.nabila.sideproject.todo.server.respository;

import com.nabila.sideproject.todo.server.entity.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}
