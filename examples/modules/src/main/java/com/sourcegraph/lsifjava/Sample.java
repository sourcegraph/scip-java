package com.sourcegraph.lsifjava;

import java.util.Iterator;

/**
 * Sample text
 */
public class Sample extends Object implements Iterator<String>, Iterable<String> {
    public static void nom() {
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