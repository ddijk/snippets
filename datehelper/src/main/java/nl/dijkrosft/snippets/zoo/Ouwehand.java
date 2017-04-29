package nl.dijkrosft.snippets.zoo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dickdijk on 29/04/2017.
 */
public class Ouwehand {

    public static void main(String[] args) {


        List<Animal> animalList = new ArrayList<>();

        animalList.add(new Dog("zoogdier","Shiva" ));
        animalList.add(new Konijn("zoogdier","Rommel" ));

        printAnimals(animalList);
    }

    private static void printAnimals(List<Animal> animalList) {
        animalList.add(new Konijn("zoogdier", "floppie"));
        for ( Animal animal : animalList) {
            animal.print();
        }

    }
}
