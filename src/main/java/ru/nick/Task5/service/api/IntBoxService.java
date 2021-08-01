package ru.nick.Task5.service.api;

import ru.nick.Task5.entity.Box;
import ru.nick.Task5.entity.Doc;
import ru.nick.Task5.service.exceptions.ServiceException;

import java.util.List;

public interface IntBoxService {
    Box create(Box box);
    Box getById(Long id);
    Box update(Box box) throws ServiceException;
    List<Box> getAll();
    Box addDoc(Long boxId, Doc doc);
    Doc getDocFromBox(Long boxId, Long docId);
}
