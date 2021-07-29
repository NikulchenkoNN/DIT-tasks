package Task1.task5;

import Task1.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("Menu:");
            System.out.println("1.Add");
            System.out.println("2.Show");
            System.out.println("3.Exit");

            int res = scanner.nextInt();

            switch (res) {
                case (1):
                    System.out.println("Enter first name");
                    String firstName = scanner.next();

                    System.out.println("Enter last name");
                    String lastName = scanner.next();

                    Person person = new Person(firstName, lastName);
                    persons.add(person);
                    break;

                case (2):
                    if (!persons.isEmpty()) {
                        persons.forEach(System.out::println);
                    } else {
                        System.out.println("Persons list is empty");
                    }
                    break;

                case (3):
                    flag = false;
                    break;
            }
            System.out.println("--------");
        }
    }
}