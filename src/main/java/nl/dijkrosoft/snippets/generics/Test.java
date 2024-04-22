package nl.dijkrosoft.snippets.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dickdijk on 29/04/2017.
 */
class Test {
    public static void someMethod( List list) {
        list.add("xyz");     // "unchecked" warning
 //       list.add(Long.valueOf("4"));
    }
    public static void test() {
        List<Long> list = new ArrayList<Long>();
        someMethod(list);
    }
}
