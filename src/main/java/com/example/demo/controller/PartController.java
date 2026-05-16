package com.example.demo.controller;

import com.example.demo.model.Part;
import com.example.demo.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class PartController {

    @Autowired
    private PartService partService;

    @PostMapping
    public Part createPart(@RequestBody Part part) {
        return partService.savePart(part);
    }

    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@PathVariable Long id, @RequestBody Part partDetails) {
        return ResponseEntity.ok(partService.updatePart(id, partDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePart(@PathVariable Long id) {
        partService.deletePart(id);
        return ResponseEntity.ok("Part deleted successfully!");
    }
}