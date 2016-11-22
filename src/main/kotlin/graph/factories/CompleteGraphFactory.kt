package graph.factories

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import graph.Edge
import graph.Graph
import graph.Node
import graph.factories.FactoryUtilities.ensure
import java.util.*


object CompleteGraphFactory {

  fun generateComplete(amount: Int, boundary: Rectangle = FactoryUtilities.dummyBoundary()): Graph {
    ensure({amount > 0}, "Number of nodes must be greater than zero")
    val nodes = (1..amount).map { randomNode(boundary) }
    val edges = connectComplete(nodes)
    return Graph(nodes, edges)
  }

  private fun connectComplete(nodes: List<Node>): List<Edge> {
    val result = ArrayList<Edge>()
    for (from in nodes) {
      for (to in nodes) {
        fun isAlreadyConnected() = result.filter { it.has(from) && it.has(to) }.any()
        if (from == to || isAlreadyConnected())
          continue
        result += Edge(from, to)
      }
    }
    return result
  }

  private fun randomNode(boundary: Rectangle): Node {
    val x = MathUtils.random(boundary.x, boundary.x + boundary.width)
    val y = MathUtils.random(boundary.y, boundary.y + boundary.height)
    return Node(x.toFloat(), y.toFloat())
  }

}
