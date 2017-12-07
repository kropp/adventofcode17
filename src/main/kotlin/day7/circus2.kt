package day7.part2

import resource

/*
http://adventofcode.com/2017/day/7

--- Part Two ---

The programs explain the situation: they can't get down. Rather, they could get down, if they weren't expending all of their energy trying to keep the tower balanced. Apparently, one program has the wrong weight, and until it's fixed, they're stuck here.

For any program holding a disc, each program standing on that disc forms a sub-tower. Each of those sub-towers are supposed to be the same weight, or the disc itself isn't balanced. The weight of a tower is the sum of the weights of the programs in that tower.

In the example above, this means that for ugml's disc to be balanced, gyxo, ebii, and jptl must all have the same weight, and they do: 61.

However, for tknk to be balanced, each of the programs standing on its disc and all programs above it must each match. This means that the following sums must all be the same:

    ugml + (gyxo + ebii + jptl) = 68 + (61 + 61 + 61) = 251
    padx + (pbga + havc + qoyq) = 45 + (66 + 66 + 66) = 243
    fwft + (ktlj + cntj + xhth) = 72 + (57 + 57 + 57) = 243

As you can see, tknk's disc is unbalanced: ugml's stack is heavier than the other two. Even though the nodes above ugml are balanced, ugml itself is too heavy: it needs to be 8 units lighter for its stack to weigh 243 and keep the towers balanced. If this change were made, its weight would be 60.

Given that exactly one program is the wrong weight, what would its weight need to be to balance the entire tower?
 */

val lineRegex = Regex("(\\w+) \\((\\d+)\\)( -> (.*))?")

fun main(args: Array<String>) {
  val allDisks = mutableMapOf<String, Disk>()
  allDisks.putAll(resource("day7.txt").reader().readLines().map {
    val m = lineRegex.matchEntire(it)!!
    val disks = if (m.groupValues[4].isNotEmpty()) m.groupValues[4].split(", ") else emptyList()
    Disk(m.groupValues[1], m.groupValues[2].toInt(), disks, allDisks)
  }.associateBy { it.name })

  val disk = allDisks.values.filter { !it.isBalanced && it.disks.all { it.isBalanced } }.first()
  println(disk.unbalancedChild.weight + disk.unbalancedTargetWeight - disk.unbalancedChild.cumulativeWeight)
}


data class Disk(val name: String, val weight: Int, private val diskNames: List<String>, private val allDisks: Map<String, Disk>) {
  val cumulativeWeight: Int by lazy {
    weight + disks.sumBy { it.cumulativeWeight }
  }
  val disks
    get() = diskNames.map { allDisks[it]!! }
  val isBalanced
    get() = disks.isEmpty() || disks.groupBy { it.cumulativeWeight }.size == 1
  val unbalancedChild
    get() = disks.groupBy { it.cumulativeWeight }.filter { it.value.size == 1 }.map { it.value }.first().first()
  val unbalancedTargetWeight
    get() = disks.groupBy { it.cumulativeWeight }.filter { it.value.size > 1 }.map { it.value }.first().first().cumulativeWeight
}