package tasks.task1;

import model.Person;

public class Main1 {
    public static void main(String[] args) {
        if (args.length ==2) {
            Person person = new Person(args[0], args[1]);
            System.out.println(person);
        } else {
            System.out.println("Need only 2 parameters");
        }
    }
}