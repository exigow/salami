package graph.factories

import com.badlogic.gdx.math.Rectangle
import graph.Edge
import graph.Graph
import graph.Node
import graph.factories.FactoryUtilities.ensure
import graph.factories.FactoryUtilities.randomNode
import java.util.*


object GridGraphFactory {

  fun generateGrid(columns: Int, rows: Int, boundary: Rectangle = FactoryUtilities.dummyBoundary(), randomization: Float = 0f): Graph {
    ensure({columns > 1}, "Columns count must be greater than one")
    ensure({rows > 1}, "Rows count must be greater than one")
    ensure({randomization >= 0f && randomization <= 1f})
    val nodes = populateGrid(columns, rows, boundary, randomization)
    val edges = connectGrid(nodes, rows)
    return Graph(nodes, edges)
  }

  private fun populateGrid(columns: Int, rows: Int, boundary: Rectangle, randomization: Float): List<Node> {
    val tx = boundary.width / (columns - 1)
    val ty = boundary.height / (rows - 1)
    val result = ArrayList<Node>()
    for (ix in (0..columns - 1)) {
      for (iy in (0..rows - 1)) {
        val x = boundary.x + ix * tx
        val y = boundary.y + iy * ty
        result += asd(x, y, tx, ty, randomization)
      }
    }
    return result
  }

  private fun asd(x: Float, y: Float, tx: Float, ty: Float, randomization: Float): Node {
    val w = tx / 2 * randomization
    val h = ty / 2 * randomization
    return randomNode(Rectangle(x - w, y - h, w * 2, h * 2))
  }

  private fun connectGrid(nodes: List<Node>, rows: Int): List<Edge> {
    val result = ArrayList<Edge>()
    var prev: Node = nodes.first()
    var counter = 0
    for (node in nodes - nodes.first()) {
      counter++
      if (counter % rows != 0)
        result += Edge(prev, node)
      prev = node
      if (counter > rows - 1) {
        val from = counter
        val to = counter - rows
        result += Edge(nodes[from], nodes[to])
      }
    }
    return result
  }

}
