package minimized

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class MinimizedScalaSynthetic {
  def everything(): Unit = Future(1)
  def applyTree(): Unit = Future.apply[Int](1)
  def applyTree2(): Unit = List.apply[Int](1).sorted
  def selectTree(): Unit = Future[Int](1)
  def typeApplyTree(): Unit = Future.apply(1)
  def forComprehensions(): Unit =
    for {
      x <- Future(1)
      y <- Future.successful(1)
      if y < 2
      z <- Future.apply[Int](1)
    } yield x + y + z
}
