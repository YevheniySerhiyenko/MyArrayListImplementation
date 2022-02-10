import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
        trim();
        T t = null;
        if (index < array.length) {
            t =  (T) array[index];
        }
        return t;
    }
    @Override
    public int size(){
        return array.length;
    }


    @Override
    public T[] toArray() {
        return (T[]) Arrays.copyOf(array,actualSize);
    }
    //метод возвращает коллекцию в обратном порядке
    @Override
    public MyArrayListImpl<? extends T> reverseList() {
        MyArrayListImpl<? extends T> list = new MyArrayListImpl();
        for (int i = array.length - 1; i >= 0; i--) {
            list.add(array[i]);
        }
        return list;
    }

    // приватный метод для увеличения массива
    private void newSize(){
        array = Arrays.copyOf(array, array.length * 2);
    }

    public void trim(){
        if (actualSize < array.length){
            array = Arrays.copyOf(array,actualSize);
        }
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

    @Override
    public MyArrayListImpl subList(int start, int end) {
        MyArrayListImpl list = new MyArrayListImpl();
        for (int i = start; i <= end ; i++) {
            list.add(array[i]);
        }
        return list;
    }

    //метод удаляет из листа совпадения со значением value
    @Override
    public void removeIfContains(Object value) {
        array =  Arrays.stream(array).filter(o -> !o.equals(value)).toArray();
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
