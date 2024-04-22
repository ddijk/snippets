package nl.dijkrosoft.snippets.fp;

public class RunnerInt {

    public static void main(String[] args) {

        int result = add(3, 100_000);
        System.out.println("Result is " + result);
    }

    public static int add(int x, int y) {

        TailCall<Integer> tc = new Suspend<>(()-> _add(x, y));
        while ( tc.isSuspended()) {
            tc = tc.resume();
        }

        return tc.eval();

    }

    public static TailCall<Integer> _add(int x, int y) {

        if (y == 0) {
            return new Return<Integer>(x);
        } else {

            return new Suspend<Integer>(() -> _add(x + 1, y - 1));
        }
    }

}
