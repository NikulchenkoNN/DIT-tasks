package Task2.task1;


import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayIteratorTest {

    @Test
    public void hasNextPositive() {
        Integer[][] matrix = {{1}};
        Iterator<Integer> iterator = new CustomArrayIterator<>(matrix);
        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void hasNextNegative() {
        Integer[][] matrix = new Integer[0][];
        Iterator<Integer> iterator = new CustomArrayIterator<>(matrix);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void nextTestPositive() {
        Integer[][] matrix = {{1, 2, 3}, {}, {4, 5}, {6},{}, {7,8,9,10}};
        Iterator<Integer> iterator = new CustomArrayIterator<>(matrix);
        int count = 0;
        while (count < 10) {
            count++;
            iterator.next();
        }
        Assert.assertEquals(10, count);
    }

    @Test(expected = NoSuchElementException.class)
    public void nextTestNegative() {
        Integer[][] matrix = {{1, 2, 3}, {}, {4, 5}, {6},{}};
        Iterator<Integer> iterator = new CustomArrayIterator<>(matrix);
        while (true) {
            iterator.next();
        }
    }

    @Test
    public void resultTrue() {
        StringBuilder actual = new StringBuilder();
        Integer[][] matrix = {{1, 2, 3}, {}, {4, 5}, {6}};
        Iterator<Integer> iterator = new CustomArrayIterator<>(matrix);
        while (iterator.hasNext()) {
            actual.append(iterator.next());
        }
        Assert.assertEquals("123456", actual.toString());
    }
}