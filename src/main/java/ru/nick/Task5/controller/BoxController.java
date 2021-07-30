package ru.nick.Task5.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nick.Task5.entity.Box;
import ru.nick.Task5.service.api.IntBox;

import java.util.List;

@RestController
@RequestMapping("/boxes")
public class BoxController {
    private final IntBox boxService;

    @Autowired
    public BoxController(IntBox boxService) {
        this.boxService = boxService;
    }

    @GetMapping
    public ResponseEntity<List<Box>> getAllBoxes() {
        return ResponseEntity.ok(boxService.getAll());
    }

    @PostMapping
    public ResponseEntity<Box> createBox(@RequestBody Box box) {
        Box boxToSave = boxService.crate(box);
        return ResponseEntity.ok(boxToSave);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Box> getBox(@PathVariable Long id)  {
        Box box = boxService.getById(id);
        Box boxShow = new Box();
        boxShow.setId(box.getId());
        boxShow.setName(box.getName());
        boxShow.setBarcode(box.getBarcode());
        return ResponseEntity.ok(boxShow);
    }

    @PutMapping
    public ResponseEntity<Box> updateBox(@RequestBody Box box) {
        Box boxUpdate = boxService.update(box);
        return ResponseEntity.ok(boxUpdate);
    }
}
