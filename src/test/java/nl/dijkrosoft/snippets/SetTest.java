package nl.dijkrosoft.snippets;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by dickdijk on 19/04/2017.
 */
class SetTest {

    @Test
    void adding() {

        Set<String> s1 = new HashSet<>();
        s1.add("noot");
        s1.add("aap");
        s1.add("mies");

        Set<String> s2 = new HashSet<>();
        s2.add("aap");
        s2.add("noot");
        s2.add("mies");

        assertEquals(s1,s2);

    }
}
