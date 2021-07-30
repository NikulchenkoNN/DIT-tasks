package ru.nick.Task1.task3;

import ru.nick.Task1.model.Person;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'exit' to break");
        while (true) {
            System.out.println("Enter first name");
            String firstName = scanner.next();
            if (firstName.equals("exit")) {
                break;
            }
            System.out.println("Enter last name");
            String lastName = scanner.next();
            if (lastName.equals("exit")) {
                break;
            }
            Person person = new Person(firstName, lastName);
            System.out.println(person);
        }
        scanner.close();
    }
}