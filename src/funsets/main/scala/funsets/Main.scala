package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))
  /*
  val a = union(singletonSet(1), singletonSet(3))
  val b = union(singletonSet(4), singletonSet(5))
  val c = union(a, b)
  val d = union(c, singletonSet(7))
  val inputSet = union(d, singletonSet(1000))
  val mapSet = map(inputSet, x => x-1)
  println(printSet(inputSet))
  println(printSet(mapSet))
  * */
}
