package day4

import resource

/*
http://adventofcode.com/2017/day/4

--- Part Two ---

For added security, yet another system policy has been put in place. Now, a valid passphrase must contain no two words that are anagrams of each other - that is, a passphrase is invalid if any word's letters can be rearranged to form any other word in the passphrase.

For example:

    abcde fghij is a valid passphrase.
    abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
    a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
    iiii oiii ooii oooi oooo is valid.
    oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.

Under this new system policy, how many passphrases are valid?

 */

fun main(args: Array<String>) {
  val passphrases = resource("day4.txt").bufferedReader().lines()
  println(passphrases.filter {
    val words = it.split(" ")
    words.all { word ->
      words.count { isAnagram(word, it) } == 1
    }
  }.count())
}

fun isAnagram(a: String, b: String): Boolean {
  val abc1 = ('a'..'z').map { it to 0 }.toMap().toMutableMap()
  val abc2 = ('a'..'z').map { it to 0 }.toMap().toMutableMap()
  a.forEach { abc1[it] = abc1[it]!! + 1 }
  b.forEach { abc2[it] = abc2[it]!! + 1 }
  return abc1.all { abc2[it.key] == it.value }
}
