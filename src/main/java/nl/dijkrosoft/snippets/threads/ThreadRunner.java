package nl.dijkrosoft.snippets.threads;

public class ThreadRunner {

    public static void main(String[] args) {

        NrProvider nrProvider = new NrProvider();

        Thread t1 = new Thread(new GetNextNr(nrProvider));
        Thread t2 = new Thread(new GetNextNr(nrProvider));
        Thread t3 = new Thread(new GetNextNr(nrProvider));

        t1.start();
        t2.start();
        t3.start();

    }

    static class GetNextNr implements Runnable {

        private final NrProvider nrProvider;

        public GetNextNr(NrProvider nrProvider) {
            this.nrProvider = nrProvider;
        }

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {

                System.out.println(nrProvider.get());
            }
        }
    }

    static class NrProvider {

        static int nr = 0;

        synchronized public int get() {

            try {
                Thread.sleep(50);
                nr = nr +1;
                return nr;
            } catch (InterruptedException e) {
                System.err.println("Sleep failed");
                throw new RuntimeException(e);
            }
        }
    }
}
