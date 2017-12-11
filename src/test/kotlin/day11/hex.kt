package day11

import org.junit.Test
import kotlin.test.assertEquals

class Tests {
  @Test fun test1() = assertEquals(3, steps("ne,ne,ne").first)
  @Test fun test2() = assertEquals(0, steps("ne,ne,sw,sw").first)
  @Test fun test3() = assertEquals(2, steps("ne,ne,s,s").first)
  @Test fun test4() = assertEquals(3, steps("se,sw,se,sw,sw").first)
}