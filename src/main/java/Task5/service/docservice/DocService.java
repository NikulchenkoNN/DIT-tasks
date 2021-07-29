package Task5.service.docservice;

import Task5.model.Box;
import Task5.model.Doc;
import Task5.repo.DocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocService {

    @Autowired
    DocRepo docRepo;

    public <S extends Doc> S save(S entity) {
        return docRepo.save(entity);
    }

    public Optional<Doc>  findById(Long id) {
        return docRepo.findById(id);
    }

    public void update(Long id, String name, Long code) {
        Optional<Doc> entity = docRepo.findById(id);
        Doc doc = null;
        if (entity.isPresent()) {
            doc = entity.get();
            if (name != null) {
                doc.setName(name);
            }
            if (code != null) {
                doc.setCode(code);
            }
        }
        assert doc != null;
        docRepo.save(doc);
    }
}
