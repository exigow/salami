package graph

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class GraphRenderer(private val shape: ShapeRenderer) {

  fun render(graph: Graph) {
    graph.nodes.forEach { drawNode(it) }
    graph.edges.forEach { drawEdge(it) }
  }

  private fun drawEdge(edge: Edge) {
    shape.begin(ShapeRenderer.ShapeType.Line)
    shape.line(edge.from.x, edge.from.y, edge.to.x, edge.to.y)
    shape.end()
  }

  private fun drawNode(node: Node) {
    shape.begin(ShapeRenderer.ShapeType.Filled)
    shape.circle(node.x, node.y, 4f)
    shape.end()
  }

}