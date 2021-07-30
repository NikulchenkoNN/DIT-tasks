package ru.nick.Task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nick.Task5.entity.Doc;

public interface DocRepo extends JpaRepository<Doc, Long> {
}
