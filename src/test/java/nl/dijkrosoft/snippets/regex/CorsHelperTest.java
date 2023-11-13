package nl.dijkrosoft.snippets.regex;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CorsHelperTest {

    @Parameterized.Parameters
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

    public CorsHelperTest(String input, String expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Test
    public void testCors() {

        Assert.assertEquals(expectedResult, CorsHelper.extractHostAndPort(input));

    }
}


