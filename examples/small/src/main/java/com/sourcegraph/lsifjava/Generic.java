package com.sourcegraph.lsifjava;
import java.util.Collection;

class Generic<T extends Object> {
    public T test() {
        return null;
    }

    public <S extends Integer> Collection<S> select(Class<T> c) { 
        return null;
    }

    public Collection<T> asdf() {
        return null;
    }
}