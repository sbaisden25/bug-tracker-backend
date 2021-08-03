package com.example.bugtracker.project;

import com.example.bugtracker.appuser.AppUser;
import com.example.bugtracker.ticket.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Project {

    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "project_sequence"
    )
    private Long id;

    @OneToMany
    private List<Ticket> tickets;

    private String projectTitle;
    private String projectDescription;
    private String projectStatus;

    private Instant createdDate;

}
