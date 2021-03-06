package ru.nick.Task1.task7;

import ru.nick.Task1.model.Person;
import ru.nick.Task1.util.CompareByLastName;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main7 {

    private interface Exec {
        void exec(List<Person> personList) throws Exception;
    }

    private static class MenuItem {
        private String name;
        private Exec exec;

        public MenuItem(String name, Exec exec) {
            this.name = name;
            this.exec = exec;
        }
    }

    private static class Menu {
        private Scanner scanner;
        private List<MenuItem> items = new ArrayList<>();
        {
            items.add(new MenuItem("add", personList -> {
                System.out.println("Enter first name");
                String firstName = scanner.next();

                System.out.println("Enter last name");
                String lastName = scanner.next();

                Person person = new Person(firstName, lastName);
                personList.add(person);
            }));

            items.add(new MenuItem("show", personList -> {
                if (!personList.isEmpty()) {
                    personList.forEach(System.out::println);
                } else {
                    System.out.println("Persons list is empty");
                }
            }));

            items.add(new MenuItem("sort", personList -> {
                if (!personList.isEmpty()) {
                    List<Person> sorted = new ArrayList<>(personList);
                    sorted.sort(new CompareByLastName());
                    HashSet<Person> personHashSet = new HashSet<>(sorted);
                    personHashSet.forEach(System.out::println);
                } else {
                    System.out.println("Persons list is empty");
                }
            }));

            items.add(new MenuItem("save", personList -> {
                System.out.println("Enter file path to save");
                String filePath = scanner.next();
                File file = new File(filePath);
                try (FileOutputStream fos = new FileOutputStream(file, true)) {
                    for (Person p : personList) {
                        fos.write(p.toString().getBytes(StandardCharsets.UTF_8));
                        fos.write('\n');
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        }

        public Menu(Scanner scanner) {
            this.scanner = scanner;
        }

        public void getItem(List<Person> personList) throws Exception {
            boolean flag = true;
            while (flag) {
                System.out.println("Menu:");
                System.out.println("1.Add");
                System.out.println("2.Show");
                System.out.println("3.Show sorted unique");
                System.out.println("4.Save to file");
                System.out.println("5.Exit");

                switch (scanner.next()) {
                    case "1":
                        items.get(0).exec.exec(personList);
                        break;

                    case "2":
                        items.get(1).exec.exec(personList);
                        break;

                    case "3":
                        items.get(2).exec.exec(personList);
                        break;

                    case "4":
                        items.get(3).exec.exec(personList);
                        break;

                    case "5":
                        flag = false;
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        try {
            menu.getItem(personList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}