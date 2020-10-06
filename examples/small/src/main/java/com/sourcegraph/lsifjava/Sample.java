package com.sourcegraph.lsifjava;

import java.util.Iterator;
import java.util.List;

/**
 * Sample text
 */
public class Sample extends Object implements Iterator<String>, Iterable<String> {
	public Sample() {
		Sample.nom("", false);
	}

    public static void nom(String test, boolean stuff) {
        var s = new Sample();
        List<Boolean> x = null;
        System.out.println("om nom nom");
    }

	public boolean hasNext() {
		return true;
	}

	public String next() {
		return null;
	}

	public Iterator<String> iterator() {
		return this;
	}
}