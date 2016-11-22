package graph

import org.testng.annotations.Test

class EdgeTest {

  @Test(expectedExceptions = arrayOf(IllegalArgumentException::class), expectedExceptionsMessageRegExp = ".*connected with itself")
  fun expectExceptionOnSelfConnection() {
    val sameNode = Node(0f, 0f)
    Edge(from = sameNode, to = sameNode)
  }

}
