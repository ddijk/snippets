package nl.dijkrosoft.snippets;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by dick on 6-6-17.
 */
public class TimeParser {

    public static void main(String[] args) throws IOException {

        Path file = Paths.get("creation_times");

        Files.readAllLines(file).forEach(timeSinceEpoch -> printDateThatBelongsToTimestamp(timeSinceEpoch));

    }

    private static void printDateThatBelongsToTimestamp(final String timeSinceEpoch) {

        Date date = new Date(Long.parseLong(timeSinceEpoch));

        String dateAsString = date.toString();

        System.out.println(String.format("%s,%s", timeSinceEpoch, date.toString()));
    }
}
