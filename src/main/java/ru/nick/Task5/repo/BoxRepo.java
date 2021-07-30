package ru.nick.Task5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nick.Task5.entity.Box;

public interface BoxRepo extends JpaRepository<Box, Long> {
}
