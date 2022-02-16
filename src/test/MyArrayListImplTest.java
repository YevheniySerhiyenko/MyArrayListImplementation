package test;

import main.java.MyArrayListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import test.java.Compare;



public class MyArrayListImplTest {
    MyArrayListImpl<Integer> listInt;
    MyArrayListImpl<String> listString;
    MyArrayListImpl<String> listString2;
    MyArrayListImpl<Number> listDouble;
    MyArrayListImpl<Integer> forSortMethod;


    @BeforeEach
    void setUp() {
        listInt = new MyArrayListImpl<>();
        listString = new MyArrayListImpl<>();
        listString2 = new MyArrayListImpl<>();
        listDouble = new MyArrayListImpl<Number>();
        forSortMethod = new MyArrayListImpl<>();


        forSortMethod.add(6);
        forSortMethod.add(22);
        forSortMethod.add(797);
        forSortMethod.add(5);
        forSortMethod.add(1123);
        forSortMethod.add(89);
//        "[5, 6, 22, 89, 797,1123]"

        listInt.add(0);
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);
        listInt.add(5);
        listInt.add(6);
        listInt.add(7);
        listInt.add(8);
        listInt.add(9);
        //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        listString.add("Hello");
        listString.add(" ");
        listString.add("world");
        listString.add("java");
//        ["Hello", " ", "world", "java"]

        listDouble.add(8.4);
        listDouble.add(4.2);
        listDouble.add(0);
        listDouble.add(9.5);
        listDouble.add(18.43);

//        "[8.4, 4.2, 0, 9.5, 18.43]"

        listString2.add("this");
        listString2.add("strings");
        listString2.add("for");
        listString2.add("concat");
        listString2.add("test");
//        [this, strings, for, concat, test]

    }

    @Test
    void addTest() {
        Assertions.assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]",listInt.toString());
        Assertions.assertEquals(10,listInt.size());
        Assertions.assertEquals("[Hello,  , world, java]",listString.toString());
        Assertions.assertEquals(4,listString.size());
    }

    @Test
    void concatTest() {
        Assertions.assertEquals("[Hello,  , world, java, this, strings, for, concat, test]",listString.concat(listString2).toString());
    }

    @Test
    void getTest() {
        Assertions.assertNull(listString.get(15));
        Assertions.assertEquals("Hello",listString.get(0));
        Assertions.assertEquals(8.4,listDouble.get(0));
    }


    @Test
    void toArrayTest() {
    }

    @Test
    void reverseListTest() {
        Assertions.assertEquals("[java, world,  , Hello]",listString.reverseList().toString());
        Assertions.assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]",listInt.reverseList().toString());
    }


    @Test
    void subListTest() {
        Assertions.assertEquals("[0, 1, 2, 3]", listInt.subList(0,3).toString());
        Assertions.assertEquals("[this, strings, for]", listString2.subList(0,2).toString());
        Assertions.assertEquals("[ , world, java]", listString.subList(1,3).toString());
    }

    @Test
    void removeIfContainsTest() {
//        listString.removeIfContains("Hello");
//        Assertions.assertEquals("[  ,world, java]",listString.toString());
//        listDouble.removeIfContains(4.2);
//        Assertions.assertEquals("[8.4, 0, 9.5, 18.43]",listDouble.toString());
    }

    @Test
    void searchTest() {
        Assertions.assertEquals(3,listString2.search("concat"));
        Assertions.assertEquals(3,listInt.search(3));
        Assertions.assertEquals(3,listDouble.search(9.5));
    }

    @Test
    void sortTest() {
        forSortMethod.sort(new Compare());
        Assertions.assertEquals("[5, 6, 22, 89, 797, 1123]",forSortMethod.toString());
    }

    @Test
    void clearTest() {
        listDouble.clear();
        listInt.clear();
        listString.clear();
        Assertions.assertEquals(0,listDouble.size());
        Assertions.assertEquals(0,listInt.size());
        Assertions.assertEquals(0,listString.size());
    }

    @Test
    void isEmptyTest() {
        listInt.clear();
        Assertions.assertTrue(listInt.isEmpty());
        listInt.add(1);
        Assertions.assertFalse(listInt.isEmpty());
    }

    @Test
    void containsTest() {
        Assertions.assertFalse(listInt.contains(11));
        Assertions.assertTrue(listInt.contains(4));
        Assertions.assertFalse(listString.contains("hi"));
        Assertions.assertTrue(listString.contains("Hello"));
    }

    @Test
    void setTest() {
        listInt.set(6,789);
        Assertions.assertEquals("[0, 1, 2, 3, 4, 5, 789, 7, 8, 9]",listInt.toString());
        listString.set(1,"WORLD");
        Assertions.assertEquals("[Hello, WORLD, world, java]", listString.toString());
    }

    @Test
    void removeTest() {
        listInt.remove(5);
        Assertions.assertEquals("[0, 1, 2, 3, 4, 6, 7, 8, 9]",listInt.toString());

        listString2.remove(3);
        Assertions.assertEquals("[this, strings, for, test]",listString2.toString());

    }

    @Test
    void indexOfTest() {
        Assertions.assertEquals(-1,listString.indexOf("AAA"));
        Assertions.assertEquals(0,listString.indexOf("Hello"));
        Assertions.assertEquals(6,listInt.indexOf(6));
    }
}