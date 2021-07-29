package Task1.task4;

import Task1.model.Person;
import Task1.util.CompareByLastName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
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
            persons.add(person);
        }
        scanner.close();
        persons.forEach(System.out::println);
        if (!persons.isEmpty()) {
            persons.stream().sorted(new CompareByLastName()).forEach(System.out::println);
        }
    }
}