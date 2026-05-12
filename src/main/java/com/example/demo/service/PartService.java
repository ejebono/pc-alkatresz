package com.example.demo.service;

import com.example.demo.model.Part;
import com.example.demo.repository.PartRepository;
import lombok.RequiredArgsConstructor; // <--- Ez fontos!
import org.springframework.stereotype.Service; // <--- Ez is!

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartService {

    private final PartRepository partRepository;

    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    public Part savePart(Part part) {
        return partRepository.save(part);
    }

    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }

    public Part updatePart(Long id, Part details) {
        Part part = partRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs ilyen alkatrész!"));

        part.setBrand(details.getBrand());
        part.setModelName(details.getModelName());
        part.setPrice(details.getPrice());

        return partRepository.save(part);
    }
}