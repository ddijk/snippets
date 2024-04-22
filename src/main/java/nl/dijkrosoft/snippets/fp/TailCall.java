package nl.dijkrosoft.snippets.fp;

import java.util.function.Supplier;
public abstract class TailCall<T> {

    abstract T eval();

    abstract TailCall<T> resume();

    abstract  boolean isSuspended();
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
}

class Suspend<T> extends TailCall<T> {

    private final Supplier<TailCall<T>> supplier;

    public Suspend(Supplier<TailCall<T>> supplier) {
        this.supplier = supplier;
    }

    @Override
    T eval() {
        throw new IllegalStateException("Kan niet");
    }

    @Override
    TailCall<T> resume() {
        return supplier.get();
    }

    @Override
    boolean isSuspended() {
        return true;
    }
}
