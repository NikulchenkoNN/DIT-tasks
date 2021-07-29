package Task2.task2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFinderTest {

    DuplicateFinder<Integer> duplicateFinder = new DuplicateFinder<>();
    List<Integer> frist = new ArrayList<>();
    List<Integer> sec = new ArrayList<>();

    @Test
    public void finderTestPositive() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(17);
        sec.add(6);
        sec.add(5);
        sec.add(4);

        Assert.assertTrue(duplicateFinder.finder1(frist, sec));
        Assert.assertTrue(duplicateFinder.finder2(frist, sec));
        Assert.assertTrue(duplicateFinder.finder3(frist, sec));
    }

    @Test
    public void finderTestNegative() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(5);
        sec.add(6);
        sec.add(7);
        sec.add(8);

        Assert.assertFalse(duplicateFinder.finder1(frist, sec));
        Assert.assertFalse(duplicateFinder.finder2(frist, sec));
        Assert.assertFalse(duplicateFinder.finder3(frist, sec));
    }

    @Test
//    Тест на пустые коллекции
    public void finderTestEmpty() {
        Assert.assertFalse(duplicateFinder.finder1(frist, sec));
        Assert.assertFalse(duplicateFinder.finder2(frist, sec));
        Assert.assertFalse(duplicateFinder.finder3(frist, sec));

        sec.add(5);
        sec.add(6);
        Assert.assertFalse(duplicateFinder.finder1(frist, sec));
        Assert.assertFalse(duplicateFinder.finder2(frist, sec));
        Assert.assertFalse(duplicateFinder.finder3(frist, sec));

        sec.clear();
        frist.add(2);
        frist.add(3);
        Assert.assertFalse(duplicateFinder.finder1(frist, sec));
        Assert.assertFalse(duplicateFinder.finder2(frist, sec));
        Assert.assertFalse(duplicateFinder.finder3(frist, sec));
    }
}