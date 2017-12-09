package day9

import org.junit.Test
import kotlin.test.assertEquals

class Tests {
  @Test fun test1() = assertEquals(1, score("{}"))
  @Test fun test2() = assertEquals(6, score("{{{}}}"))
  @Test fun test3() = assertEquals(5, score("{{},{}}"))
  @Test fun test4() = assertEquals(16, score("{{{},{},{{}}}}"))
  @Test fun test5() = assertEquals(1, score("{<a>,<a>,<a>,<a>}"))
  @Test fun test6() = assertEquals(9, score("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
  @Test fun test7() = assertEquals(9, score("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
  @Test fun test8() = assertEquals(3, score("{{<a!>},{<a!>},{<a!>},{<ab>}}"))

  @Test fun garbage1() = assertEquals(0, garbage("<>"))
  @Test fun garbage2() = assertEquals(17, garbage("<random characters>"))
  @Test fun garbage3() = assertEquals(3, garbage("<<<<>"))
  @Test fun garbage4() = assertEquals(2, garbage("<{!>}>"))
  @Test fun garbage5() = assertEquals(0, garbage("<!!>"))
  @Test fun garbage6() = assertEquals(0, garbage("<!!!>>"))
  @Test fun garbage7() = assertEquals(10, garbage("<{o\"i!a,<{i<a>"))
}