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

/**
  * Implicits offer several very powerful features albeit can slow down
  * the compiler considerably.
  */
object implicits {

  /**
    * Passing every parameter explicitely becomes tedious especially
    * when some are always the same (e.g. currying).
    *
    * NOTE:
    *   - always specify the type of implicit val or def
    *   - try not to use implicits for simple datatypes (primitives)
    *   - the compiler will yell at you if multiple implicits of the same type
    *     are in scope
    */
  object params {
    def increment(n: Int)(implicit incBy: Int): Int = n + incBy

    val a               = increment(3)(4)
    implicit val i: Int = 10
    // Overriding is always possible
    val b = increment(3)(4)
    // Otherwise the implicit is chosen.
    val c = increment(3)
  }

  /**
    * Implicit conversions should generally not be used because the create more
    * trouble than solving.
    */
  object conversions {
    // Enable the feature
    import scala.language.implicitConversions

    implicit def intToStr(i: Int): String = i.toString

    def concat(a: String, b: String): String = a + b

    val _ = concat("a", 1) // Compiles because of the implicit def above.
  }

  /**
    * Implicits can be used to extend datatypes with functions.
    *
    * In some languages this is called monkey patching. ;-)
    *
    * NOTE:
    *   - always put such wrappers into an object called `syntax` or `implicits`
    *     which enables the functions by an import (`import syntax._`)
    *   - stick to the naming conventions by appending `Ops` e.g. `DataTypeNameOps`
    */
  object extensions {
    // If possible extend `AnyVal` when doing this.
    implicit final class IntOps(val i: Int) extends AnyVal {
      def succ: Int = i + 1
    }

    val a: Int = 1
    val _      = a.succ
  }
}
