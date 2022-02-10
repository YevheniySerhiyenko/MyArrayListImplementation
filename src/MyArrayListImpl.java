import java.util.Comparator;

public class MyArrayListImpl<T> implements MyArrayList {
    private final int DEFAULT_SIZE = 10;
    private Object[] array;
    private int actualSize = 0;     // заполненность внутреннего массива


    public MyArrayListImpl() {
        array = new Object[DEFAULT_SIZE];
    }

    //    конструктор для задания размера
    public MyArrayListImpl(int size) {
        array = new Object[size];
    }

    @Override
    public void add(Object o) {
        if (actualSize >= array.length / 2) { // если актуальный размер массива достиг размера половины изначального
            newSize();                        // увеличиваем массив в два раза
        }
        array[actualSize++] = o;
    }

    //    метод для добавления объекта по индексу
    //    элементы сдвигаются вправо на одну позицию
    @Override
    public void add(Object o, int index) {
        System.arraycopy(array,index,array,index + 1,actualSize - index);
        array[index] = o;
        actualSize++;

    }

    // метод для склейки двух листов, возвращает новый лист
    @Override
    public MyArrayListImpl<? extends T> concat(MyArrayList newList) {
        MyArrayListImpl list  = new MyArrayListImpl(array.length + newList.size());
        Object[] o = newList.toArray();
        for (int i = 0; i < array.length; i++) list.add(array[i]);
        for (int i = 0; i < o.length; i++) list.add(o[i]);
        list.trim();
        return list;
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
    public void contains(Object o) {
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public void set(int index, Object o) {
    }

    @Override
    public void remove(int index) {
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

}
