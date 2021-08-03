package com.example.bugtracker.project;

import com.example.bugtracker.exception.ProjectNotFoundException;
import com.example.bugtracker.exception.TicketNotFoundException;
import com.example.bugtracker.ticket.Ticket;
import com.example.bugtracker.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        // Logic
        return projectRepository.save(project);
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteProjectById(id);
    }

    public Project findProjectById(Long id) {
        return projectRepository.findProjectById(id)
                .orElseThrow(() ->
                        new TicketNotFoundException("Project by id " + id + " was not found"));
    }

}