package Task2.task2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateFinder<T> {

    public boolean finder1(List<T> first, List<T> second) {
        List<T> res = new ArrayList<>();
        if (first.isEmpty() || second.isEmpty()) {
            return false;
        }
        for (T elem : first) {
            if (second.contains(elem)) {
                res.add(elem);
            }
        }
        return res.size() != 0;
    }

    public boolean finder2(List<T> first, List<T> second) {
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
        return !first.stream().noneMatch(second::contains);
    }

}