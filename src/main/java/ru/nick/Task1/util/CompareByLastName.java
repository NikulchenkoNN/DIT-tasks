package ru.nick.Task1.util;

import ru.nick.Task1.model.Person;

import java.util.Comparator;

public class CompareByLastName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getLastName().compareTo(p2.getLastName());
    }
}
