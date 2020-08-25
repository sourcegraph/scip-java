package com.sourcegraph.lsifjava;

public abstract class Abstract {
    public abstract void generate();

    public static Abstract create() {
        return new Abstract() {
			@Override
			public void generate() {}
        };
    }
}