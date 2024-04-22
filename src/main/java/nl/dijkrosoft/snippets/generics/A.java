package nl.dijkrosoft.snippets.generics;

/**
 * Created by dickdijk on 29/04/2017.
 */
public class A {
    static void overloadedMethod( Object o) {
        System.out.println("overloadedMethod(Object) called");
    }
    static void overloadedMethod( String s) {
        System.out.println("overloadedMethod(String) called");
    }
    static void overloadedMethod( Integer i) {
        System.out.println("overloadedMethod(Integer) called");
    }
    static <T> void genericMethod(T t) {
        overloadedMethod (t) ; // which method is called?
    }

    public static void main(String[] args) {
        genericMethod( "abc" );
    }
}
