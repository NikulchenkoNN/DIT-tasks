package Task5.repo;

import Task5.model.Box;
import Task5.model.Doc;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocRepo extends CrudRepository<Doc, Long> {
}
