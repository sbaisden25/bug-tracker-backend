package com.example.bugtracker.ticket;

import com.example.bugtracker.comment.Comment;
import com.example.bugtracker.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    void deleteTicketById(Long id);

    Optional<Ticket> findTicketById(Long id);

    List<Ticket> findByProject(Project project);
}
