package ru.nick.Task5.service;


import org.springframework.stereotype.Service;
import ru.nick.Task5.entity.Box;
import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.repo.BoxRepo;
import ru.nick.Task5.service.api.IntBoxService;
import ru.nick.Task5.service.api.IntDocService;

import java.util.List;

@Service
public class BoxService implements IntBoxService {
    private final BoxRepo boxRepo;
    private final IntDocService docService;

    public BoxService(BoxRepo boxRepo, IntDocService docService) {
        this.boxRepo = boxRepo;
        this.docService = docService;
    }

    @Override
    public Box create(Box box) {
        if (box.getDocList() != null) {
            Box boxDb = boxRepo.save(box);
            box.getDocList().forEach(doc -> {
                docService.create(doc, boxDb.getId());
            });
            return boxRepo.save(boxDb);
        } else {
            return boxRepo.save(box);
        }
    }

    @Override
    public Box getById(Long id) {
        return boxRepo.getById(id);
    }

    @Override
    public Box update(Box box) {
        Box boxDb = boxRepo.getById(box.getId());
        if (box.getName() != null)
            boxDb.setName(box.getName());
        if (box.getBarcode() != null)
            boxDb.setBarcode(box.getBarcode());
        if (!box.getDocList().isEmpty()) {
            box.getDocList().forEach(boxDb::setDoc);
        }
        return boxRepo.save(boxDb);
    }

    @Override
    public List<Box> getAll() {
        return boxRepo.findAll();
    }

    @Override
    public Box addDoc(Long boxId, Doc doc) {
        Box boxDb = boxRepo.getById(boxId);
        boxDb.setDoc(doc);
        return boxRepo.save(boxDb);
    }

    @Override
    public Doc getFromBox(Long boxId, Long docId) {
        Box box = boxRepo.getById(boxId);
        List<Doc> docs = box.getDocList();
        for (Doc d : docs) {
            if (d.getId().equals(docId)) {
                return d;
            }
        }
        return null;
    }
}