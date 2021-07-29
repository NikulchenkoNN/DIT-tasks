package Task2.task2;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFinder<T> {

    public boolean finder1(List<T> first, List<T> second) {
        if (first.isEmpty() || second.isEmpty()) {
            return false;
        }
        List<T> result = new ArrayList<>();
        for (T elem : first) {
            if (second.contains(elem)) {
                result.add(elem);
            }
        }
        return result.size() != 0;
    }

    public boolean finder2(List<T> first, List<T> second) {
        if (first.isEmpty() || second.isEmpty()) {
            return false;
        }
        List<T> result = new ArrayList<>();
        for (T elem1 : first) {
            for (T elem2 : second) {
                if (elem1.equals(elem2)) {
                    result.add(elem1);
                }
            }
        }
        return result.size() != 0;
    }

    public boolean finder3(List<T> first, List<T> second) {
        if (first.isEmpty() || second.isEmpty()) {
            return false;
        }
        return first.stream().anyMatch(second::contains);
    }

}