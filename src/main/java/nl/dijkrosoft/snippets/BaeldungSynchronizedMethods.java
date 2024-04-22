package nl.dijkrosoft.snippets;

public class BaeldungSynchronizedMethods {

    private int sum = 0;

    public synchronized void calculate() {
        setSum(getSum() + 1);
    }

    int getSum() {
        return sum;
    }

    void setSum(int i) {
        sum = i;
    }
}