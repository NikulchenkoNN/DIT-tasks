package ru.nick.Task5.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nick.Task5.entity.Box;
import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.repo.BoxRepo;
import ru.nick.Task5.service.api.IntBoxService;
import ru.nick.Task5.service.exceptions.ServiceException;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService implements IntBoxService {
    private final BoxRepo boxRepo;

    public BoxService(BoxRepo boxRepo) {
        this.boxRepo = boxRepo;
    }

    @Override
    public Box create(Box box) {
        return boxRepo.save(box);
    }

    @Override
    public Box getById(Long id) {
        return boxRepo.findById(id).get();
    }

    @Override
    @Transactional
    public Box update(Box box) throws ServiceException {
        Optional<Box> optionalBox = boxRepo.findById(box.getId());
        if (!optionalBox.isPresent()) {
            throw new ServiceException("Entity not found");
        }
        Box boxDb = optionalBox.get();
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
        Box boxDb = boxRepo.findById(boxId).get();
        boxDb.setDoc(doc);
        return boxRepo.save(boxDb);
    }

    @Override
    public Doc getDocFromBox(Long boxId, Long docId) {
        Box box = boxRepo.findById(boxId).get();
        List<Doc> docs = box.getDocList();
        for (Doc d : docs) {
            if (d.getId().equals(docId)) {
                return d;
            }
        }
        return null;
    }
}