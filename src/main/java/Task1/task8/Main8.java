package Task1.task8;

import Task1.model.Person;
import Task1.util.CompareByLastName;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main8 {

    private interface Exec {
        void exec(List<Person> persons) throws Exception;
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

        public Menu(Scanner scanner) {
            this.scanner = scanner;
        }

        public void createItems() {
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
                try (FileOutputStream fos = new FileOutputStream(file, true);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    for (Person p : personList) {
                        oos.writeObject(p);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));

            items.add(new MenuItem("read", personList -> {
                System.out.println("Enter file path to read");
                String filePath = scanner.next();
                try (FileInputStream fis = new FileInputStream(filePath);
                     ObjectInputStream ois = new ObjectInputStream(fis)) {
                    personList = (List<Person>) ois.readObject();
                    personList.forEach(System.out::println);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));

            items.add(new MenuItem("clear", personList -> {
                personList.clear();
                System.out.println("Data cleared");
            }));
        }

        public void getItem(List<Person> persons) throws Exception {
            boolean flag = true;
            while (flag) {
                System.out.println("Menu:");
                System.out.println("1.Add");
                System.out.println("2.Show");
                System.out.println("3.Show sorted unique");
                System.out.println("4.Save to file");
                System.out.println("5.Read from file");
                System.out.println("6.Clear data");
                System.out.println("7.Exit");

                switch (scanner.next()) {
                    case "1":
                        items.get(0).exec.exec(persons);
                        break;

                    case "2":
                        items.get(1).exec.exec(persons);
                        break;

                    case "3":
                        items.get(2).exec.exec(persons);
                        break;

                    case "4":
                        items.get(3).exec.exec(persons);
                        break;

                    case "5":
                        items.get(4).exec.exec(persons);
                        break;

                    case "6":
                        items.get(5).exec.exec(persons);
                        break;

                    case "7":
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
        menu.createItems();
        try {
            menu.getItem(personList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}