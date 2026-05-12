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
        Part part = new Part();
        part.setBrand("MSI");
        part.setModelName("RTX 4060");
        part.setPrice(120000);

        Part saved = partService.savePart(part);
        assertNotNull(saved.getId());
        assertEquals("MSI", saved.getBrand());

        List<Part> parts = partService.getAllParts();
        assertFalse(parts.isEmpty());

        Part details = new Part();
        details.setPrice(110000);
        Part updated = partService.updatePart(saved.getId(), details);
        assertEquals(110000, updated.getPrice());

        partService.deletePart(saved.getId());
        assertTrue(partService.getAllParts().isEmpty());
    }
}