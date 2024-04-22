package nl.dijkrosoft.snippets;

import nl.dijkrosoft.snippets.BaeldungSynchronizedMethods;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaeldungSynchronizedMethodsTest {

    @Test
    void calculate() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        BaeldungSynchronizedMethods summation = new BaeldungSynchronizedMethods();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }
}