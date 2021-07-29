package Task1.task6;

import Task1.model.Person;
import Task1.util.CompareByLastName;

import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("Menu:");
            System.out.println("1.Add");
            System.out.println("2.Show");
            System.out.println("3.Show sorted unique");
            System.out.println("4.Exit");

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
                    if (!persons.isEmpty()) {
                        List<Person> sorted = new ArrayList<>(persons);
                        sorted.sort(new CompareByLastName());
                        Set<Person> personHashSet = new TreeSet<>(sorted);
                        personHashSet.forEach(System.out::println);
                    } else {
                        System.out.println("Persons list is empty");
                    }
                    break;

                case (4):
                    flag = false;
                    break;
            }
            System.out.println("--------");
        }
    }
}