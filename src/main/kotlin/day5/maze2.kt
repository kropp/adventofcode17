package day5

import resource

/*
http://adventofcode.com/2017/day/5

--- Part Two ---

Now, the jumps are even stranger: after each jump, if the offset was three or more, instead decrease it by 1. Otherwise, increase it by 1 as before.

Using this rule with the above example, the process now takes 10 steps, and the offset values after finding the exit are left as 2 3 2 3 -1.

How many steps does it now take to reach the exit?
 */

fun main(args: Array<String>) {
  val offsets = resource("day5.txt").bufferedReader().lines().mapToInt { Integer.parseInt(it) }.toArray()
//  val offsets = intArrayOf(0, 3, 0, 1, -3)
  var position = 0
  var steps = 0
  while (true) {
    steps++
    val newPosition = position + offsets[position]
    if (offsets[position] > 2) {
      offsets[position]--
    } else {
      offsets[position]++
    }
    position = newPosition
    if (position < 0 || position >= offsets.size) {
      println(steps)
      break
    }
  }
}