package ru.nick.Task5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.service.api.IntDocService;

import java.util.List;

@RestController
@RequestMapping("/docs")
public class DocController {
    private final IntDocService docService;

    @Autowired
    public DocController(IntDocService docService) {
        this.docService = docService;
    }

    @GetMapping
    public ResponseEntity<List<Doc>> getAllDocs() {
        return ResponseEntity.ok(docService.getAll());
    }

    @PostMapping("/create/{boxId}")
    public ResponseEntity<Doc> createDoc(@RequestBody Doc doc, @PathVariable Long boxId) {
        return ResponseEntity.ok(docService.create(doc, boxId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doc> getDoc(@PathVariable Long id) {
        return ResponseEntity.ok(docService.getById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Doc> updateDoc(@RequestBody Doc doc) {
        return ResponseEntity.ok(docService.update(doc));
    }
}
