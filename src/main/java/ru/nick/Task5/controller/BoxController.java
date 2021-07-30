package ru.nick.Task5.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nick.Task5.entity.Box;
import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.service.api.IntBoxService;

import java.util.List;

@RestController
@RequestMapping("/boxes")
public class BoxController {
    private final IntBoxService boxService;

    @Autowired
    public BoxController(IntBoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping
    public ResponseEntity<List<Box>> getAllBoxes() {
        return ResponseEntity.ok(boxService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Box> createBox(@RequestBody Box box) {
        return ResponseEntity.ok(boxService.create(box));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Box> getBoxById(@PathVariable Long id) {
        return ResponseEntity.ok(boxService.getById(id));
    }

    @PutMapping("/update")
    public Box updateBox(@RequestBody Box box) {
        return boxService.update(box);
    }

    @PutMapping
    public ResponseEntity<Box> addDoc(Long boxId, Doc doc) {
        Box box = boxService.getById(boxId);
        box.setDoc(doc);
        Box boxToSave = boxService.create(box);
        return ResponseEntity.ok(boxToSave);
    }

    @GetMapping("/get/{boxId}/{docId}")
    public ResponseEntity<Doc> getDoc(@PathVariable Long boxId, @PathVariable Long docId) {
        return ResponseEntity.ok(boxService.getFromBox(boxId, docId));
    }
}
