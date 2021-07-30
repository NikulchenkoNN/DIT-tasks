package ru.nick.Task5.service.api;

import ru.nick.Task5.entity.Box;
import ru.nick.Task5.entity.Doc;

import java.util.List;

public interface IntBox {
    Box crate(Box box);
    Box getById(Long id);
    Box update(Box box);
    List<Box> getAll();
    Box addDoc(Long boxId, Doc doc);
    Doc getFromBox(Long boxId, Long docId);
}
