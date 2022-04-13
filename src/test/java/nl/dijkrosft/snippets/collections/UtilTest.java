package nl.dijkrosft.snippets.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class UtilTest {


    @Test
    public void testDisjunction() {


        List<String> listA = List.of("aap", "noot", "mies", "vuur" );
        List<String> listB = List.of("aap", "noot", "soep", "huis" );

        assertThat(CollectionUtils.disjunction(listA, listB), containsInAnyOrder("soep", "mies", "huis", "vuur"));
    }

    @Test
    public void testIntersection() {


        List<String> listA = List.of("aap", "noot", "mies", "vuur" );
        List<String> listB = List.of("aap", "noot", "soep", "huis" );

        assertThat(CollectionUtils.intersection(listA, listB), containsInAnyOrder("aap", "noot"));
    }
}