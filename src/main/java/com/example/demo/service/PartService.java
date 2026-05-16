package com.example.demo.service;

import com.example.demo.model.Part;
import com.example.demo.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    // Létrehozás
    public Part savePart(Part part) {
        return partRepository.save(part);
    }

    // Olvasás
    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    //
    public Part updatePart(Long id, Part partDetails) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Part not found with id: " + id));

        if (partDetails.getBrand() != null) part.setBrand(partDetails.getBrand());
        if (partDetails.getModelName() != null) part.setModelName(partDetails.getModelName());
        if (partDetails.getPrice() != null) part.setPrice(partDetails.getPrice());

        return partRepository.save(part);
    }

    // Törlés
    public void deletePart(Long id) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Part not found with id: " + id));
        partRepository.delete(part);
    }
}