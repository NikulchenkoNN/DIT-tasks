package ru.nick.Task1.task2;

import ru.nick.Task1.model.Person;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name");
        String firstName = scanner.next();
        System.out.println("Enter last name");
        String lastName = scanner.next();
        Person person = new Person(firstName, lastName);
        System.out.println(person);
    }
}