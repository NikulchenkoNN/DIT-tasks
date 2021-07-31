package ru.nick.Task5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nick.Task5.entity.Box;
import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.repo.BoxRepo;
import ru.nick.Task5.repo.DocRepo;
import ru.nick.Task5.service.api.IntDocService;

import java.util.List;

@Service
public class DocService implements IntDocService {

    private final DocRepo docRepo;
    private final BoxRepo boxRepo;

    @Autowired
    public DocService(DocRepo docRepo, BoxRepo boxRepo) {
        this.docRepo = docRepo;
        this.boxRepo = boxRepo;
    }

    @Override
    public Doc create(Doc doc, Long boxId) {
        Box boxDb = boxRepo.getById(boxId);
        boxDb.setDoc(doc);
        boxRepo.save(boxDb);
        return docRepo.save(doc);
    }

    @Override
    public Doc getById(Long id) {
        return docRepo.getById(id);
    }

    @Override
    public Doc update(Doc doc) {
        Doc docDb = docRepo.getById(doc.getId());
        docDb.setName(doc.getName());
        docDb.setBarcode(doc.getBarcode());
        return docRepo.save(docDb);
    }

    @Override
    public List<Doc> getAll() {
        return docRepo.findAll();
    }
}
