package nl.dijkrosoft.snippets.fp;

import java.math.BigInteger;

public class Fibonacci {


    public static BigInteger fibo(int x) {

        TailCall<Tuple<BigInteger>> tupleTailCall = _fibo(x, new Tuple<>(BigInteger.ZERO, BigInteger.ONE));


        return tupleTailCall.eval()._1;

    }


    /**
     * Fibo 0, 1, 1, 2, 3, 5, 8
     * 0 -> 0
     * 1 -> 1
     * 2 -> 1
     * 3 -> 2
     * @param index
     * @return
     */
    public static TailCall<Tuple<BigInteger>> _fibo(int index, Tuple<BigInteger> state) {

        if ( index  == 0 ) {
            return new Return<>(state);
        } else {
            return new Suspend<>(()-> _fibo(index -1 , new Tuple<>(state._2, state._1.add(state._2))));
        }

    }



}

class Tuple<T> {

    final T _1;
    final T _2;

    public Tuple(T _1, T _2) {
        this._1 = _1;
        this._2 = _2;
    }
}
