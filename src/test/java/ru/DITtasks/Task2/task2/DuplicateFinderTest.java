package ru.DITtasks.Task2.task2;

import org.junit.Assert;
import org.junit.Test;
import ru.nick.Task2.task2.DuplicateFinder;

import java.util.ArrayList;
import java.util.List;

public class DuplicateFinderTest {

    DuplicateFinder<Integer> duplicateFinder = new DuplicateFinder<>();
    List<Integer> frist = new ArrayList<>();
    List<Integer> sec = new ArrayList<>();

    @Test
    public void finder1TestPositive() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(17);
        sec.add(6);
        sec.add(5);
        sec.add(4);

        Assert.assertTrue(duplicateFinder.finder1(frist, sec));
    }

    @Test
    public void finder2TestPositive() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(17);
        sec.add(6);
        sec.add(5);
        sec.add(4);

        Assert.assertTrue(duplicateFinder.finder2(frist, sec));
    }

    @Test
    public void finder3TestPositive() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(3);
        sec.add(92);
        sec.add(2);
        sec.add(65);

        Assert.assertTrue(duplicateFinder.finder3(frist, sec));
    }

    @Test
    public void finder1TestNegative() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(5);
        sec.add(6);
        sec.add(7);
        sec.add(8);

        Assert.assertFalse(duplicateFinder.finder1(frist, sec));
    }

    @Test
    public void finder2TestNegative() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(5);
        sec.add(6);
        sec.add(7);
        sec.add(8);

        Assert.assertFalse(duplicateFinder.finder2(frist, sec));
    }

    @Test
    public void finder3TestNegative() {
        frist.add(1);
        frist.add(2);
        frist.add(3);
        frist.add(4);

        sec.add(5);
        sec.add(6);
        sec.add(7);
        sec.add(8);

        Assert.assertFalse(duplicateFinder.finder3(frist, sec));
    }

    @Test
//    Тест на пустые коллекции
    public void finder1TestEmpty() {
        Assert.assertFalse(duplicateFinder.finder1(frist, sec));

        sec.add(5);
        sec.add(6);
        Assert.assertFalse(duplicateFinder.finder1(frist, sec));


        sec.clear();
        frist.add(2);
        frist.add(3);
        Assert.assertFalse(duplicateFinder.finder1(frist, sec));
    }

    @Test
//    Тест на пустые коллекции
    public void finder2TestEmpty() {
        Assert.assertFalse(duplicateFinder.finder2(frist, sec));

        sec.add(5);
        sec.add(6);
        Assert.assertFalse(duplicateFinder.finder2(frist, sec));

        sec.clear();
        frist.add(2);
        frist.add(3);
        Assert.assertFalse(duplicateFinder.finder2(frist, sec));
    }

    @Test
//    Тест на пустые коллекции
    public void finder3TestEmpty() {
        Assert.assertFalse(duplicateFinder.finder3(frist, sec));

        sec.add(5);
        sec.add(6);
        Assert.assertFalse(duplicateFinder.finder3(frist, sec));

        sec.clear();
        frist.add(2);
        frist.add(3);
        Assert.assertFalse(duplicateFinder.finder3(frist, sec));
    }
}