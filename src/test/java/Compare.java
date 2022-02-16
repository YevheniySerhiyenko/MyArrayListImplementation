package test.java;

import java.util.Comparator;

public class Compare<T> implements Comparator<Number> {

    @Override
    public int compare(Number o1, Number o2) {
        if (o1.intValue() > o2.intValue()) return 1;
        if (o1.intValue() < o2.intValue()) return -1;
        return 0;

    }
}
