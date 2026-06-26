tasks.register("saveSnapshots") {
    group = "verification"
    description = "Regenerates all SCIP snapshot goldens."
    dependsOn(":scip-snapshots:saveSnapshots")
}
