package nl.dijkrosft.snippets.zoo;

/**
 * Created by dickdijk on 29/04/2017.
 */
public class Animal {

    String type;
    String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    void print()  {

        System.out.println(String.format("Name:%s, type:%s",name,type));
    }
}
