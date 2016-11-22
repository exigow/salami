package graph.factories

import graph.factories.GridGraphFactory.generateGrid
import org.testng.Assert.assertEquals
import org.testng.annotations.Test

class GridGraphFactoryTest {

  @Test(expectedExceptions = arrayOf(IllegalArgumentException::class), expectedExceptionsMessageRegExp = "Columns.*greater than one.*")
  fun expectExceptionOnInvalidColumnsCount() {
    generateGrid(1, 3)
  }

  @Test(expectedExceptions = arrayOf(IllegalArgumentException::class), expectedExceptionsMessageRegExp = "Rows.*greater than one.*")
  fun expectExceptionOnInvalidRowsCount() {
    generateGrid(4, 0)
  }

  @Test
  fun check2x2Result() {
    val g = generateGrid(2, 2)
    assertEquals(g.nodes.size, 4)
    assertEquals(g.edges.size, 4)
  }

  @Test
  fun check2x3Result() {
    val g = generateGrid(2, 3)
    assertEquals(g.nodes.size, 6)
    assertEquals(g.edges.size, 7)
  }

  @Test
  fun check3x2Result() {
    val g = generateGrid(3, 2)
    assertEquals(g.nodes.size, 6)
    assertEquals(g.edges.size, 7)
  }

  @Test
  fun check3x3Result() {
    val g = generateGrid(3, 3)
    assertEquals(g.nodes.size, 9)
    assertEquals(g.edges.size, 12)
  }

}