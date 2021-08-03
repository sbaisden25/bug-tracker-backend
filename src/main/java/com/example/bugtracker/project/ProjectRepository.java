package com.example.bugtracker.project;

import com.example.bugtracker.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    void deleteProjectById(Long id);

    Optional<Project> findProjectById(Long id);

}
