package ru.nick.Task5.service.api;

import ru.nick.Task5.entity.Doc;

import java.util.List;

public interface IntDocService {
    Doc create(Doc doc);
    Doc getById(Long id);
    Doc update(Doc doc);
    List<Doc> getAll();
}
