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
    public List<Part> getParts() {
        return partService.getAllParts();
    }

    @PostMapping
    public Part addPart(@RequestBody Part part) {
        return partService.savePart(part);
    }

    @DeleteMapping("/{id}")
    public void removePart(@PathVariable Long id) {
        partService.deletePart(id);
    }
}
