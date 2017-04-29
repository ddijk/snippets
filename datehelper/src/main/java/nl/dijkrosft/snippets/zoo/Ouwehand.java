package nl.dijkrosft.snippets.zoo;

import java.util.ArrayList;
import java.util.List;

public class Ouwehand {

    public static void main(String[] args) {


        List<Dog> animalList = new ArrayList<>();

        animalList.add(new Dog("zoogdier","Shiva" ));
//        animalList.add(new Konijn("zoogdier","Rommel" ));

        addAnimal(animalList);
        printAnimals(animalList);
    }

    private static void addAnimal(List<? super Dog> animalList) {
        animalList.add(new Dog("zoogdier", "fikkie"));
    }

    private static void printAnimals(List<? extends Animal> animalList) {
      //  animalList.add(new Konijn("zoogdier", "floppie"));
        for ( Animal animal : animalList) {
            animal.print();
        }

    }
}
