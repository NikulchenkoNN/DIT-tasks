package ru.nick.Task5.service;


import org.springframework.stereotype.Service;
import ru.nick.Task5.entity.Box;
import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.repo.BoxRepo;
import ru.nick.Task5.service.api.IntBoxService;

import java.util.List;

@Service
public class BoxServiceService implements IntBoxService {
    private final BoxRepo boxRepo;

    public BoxServiceService(BoxRepo boxRepo) {
        this.boxRepo = boxRepo;
    }

    @Override
    public Box create(Box box) {
        return boxRepo.save(box);
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