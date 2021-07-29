package Task5.repo;

import Task5.model.Box;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoxRepo extends CrudRepository<Box, Long> {
}
