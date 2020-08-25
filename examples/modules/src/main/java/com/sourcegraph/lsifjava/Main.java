package com.sourcegraph.lsifjava;

import java.io.File;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.mock.MockTracer;

public class Main {
    public static void main(String[] args) {
        Sample.nom();

        Abstract.create();

        try(Tracer tracer = new MockTracer()) {
            Span builder = tracer.buildSpan("test").start();
            builder.setTag("hello", "sourcegraph");

            File f = new File("lawl");
            System.out.println(f);
        }
    }
}
