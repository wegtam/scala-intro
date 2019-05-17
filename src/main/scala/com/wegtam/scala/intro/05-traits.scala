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
  * Traits define abstract interfaces.
  *
  * They have no constructor but can take type parameters.
  */
object traits {

  trait Whatever[A, B] {
    def getA: A

    def convert(a: A): B
  }

  /**
    * Sealed traits must define all their implementations in the
    * same file.
    *
    * They can be used to model sum types using case classes or case objects.
    *
    * Also the compiler will complain if you don't check all possibilities
    * within a pattern match!
    */
  sealed trait Operations

  object Operations {
    case object Add       extends Operations
    case object Divide    extends Operations
    case object Multiply  extends Operations
    case object Substract extends Operations
  }

  sealed trait Person {
    def name: String
  }

  object Person {
    final case class KindA(name: String, age: Int)          extends Person
    final case class KindB(name: String, whatever: Boolean) extends Person
  }
}
