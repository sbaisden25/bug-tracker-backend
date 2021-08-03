package com.example.bugtracker.ticket;

import com.example.bugtracker.appuser.AppUser;
import com.example.bugtracker.comment.Comment;
import com.example.bugtracker.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @SequenceGenerator(
            name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "ticket_sequence"
    )
    private Long id;

    private String ticketTitle;
    private String ticketDescription;

    private Boolean isOpen = true;

    public enum ticketType {
        Bug, Error, FeatureRequest, OtherComment, TrainingOrDocumentRequest
    }

    public enum ticketPriority {
        Low, Medium, High, Critical
    }

    @OneToOne
    private Comment ticketComment;

    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser assignedDev;

    @OneToOne
    private AppUser submitter;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime lastUpdated;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", insertable=false, updatable=false)
    private Project project;


}
