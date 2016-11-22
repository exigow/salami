package graph.factories

import graph.factories.CompleteGraphFactory.generateComplete
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class CompleteGraphFactoryTest {

  @Test fun checkEdgesSizeResults() {
    assertEquals(generateComplete(1).edges.size, 0)
    assertEquals(generateComplete(2).edges.size, 1)
    assertEquals(generateComplete(3).edges.size, 3)
    assertEquals(generateComplete(4).edges.size, 6)
    assertEquals(generateComplete(5).edges.size, 10)
    assertEquals(generateComplete(6).edges.size, 15)
  }

  @Test fun checkNodesSizeResults() {
    assertEquals(generateComplete(1).nodes.size, 1)
    assertEquals(generateComplete(7).nodes.size, 7)
    assertEquals(generateComplete(11).nodes.size, 11)
  }

  @Test(expectedExceptions = arrayOf(IllegalArgumentException::class), expectedExceptionsMessageRegExp = ".*greater than zero.*")
  fun expectExceptionOnGenerateCompleteInvalidAmount() {
    generateComplete(0)
  }

}