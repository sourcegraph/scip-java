package snapshots

class CompanionOwner {
  companion object {
    fun create(): CompanionOwner = CompanionOwner()
  }
  fun create(): Int = CompanionOwner.create().hashCode()
}
