package Task2.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateFinder<T> {
    public List<T> finder1(List<T> first, List<T> second) {
        List<T> result = new ArrayList<>();
        for (T elem : first) {
            if (second.contains(elem)) {
                result.add(elem);
            }
        }
        return result;
    }

    public List<T> finder2(List<T> first, List<T> second) {
        List<T> result = new ArrayList<>();
        for (T elem1 : first) {
            for (T elem2 : second) {
                if (elem1.equals(elem2)) {
                    result.add(elem1);
                }
            }
        }
        return result;
    }

    public List<T> finder3(List<T> first, List<T> second) {
        return first.stream().filter(second::contains).collect(Collectors.toList());
    }
}