package Task5.service.boxservice;

import Task5.model.Box;
import Task5.model.Doc;
import Task5.repo.BoxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    BoxRepo boxRepo;

    public <S extends Box> S save(S entity) {
        return boxRepo.save(entity);
    }

    public Optional<Box> findById(Long id) {
        return boxRepo.findById(id);
    }

    public List<Doc> findAllById(Long id) {
        Box box = boxRepo.findById(id).get();
        return box.getDocList();
    }

    public <S extends Box> S update(Long id, String name, Long code) {
        Box box = findById(id).get();
        box.setName(name);
        box.setCode(code);
        return (S) boxRepo.save(box);
    }

    public void addDoc(Long id, Doc doc) {
        Box box = findById(id).get();
        box.getDocList().add(doc);
        boxRepo.save(box);
    }

    public Doc getDoc(Long boxId, Long docId) {
        Doc doc = null;
        Box box = findById(boxId).get();
        List<Doc> docList = box.getDocList();
        for (Doc d : docList) {
            if (d.getId().equals(docId)) {
                doc = d;
            }
        }
        return doc;
    }
}