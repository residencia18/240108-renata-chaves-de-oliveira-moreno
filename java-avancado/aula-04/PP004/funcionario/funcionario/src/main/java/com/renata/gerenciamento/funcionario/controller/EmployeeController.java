package com.renata.gerenciamento.funcionario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @PostMapping("/createEmployeeForProject/{projectId}")
    public ResponseEntity<String> createEmployeeForProject(@PathVariable Long projectId) {
        
        return ResponseEntity.ok("Novo funcionário criado e atribuído ao projeto com ID " + projectId);
    }

    @PostMapping("/assignEmployeeToProject/{projectId}")
    public ResponseEntity<String> assignEmployeeToProject(@PathVariable Long projectId) {
      
        return ResponseEntity.ok("Funcionários atribuídos ao projeto com ID " + projectId);
    }

    @GetMapping("/getEmployee/{employeeId}")
    public ResponseEntity<String> getEmployee(@PathVariable Long employeeId) {
        
        return ResponseEntity.ok("Detalhes do funcionário com ID " + employeeId);
    }
}
