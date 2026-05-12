package com.example.demo.controller;

import com.example.demo.model.Part;
import com.example.demo.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
@RequiredArgsConstructor
public class PartController {

    private final PartService partService;

    @GetMapping
    public List<Part> getAll() {
        return partService.getAllParts();
    }

    @GetMapping("/{id}")
    public Part getById(@PathVariable Long id) {
        return partService.getAllParts().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Part create(@RequestBody Part part) {
        return partService.savePart(part);
    }

    @PutMapping("/{id}")
    public Part update(@PathVariable Long id, @RequestBody Part part) {
        return partService.updatePart(id, part);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partService.deletePart(id);
    }
}