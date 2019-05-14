/*
 * Copyright (C) 2019  Wegtam GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.wegtam.scala.intro

import scala.annotation.tailrec

/**
  * Overall basics are like in most other programming languages.
  *
  * HINT: You can leave out a lot of stuff to be implemented later by using
  *       three question marks `???`.
  */
object basics {

  /**
    * There are several kinds of value definitions.
    */
  object values {
    // Immutable values
    val immutable: Int = 1 // This cannot be changed.
    // Mutable variables
    @SuppressWarnings(Array("org.wartremover.warts.Var"))
    var mutable: Int = 1 // This can be overridden, try not to do this!
    // Immutable datatypes
    val immutableSeq: scala.collection.immutable.Seq[Int] = ???
    // Immutable mutable datatypes
    val immutableMutableSeq: scala.collection.mutable.Seq[Int] = ???
    // Mutable mutable datatypes e.g. NEVER EVER DO THIS!
    @SuppressWarnings(Array("org.wartremover.warts.Var"))
    var mutableMutableSeq: scala.collection.mutable.Seq[Int] = ???
  }

  /**
    * Scala defaults to eager evaluation (call by value).
    */
  object eval {
    val a = 1
    // Call by name is possible
    def f(a: Int, b: => Int): Int = ???
    // Lazy vals are possible but beware of possible deadlocks.
    lazy val b = a + 1
  }

  /**
    * Blocks are defined by curly braces and you can shadow variable definitions.
    */
  object scoping {
    def foo(a: Int) = {
      val x = 23
      def bar(a: Int) =
        x + a // x == 23
      val r = {
        val x = bar(42) + a
        x * x // x == 42 + 23 + a
      }
    }
  }

  /**
    * Semicolons are optional but sometimes needed.
    */
  object semicolons {
    // correct
    val a = 1
    // also correct but not necessary
    val b = 2;
    // here you need the semicolon
    //val c = a + b; c * 2
  }

  /**
    * If an expression takes multiple lines the infix operator has to be placed
    * on the end of the previous line.
    */
  object infix {
    // will be read as: a; + b
    //a
    //+ b

    // will be read as: a + b
    //a +
    //b

    // will be read as: als a + b
    //(a
    //  + b)
  }

  /**
    * You can write functions using tail recursion in Scala.
    */
  object recursion {

    /**
      * Recursive implementation of factorial
      *
      * @param n A number.
      * @return The factorial of the number.
      */
    def fac(n: Long): Long =
      if (n == 0)
        1L
      else
        n * fac(n - 1)

    /**
      * Tail-recursive implementation of factorial.
      *
      * Also you can see here that you can define defs inside defs. :-)
      *
      * @param n A number.
      * @return The factorial of the number.
      */
    def facTR(n: Long): Long = {
      @tailrec
      def fact(acc: Long, x: Long): Long =
        if (x == 0)
          acc
        else
          fact(acc * x, x - 1)
      fact(1, n)
    }
  }

  /**
    * Higher Order Functions
    */
  object hots {
    def check(x: Int)(f: Int => Boolean) = f(x)
    def isEven(a: Int)                   = a % 2 == 0
    // explicit passing
    val a = check(3)(isEven)
    // pass an anonymous function
    val b = check(3)((a: Int) => a % 2 != 0)
  }

  /**
    * Scala supports currying e.g. the conversion of a function with multiple
    * parameters into a function with one parameter.
    */
  object currying {

    /**
      * Multiply all numbers starting between `x` and `y` (inclusive)
      * and apply the given function `f` before the multiplication.
      */
    def mult(f: Int => Int): (Int, Int) => Int = {
      def applyF(x: Int, y: Int): Int =
        if (x > y)
          1
        else
          f(x) * applyF(x + 1, y)
      applyF
    }
    // Identity
    //mult((a: Int) => a)(1, 1) // => 1
    //mult((a: Int) => a)(1, 2) // => 2
    //mult((a: Int) => a)(1, 3) // => 6
    // Quadruple
    //mult((a: Int) => a * a)(1, 1) // => 1
    //mult((a: Int) => a * a)(1, 2) // => 4
    //mult((a: Int) => a * a)(1, 3) // => 36

    /**
      * Scala allows an easier definition by a special syntax e.g.
      * using multiple parameter lists.
      */
    def mult2(f: Int => Int)(x: Int, y: Int): Int =
      if (x > y)
        1
      else
        f(x) * mult(f)(x + 1, y)
  }

  /**
    * Scala supports polymorphic functions.
    */
  object poly {
    object badAndWrong {
      final case class P(category: String)

      def getSalaray(p: P): Int =
        if (p.category == "EMPLOYEE")
          ???
        else
          ???
    }

    object better {
      sealed trait Person
      final case class Stranger() extends Person
      final case class Employee() extends Person

      def getSalaray[A <: Employee](p: A) = ???

      // Even more generic definitions are possible (and often useful).
      def polyFun[A, B](a: A)(f: A => B): B = f(a)
    }
  }

  /**
    * Scala supports pattern matching.
    */
  object patmat {

    /**
      * Please try to _never_ use `Any`!
      */
    def fn(x: Any): String = x match {
      case Some(value) => value.toString
      case None        => "None"
      case (v1, v2)    => s"Pair($v1, $v2)"
      case xh :: xs    => "List"
      case _           => "..." // The `_` is a "match all" case.
    }
  }
}
