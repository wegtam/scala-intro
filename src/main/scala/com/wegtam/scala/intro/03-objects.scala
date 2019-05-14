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
  * Objects are singletons and the most simple container format in Scala.
  *
  * If unsure where to put your functions start out with an object and
  * refactor later on if it does not suffice.
  */
object objects {

  object MyConstants {
    val Pi = 3.14
  }

  object MyHelpers {

    /**
      * TODO Implement this function.
      * TODO What is wrong with this function?
      *
      * @param ns A list of integers.
      * @return The smallest integer from the list.
      */
    def min(ns: Seq[Int]): Int = ???

  }

}
