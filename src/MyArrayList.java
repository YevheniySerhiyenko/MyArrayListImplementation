import java.util.Comparator;

public interface MyArrayList<T> {

    void add(Object o, int index);

    MyArrayListImpl<? extends T> concat(MyArrayList<T> newList);

    T get(int index);

    int size();

    T[] toArray();

    MyArrayListImpl<? extends T> reverseList();

    void removeIfContains(Object value);

    int search(Object value);

    MyArrayListImpl<? extends T> subList(int start, int end);

    void shuffle();

    void isEmpty();

    boolean contains(Object o);

    void add(T t);

    public void trim();

    void remove(Object o);

    void sort(Comparator<? super T> comparator);

    void clear();

    void set(int index, T t);

    void remove(int index);

    int indexOf(Object o);
}
