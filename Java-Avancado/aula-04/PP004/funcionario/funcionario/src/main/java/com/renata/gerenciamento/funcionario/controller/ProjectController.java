package com.renata.gerenciamento.funcionario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @PostMapping("/createProject")
    public ResponseEntity<String> createProject() {
       
        return ResponseEntity.ok("Novo projeto criado!");
    }

    @PostMapping("/createProjectForEmployees")
    public ResponseEntity<String> createProjectForEmployees() {
      
        return ResponseEntity.ok("Novo projeto criado e funcionários atribuídos!");
    }

    @GetMapping("/getProject/{projectId}")
    public ResponseEntity<String> getProject(@PathVariable Long projectId) {
     
        return ResponseEntity.ok("Detalhes do projeto com ID " + projectId);
    }
}
