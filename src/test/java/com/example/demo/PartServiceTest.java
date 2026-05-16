package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.model.Part;
import com.example.demo.service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class PartServiceTest {

    @Autowired
    private PartService partService;

    @Test
    void testPartWorkflow() {
        // 1. CREATE
        Part part = new Part();
        part.setBrand("Intel");
        part.setModelName("i7-14700K");
        part.setPrice(160000.0);

        Part saved = partService.savePart(part);
        assertNotNull(saved.getId());
        assertEquals("Intel", saved.getBrand());

        // 2. READ
        List<Part> parts = partService.getAllParts();
        assertFalse(parts.isEmpty());

        // 3. UPDATE
        Part details = new Part();
        details.setPrice(155000.0);
        Part updated = partService.updatePart(saved.getId(), details);
        assertEquals(155000.0, updated.getPrice());

        // 4. DELETE
        partService.deletePart(saved.getId());
        boolean exists = partService.getAllParts().stream()
                .anyMatch(p -> p.getId().equals(saved.getId()));
        assertFalse(exists);
    }

    @Test
    void testUpdatePartNotFoundThrowsException() {
        assertThrows(RuntimeException.class, () -> {
            partService.updatePart(-1L, new Part());
        });
    }

    @Test
    void testDeletePartNotFoundThrowsException() {
        assertThrows(RuntimeException.class, () -> {
            partService.deletePart(-1L);
        });
    }
}