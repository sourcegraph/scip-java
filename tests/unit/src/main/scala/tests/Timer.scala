package tests

import java.time.Clock
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

class Timer(val clock: Clock = Clock.systemDefaultZone()) {
  val start: Instant = clock.instant()

  def instant(): Instant = clock.instant()
  def duration(): Duration = Duration.between(start, clock.instant())

  def format(): String = Timer.formatDuration(start, clock.instant())
  def formatPadded(): String =
    Timer.formatDurationPadded(start, clock.instant())
  override def toString: String = format()
}

object Timer {
  def formatDurationPadded(start: Instant, end: Instant): String =
    formatDuration(start, end).padTo("10.4s".length(), ' ')

  def formatDuration(start: Instant, end: Instant): String = {
    val ms = ChronoUnit.MILLIS.between(start, end)
    val days = TimeUnit.MILLISECONDS.toDays(ms)
    val hr = TimeUnit.MILLISECONDS.toHours(ms) % 24
    val min = TimeUnit.MILLISECONDS.toMinutes(ms) % 60
    val s = (ms.toDouble / 1000) % 60
    new StringBuilder()
      .append(
        if (days <= 0)
          ""
        else if (days == 1)
          s"${days}day"
        else
          s"${days}days"
      )
      .append(
        if (hr > 0)
          s"${hr}hr"
        else
          ""
      )
      .append(
        if (min > 0)
          s"${min}m"
        else
          ""
      )
      .append(f"$s%.1fs")
      .toString()
  }
}
