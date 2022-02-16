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

    boolean isEmpty();	//

    boolean contains(Object o);

    void add(T t);

    void trim();

    void sort(Comparator<T> comparator);

    void clear();

    boolean equals(Object o);

    int hashCode();

    void set(int index, T t);

    int indexOf(Object o);

    String toString();

    void remove(int index);

}
