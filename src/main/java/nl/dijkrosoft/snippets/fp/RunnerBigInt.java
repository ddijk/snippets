package nl.dijkrosoft.snippets.fp;

import java.math.BigInteger;


public class RunnerBigInt {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);

        BigInteger result = add(new BigInteger("3"), new BigInteger("21474836473"));

        System.out.println(result );
    }

    public static BigInteger add(BigInteger a, BigInteger b) {

        TailCall<BigInteger> tc = _add(a, b);
        while ( tc.isSuspended()) {
            tc = tc.resume();
        }

        return tc.eval();
    }

    public static TailCall<BigInteger> _add(BigInteger a, BigInteger b) {

        if (b.equals(BigInteger.ZERO)) {
            return new Return(a);
        } else {
            return new Suspend(() -> _add(a.add(BigInteger.ONE), b.subtract(BigInteger.ONE)));
        }

    }
}
