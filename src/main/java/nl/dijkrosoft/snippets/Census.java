package nl.dijkrosoft.snippets;

import java.util.HashMap;
import java.util.Map;

import nl.dijkrosoft.snippets.mail.Driver;

/**
 * Created by dickdijk on 19/04/2017.
 */
public class Census {

    /* can not add to param with upperbound */
    public static void addRegistry(Map<String, ? extends Person> registry) {
        for ( Person p : registry.values()) {
            System.out.println(p);
        }
    }

    /* can only add Drivers (not supertypes of Driver) to collection */
    public static void addToRegistry(Map<String, ? super Driver> registry) {

        registry.put("Jens", new Driver());
    }

    public static void main(String[] args) {

        Map<String, Driver> allDrivers = new HashMap<>();
        allDrivers.put("dick", new Driver());
        Census.addRegistry(allDrivers);
        Census.addToRegistry(allDrivers);
    }
}
