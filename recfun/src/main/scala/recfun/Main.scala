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
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def examineChar(unmatched: Int, char: Char): Int = {
      if (char == '(') unmatched + 1
      //FIXME: this is dire - need to exit early for unmatchable )
      else if (char == ')' && unmatched == 0) Int.MinValue
      else if (char == ')' && unmatched > 0) unmatched - 1
      else unmatched
    }

    def inner(depth: Int, chars: List[Char]): Int = {
      if (chars.isEmpty) depth
      else inner(examineChar(depth, chars.head), chars.tail)
    }
    inner(0, chars) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
