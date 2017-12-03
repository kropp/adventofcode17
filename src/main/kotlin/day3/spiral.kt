package day3

import kotlin.math.*

fun main(args: Array<String>) {
  println(distance(277678))
}

fun distance(x: Int): Int {
  if (x == 1) return 0
  val size = ceil(sqrt(x.toDouble())).roundToInt()
  val square = size * size

  if (x > square - size) { // horizontal
    return abs(floor(square - 0.5*size).roundToInt() + 1 - x) + floor(1.0*size/2).roundToInt()
  } else { // vertical
    return abs(ceil(square - 1.5*size).roundToInt() + 1 - x) + ceil(1.0*size/2).roundToInt()
  }
}
