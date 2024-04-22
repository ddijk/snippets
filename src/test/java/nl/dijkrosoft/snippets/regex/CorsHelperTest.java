package nl.dijkrosoft.snippets.regex;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CorsHelperTest {

    public static Object[][] data() {
        return new Object[][]{
                new Object[]{"http://localhost:3000", "http://localhost:3000"},
                new Object[]{"http://localhost:3000/", "http://localhost:3000"},
                new Object[]{"http://localhost:3000/a", "http://localhost:3000"},
                new Object[]{"http://localhost:3000/a/b/index.html", "http://localhost:3000"},
                new Object[]{"http://localhost:3000/a/b", "http://localhost:3000"},
                new Object[]{"https://localhost:3000", "https://localhost:3000"}
        };
    }

    String input;
    String expectedResult;

    public void initCorsHelperTest(String input, String expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @MethodSource("data")
    @ParameterizedTest
    public void cors(String input, String expectedResult) {

        initCorsHelperTest(input, expectedResult);

        assertEquals(expectedResult, CorsHelper.extractHostAndPort(input));

    }
}


