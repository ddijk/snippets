package nl.dijkrosoft.snippets.fp;

import java.util.function.Supplier;

public abstract class TailCall<T> {

    abstract T eval();

    abstract TailCall<T> resume();

    abstract boolean isSuspended();
}

class Return<T> extends TailCall<T> {

    private final T t;

    public Return(T t) {
        this.t = t;
    }

    @Override
    T eval() {
        return t;
    }

    @Override
    TailCall<T> resume() {
        throw new IllegalStateException("Kan niet");
    }

    @Override
    boolean isSuspended() {
        return false;
    }

    public static <T> Return<T> ret(T t) {
        return new Return<>(t);
    }
}

class Suspend<T> extends TailCall<T> {

    private Supplier<TailCall<T>> supplier;

    public Suspend(Supplier<TailCall<T>> supplier) {
        this.supplier = supplier;
    }

    @Override
    T eval() {
        TailCall<T> res = supplier.get();
        while (res.isSuspended()) {
            res = res.resume();
        }
        return res.eval();
    }

    @Override
    TailCall<T> resume() {
        return supplier.get();
    }

    @Override
    boolean isSuspended() {
        return true;
    }

    public static <T> Suspend<T> sus(Supplier<TailCall<T>> supplier) {
        return new Suspend<>(supplier);
    }
}

