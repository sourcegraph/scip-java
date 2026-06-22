package com.sourcegraph.scip_aggregator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Colocated unit test for {@link JdkPackage#parse}. Migrated from the former Scala JdkPackageSuite
 * in tests/unit.
 */
class JdkPackageTest {

  @Test
  void keepsMajorVersionJdk11() {
    assertEquals("11", JdkPackage.parse("11.0.9").version);
  }

  @Test
  void keepsMajorVersionJdk17() {
    assertEquals("17", JdkPackage.parse("17.0.5").version);
  }
}
