package funsets

import common._

/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = {
    def oneSet(regElem: Int): Boolean = regElem == elem
    
    oneSet
  }

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = {
    def unionSet(regElem: Int) = contains(s, regElem) || contains(t, regElem)
    
    unionSet
  }

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = {
    def interSet(regElem: Int) = contains(s, regElem) && contains(t, regElem)
    
    interSet
  }

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = {
     def diffSet(regElem: Int) = contains(s, regElem) && !contains(t, regElem)
    
    diffSet
  }

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = {
    def filterSet(regElem: Int) = contains(s, regElem) && p(regElem)
    
    filterSet
  }

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a == 1000)(!contains(s,a) || (contains(s, a) && p(a)))
      else if (contains(s, a) && p(a) == false) false
      else iter(a + 1)
    }
    
    iter(-1000)
  }

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = {
    def q(input: Int): Boolean =
      !p(input)
    !forall(s,q)
  }
  
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: Set, f: Int => Int): Set = {
    def iter(a: Int, mapSet: Set):Set = {
      if(a == 1000){
        if(contains(s,a) && !contains(mapSet, f(a))) union(mapSet,singletonSet(f(a))) else mapSet
      } 
      else if(contains(s,a) && !contains(mapSet, f(a))) iter(a + 1, union(mapSet, singletonSet(f(a))))
      else iter(a + 1, mapSet)
    }
    
    iter(-1000, x => false)
  }

  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }
}
