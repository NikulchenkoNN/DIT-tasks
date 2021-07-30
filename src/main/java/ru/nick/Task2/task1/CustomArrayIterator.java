package ru.nick.Task2.task1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayIterator<T> implements Iterator<T> {

    private final int size;
    private int position = 0;
    private int row = 0;
    private int col = 0;
    private final T[][] matrix;

    public CustomArrayIterator(T[][] matrix) {
        this.size = countElems(matrix);
        this.matrix = matrix;
    }

    private int countElems(T[][] matrix) {
        int count = 0;
        for (T[] row :
                matrix) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
        if (position >= size) {
            throw new NoSuchElementException();
        }
        T elem = matrix[row][col];
        position++;
        col++;
        while (row < matrix.length && col >= matrix[row].length) {
            col = 0;
            row++;
        }
        return elem;
    }
}
