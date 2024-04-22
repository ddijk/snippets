package nl.dijkrosoft.snippets.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class UtilTest {


    @Test
    void disjunction() {


        List<String> listA = List.of("aap", "noot", "mies", "vuur" );
        List<String> listB = List.of("aap", "noot", "soep", "huis" );

        assertThat(CollectionUtils.disjunction(listA, listB), containsInAnyOrder("soep", "mies", "huis", "vuur"));
    }

    @Test
    void intersection() {


        List<String> listA = List.of("aap", "noot", "mies", "vuur" );
        List<String> listB = List.of("aap", "noot", "soep", "huis" );

        assertThat(CollectionUtils.intersection(listA, listB), containsInAnyOrder("aap", "noot"));
    }
}