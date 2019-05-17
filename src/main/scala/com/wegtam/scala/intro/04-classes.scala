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
  * Classes provide more features than objects:
  *
  * - a class has an constructor
  * - a class can take type parameters
  * - a class can have a companion object
  */
object classes {

  class MyClass(users: Map[Int, String]) {

    /**
      * TODO Implement this function.
      *
      * @param id The ID of a user.
      * @return An option to the user if it exists.
      */
    def getById(id: Int): Option[String] = ???
  }

  class AnotherClass[A, B](someA: A) {
    def doStuff(b: B): A = ???
  }

  /**
    * A class can use the private and protected methods from its companion object.
    */
  class WithCompanion[A](myA: A) {
    def convert: String = WithCompanion.onlyForMe(myA)
  }

  object WithCompanion {
    private def onlyForMe[A](a: A): String = ???
  }
}
