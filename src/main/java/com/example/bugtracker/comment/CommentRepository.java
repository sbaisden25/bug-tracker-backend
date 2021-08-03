package com.example.bugtracker.comment;

import com.example.bugtracker.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bugtracker.appuser.AppUser;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTicket(Ticket ticket);

    List<Comment> findAllByUser(AppUser user);

    void deleteCommentById(Long id);

}