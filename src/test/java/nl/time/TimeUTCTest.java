package nl.time;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Properties;

public class TimeUTCTest {

    @Test
    public void test() {
        Date d = new Date();

        final long time = d.getTime();
        System.out.println("now: \n" + time);

        long time2 = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(1));
        System.out.println("now java.time: \n" + time2);
        LocalDateTime tenDaysAgo = LocalDateTime.now().minusDays(10);
        final long tenDaysAgoAsLong = tenDaysAgo.toEpochSecond(ZoneOffset.ofHours(1));
        System.out.println("ten days ago: \n" + tenDaysAgoAsLong);

        long fromSite = 1549128964L;
        System.out.println("verschil : \n" + (time2 - fromSite));
//        System.out.println("from site\n1549128964");
    }

    @Test
    public void epochDiff() {
        long fromSite = 1549129481L;

        // now: corresponds to a different Unix timestamp than UTC if your not in the UTC timezone
        System.out.println("diff=" + (LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) - fromSite));
    }

    /**
     * This is the one!
     */
    @Test
    public void epochDiffGetUTCTime() {
        long fromSite = 1549129481L;

        final long epochSecond = LocalDateTime.now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC);
        System.out.println("diff=" + (epochSecond - fromSite));

        System.out.println("Back to LocalDateTime: "+ LocalDateTime.ofEpochSecond(epochSecond,0, ZoneOffset.UTC));
    }

    @Test
    public void epochDiffGetDate() {
        long fromSite = 1549129481L;

        long d = new Date().getTime()/1000;
        System.out.println("diff=" + (d - fromSite));
    }

    @Test
    public void printSystemProperties() {

        final Properties properties = System.getProperties();

        properties.list(System.out);
    }
}