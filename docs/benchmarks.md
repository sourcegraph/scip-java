---
id: benchmarks
title: Benchmarks
---

The repository contains benchmarks to measure the overhead of the SemanticDB
compiler plugin.

```
$ sbt
...
sbt:root> bench/jmh:run -i 10 -wi 10 -f1 -t1
...
[info] Benchmark                           (lib)  Mode  Cnt     Score     Error  Units
[info] CompileBench.compile                guava    ss   10  2291.036 ± 243.428  ms/op 1x
[info] CompileBench.compileSemanticdb      guava    ss   10  3444.978 ± 408.569  ms/op 1.5x
[info] CompileBench.compile            bytebuddy    ss   10  1819.150 ± 191.530  ms/op 1x
[info] CompileBench.compileSemanticdb  bytebuddy    ss   10  2641.590 ± 203.537  ms/op 1.45x
```

- Date: Monday 15 Feb 2021.
- Hardware: MacBook Pro (16-inch, 2019), 2,6 GHz 6-Core Intel Core i7, 32 GB
  2667 MHz DDR4.
- Interpretation: enabling the SemanticDB compiler plugin slows down normal
  compilation by 45-50%.
- Recommendation: do not enable the SemanticDB compiler plugin during local
  edit-and-test workflows. The compiler plugin is primarily intended to be
  enabled in custom CI jobs to upload SCIP indexes.
