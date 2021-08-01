package ru.nick.Task5.service.api;

import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.service.exceptions.ServiceException;

import java.util.List;

public interface IntDocService {
    Doc create(Doc doc, Long boxId);
    Doc getById(Long id);
    Doc update(Doc doc) throws ServiceException;
    List<Doc> getAll();
}
