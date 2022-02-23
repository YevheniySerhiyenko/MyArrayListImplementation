package main.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyArrayListImpl<T> implements MyArrayList<T> {
    private final int DEFAULT_SIZE = 10;
    private Object[] array;
    private int actualSize = 0;     // заполненность внутреннего массива

    // empty array
    private static final Object[] EMPTY_ELEMENTDATA = {};


    public MyArrayListImpl() {
        array = new Object[DEFAULT_SIZE];
    }

    // конструктор для задания размера
    public MyArrayListImpl(int capacity) {
        if (capacity > 0) {
            array = new Object[capacity];
        } else if (capacity == 0) {
            array = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    public MyArrayListImpl(Collection<? extends T> collection) {
        array = collection.toArray();
        if ((actualSize = array.length) != 0) {
            array = Arrays.copyOf(array, actualSize, Object[].class);
        } else {
            array = EMPTY_ELEMENTDATA;
        }
    }

    @Override
    public void add(Object o) {
        if (actualSize >= array.length / 2) { // если актуальный размер массива достиг размера половины изначального
            newSize();                        // увеличиваем массив в два раза
        }
        array[actualSize++] = o;
        trim();
    }

    //    метод для добавления объекта по индексу
    //    элементы сдвигаются вправо на одну позицию
    @Override
    public void add(Object o, int index) {
        System.arraycopy(array, index, array, index + 1, actualSize - index);
        array[index] = o;
        actualSize++;
    }

    // метод для склейки двух листов, возвращает новый лист
    @Override
    public MyArrayListImpl<? extends T> concat(MyArrayList<T> newList) {
        MyArrayListImpl<T> list = new MyArrayListImpl<>(actualSize + newList.size());
        Object[] o = newList.toArray();
        for (Object value : array) {
            list.add(value);
        }
        for (Object value : o) {
            list.add(value);
        }
        list.trim();
        return list;
    }

    @Override
    public T get(int index) {
        trim();
        T t = null;
        if (index < array.length) {
            t = (T) array[index];
        }
        return t;
    }

    @Override
    public int size() {
        return actualSize;
    }

    @Override
    public T[] toArray() {
        return (T[]) Arrays.copyOf(array, actualSize);
    }

    //метод возвращает коллекцию в обратном порядке
    @Override
    public MyArrayListImpl<? extends T> reverseList() {
        MyArrayListImpl<? extends T> list = new MyArrayListImpl<>();
        for (int i = array.length - 1; i >= 0; i--) {
            list.add(array[i]);
        }
        return list;
    }

    // приватный метод для увеличения массива
    private void newSize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    public void trim() {
        if (actualSize < array.length) {
            array = Arrays.copyOf(array, actualSize);
        }
    }
    // метод для перемешивания элементов коллекции в случайном порядке
    @Override
    public void shuffle() {
        Random random = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Simple swap
            int a = (int) array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }


    // возвращает коллекцию с элементами с позиции start до позиции end включительно
    @Override
    public MyArrayListImpl<T> subList(int start, int end) {
        if (start < 0 || end >= actualSize) {
            throw new IndexOutOfBoundsException("Incorrect start or end index");
        }

        MyArrayListImpl<T> list = new MyArrayListImpl<>();
        for (int i = start; i <= end; i++) {
            list.add(array[i]);
        }
        return list;
    }


    @Override
    public void removeIfContains(Object value) {
       array = Arrays.stream(array).filter(o -> !o.equals(value)).toArray();
       actualSize--;
    }

    @Override
    public int search(Object value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value) && array[i] != null)
                return i;
        }
        return -1;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort((T[]) array, 0, actualSize, comparator);
    }

    @Override
    public void clear() {
        for (int i = 0; i < actualSize; i++) {
            array[i] = null;
        }
        actualSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return actualSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Object item : array) {
                if (item == null) {
                    return true;
                }
            }
        } else {
            for (Object item : array) {
                if (item.equals(o)) {
                    return true;
                }
            }
        }
         return false;
    }

    @Override
    public int hashCode() {
        return actualSize;
    }

    @Override
    public void set(int index, Object element) {
        if (index >= actualSize) {
            throw new IndexOutOfBoundsException("Index more or equals array size");
        }
        array[index] = element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= actualSize) {
            return;
        }
        int k = 0;
        Object[] tempArr = new Object[array.length];
        for (int i = 0; i < actualSize; i++) {
            if (i == index) {
                continue;
            }
            tempArr[k++] = array[i];
        }
        array = tempArr;
        actualSize--;
    }

    @Override
    public int indexOf(Object o) {
        // логически, в процессе рефакторинга при вариациях с null приходишь к классическому варианту
        // другая реализация получается менее лаконичной)) как эта)
        if (actualSize == 0 || o != null && array[0].getClass() != o.getClass()) {
            return -1;
        }
        for (int i = 0; i < actualSize; i++) {
            if (o == null || array[i] == null) {
                if (o == null && array[i] == null) {
                    return i;
                }
                continue;
            }
            if (o.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (actualSize <= 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < actualSize - 1; i++) {
            sb.append((array[i]) + ", ");
        }
        sb.append((array[actualSize - 1]) + "]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.hashCode() != this.hashCode() || this.getClass() != o.getClass()) {
            return false;
        }
        MyArrayListImpl<T> ot = (MyArrayListImpl<T>) o;

        if (ot.actualSize != actualSize) {
            return false;
        }
        if (actualSize == 0) {
            return true;
        }
        if (this.array[0].getClass() != ot.array[0].getClass()) {
            return false;
        }
        for (int i = 0; i < actualSize; i++) {
            if (this.array[i] != ot.array[i]) {
                return false;
            }
        }
        return true;
    }
}
