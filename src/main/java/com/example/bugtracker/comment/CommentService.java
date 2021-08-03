package com.example.bugtracker.comment;

import com.example.bugtracker.exception.TicketNotFoundException;
import com.example.bugtracker.project.Project;
import com.example.bugtracker.ticket.Ticket;
import com.example.bugtracker.ticket.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment addComment(Comment comment) {

        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }


    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public void deleteComment(Long id) {
        commentRepository.deleteCommentById(id);
    }

    }


