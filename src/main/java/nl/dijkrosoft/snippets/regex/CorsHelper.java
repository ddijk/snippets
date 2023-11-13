package nl.dijkrosoft.snippets.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorsHelper {

    static Pattern pattern = Pattern.compile("(https?://localhost:\\d+).*");

    public static String extractHostAndPort(String referer) {
        Matcher m = pattern.matcher(referer);
        if ( m.matches() ) {
            return m.group(1);
        }
        throw new IllegalArgumentException("Invalid referer: "+ referer);
    }
}
