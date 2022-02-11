import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayListImpl<T> implements MyArrayList {
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

    }

    @Override
    public void add(Object o, int index) {

    }

    @Override
    public MyArrayListImpl<? extends T> concat(MyArrayList newList) {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public MyArrayListImpl<? extends T> reverseList() {
        return null;
    }

    private void newSize() {
    }

    @Override
    public void trim() {
    }

    @Override
    public int search(Object value) {
        return 0;
    }

    @Override
    public void shuffle() {
    }

    @Override
    public MyArrayListImpl subList(int start, int end) {
        return null;
    }


    @Override
    public void removeIfContains(Object value) {
    }

    @Override
    public void remove(Object o) {
    }

    @Override
    public void sort(Comparator comparator) {
    }

    @Override
    public void clear() {
    }

    @Override
    public void isEmpty() {
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
        return 0;
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
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

}
