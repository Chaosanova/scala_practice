package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    //println(countChange(300,List()))
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
    if (c == 0 || r == c) 1 else pascal(c - 1 ,r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {    
      var counter = 0
      def count(chars: List[Char]):Boolean = {
        
        if ((!chars.isEmpty) && chars.head.equals('(')) counter = counter + 1
        if ((!chars.isEmpty) && chars.head.equals(')')) counter = counter - 1
        
        if(chars.isEmpty && counter == 0)true
        else if((chars.isEmpty && counter !=  0) || counter < 0)false
        else count(chars.tail)
      }
      
      count(chars)
  }
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    var counter = 0
    val sort = coins.sortWith((x, y) => x > y)
    
    def counterMethod(money: Int, coins: List[Int]): Int = {
      if((coins.tail.isEmpty) && (money % coins.head == 0)) counter = counter + 1
      else if(!coins.tail.isEmpty){
        val range =  money / coins.head
        for(percent <- 0 to range){
          counterMethod(money - coins.head * percent, coins.tail)
        }
      }
      
      counter
    }
    
    if(coins.isEmpty) 0
    else counterMethod(money, sort)
  }
}
