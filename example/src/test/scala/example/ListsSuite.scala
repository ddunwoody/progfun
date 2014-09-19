package example

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object
 * `Lists` that need to be implemented as part of this assignment. A test
 * suite is simply a collection of individual tests for some specific
 * component of a program.
 *
 * A test suite is created by defining a class which extends the type
 * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
 * find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed
 * inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 *
 * - Start the sbt console and run the "test" command
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class ListsSuite extends FunSuite {

  /**
   * Tests are written using the `test` operator which takes two arguments:
   *
   * - A description of the test. This description has to be unique, no two
   * tests can have the same description.
   * - The test body, a piece of Scala code that implements the test
   *
   * The most common way to implement a test body is using the method `assert`
   * which tests that its argument evaluates to `true`. So one of the simplest
   * successful tests is the following:
   */
  test("one plus one is two")(assert(1 + 1 === 2))


  /**
   * In Scala, it is allowed to pass an argument to a method using the block
   * syntax, i.e. `{ argument }` instead of parentheses `(argument)`.
   *
   * This allows tests to be written in a more readable manner:
   */
  test("one plus two is three") {
    assert(1 + 2 === 3) // This assertion fails! Go ahead and fix it.
  }

  /**
   * In order to test the exceptional behavior of a methods, ScalaTest offers
   * the `intercept` operation.
   *
   * In the following example, we test the fact that the method `intNotZero`
   * throws an `IllegalArgumentException` if its argument is `0`.
   */
  test("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }


  /**
   * Now we finally write some tests for the list functions that have to be
   * implemented for this assignment. We fist import all members of the
   * `List` object.
   */

  import Lists._


  /**
   * We only provide two very basic tests for you. Write more tests to make
   * sure your `sum` and `max` methods work as expected.
   *
   * In particular, write tests for corner cases: negative numbers, zeros,
   * empty lists, lists with repeated elements, etc.
   *
   * It is allowed to have multiple `assert` statements inside one test,
   * however it is recommended to write an individual `test` statement for
   * every tested aspect of a method.
   */

  test("sum of an empty list is zero") {
    assert(sum(List()) === 0)
  }

  test("sum of a singleton list is the value") {
    assert(sum(List(5)) === 5)
  }

  test("sum of a repeated list") {
    assert(sum(List(1, 2, 3, 1, 2, 3)) === 12)
  }

  test("sum of zeros is zero") {
    assert(sum(List(0, 0, 0)) === 0)
  }

  test("sum of a few numbers") {
    assert(sum(List(1, 2, 0)) === 3)
  }

  test("sum of negative and positive numbers") {
    assert(sum(List(1, 2, -5)) === -2)
  }

  test("max throws an exception if its argument is empty") {
    intercept[NoSuchElementException] {
      max(List())
    }
  }

  test("max of a single number") {
    assert(max(List(4)) === 4)
  }

  test("max of a few numbers") {
    assert(max(List(3, 7, 2)) === 7)
  }

  test("max of a single zero") {
    assert(max(List(0)) === 0)
  }

  test("max of a single negative number") {
    assert(max(List(-6)) === -6)
  }


  test("max of a set of negative numbers") {
    assert(max(List(-2, -3, -7)) === -2)
  }

  test("max of a set of positive and negative numbers") {
    assert(max(List(-7, 3, -2)) === 3)
  }

  test("max of a set of identical numbers") {
    assert(max(List(5, 5, 5)) === 5)
  }
}
