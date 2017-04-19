package nl.dijkrosft.snippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by dickdijk on 19/04/2017.
 */
public class Recorder {

    class Record {}
    class LongRecord extends Record {}

    public List<LongRecord> gatherRecords() {
        return Arrays.asList(new LongRecord(), new LongRecord());
    }

    public void processRecords(List<? super LongRecord> records) {
       // records.forEach(System.out::println);
        records.add(new LongRecord());
    }

    public void gatherAndProcess() {
        List<LongRecord> records = gatherRecords();
      //  List<Record> records= new ArrayList<>();
        processRecords(records);
    }

    public static void main(String[] args) {
        new Recorder().gatherAndProcess();
    }
}
