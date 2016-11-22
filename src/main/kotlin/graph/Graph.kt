package graph


import Vec2

data class Graph(val nodes: Collection<Node>, val edges: Collection<Edge>) {

  companion object {

    fun empty() = Graph(emptyList(), emptyList())

  }

  fun nearestNode(position: Vec2): Node? {
    if (nodes.isEmpty())
      return null
    val iterator = nodes.iterator()
    val first = iterator.next()
    var result = first
    fun calcDist(toX: Float, toY: Float) = position.distanceTo(Vec2(toX, toY))
    var distance = calcDist(result.x, result.y)
    while (iterator.hasNext()) {
      val next = iterator.next()
      val newDistance = calcDist(next.x, next.y)
      if (newDistance < distance) {
        distance = newDistance
        result = next
      }
    }
    return result
  }

  fun nearestEdge(position: Vec2): Edge? {
    if (edges.isEmpty())
      return null
    val iterator = edges.iterator()
    val first = iterator.next()
    var result = first
    fun Edge.distTo(p: Vec2) = (position - FastMath.nearestPointToLine(Vec2(from.x, from.y), Vec2(to.x, to.y), p)).length()
    var distance = result.distTo(position)
    while (iterator.hasNext()) {
      val next = iterator.next()
      val newDistance = next.distTo(position)
      if (newDistance < distance) {
        distance = newDistance
        result = next
      }
    }
    return result
  }

  fun isEmpty() = nodes.isEmpty()

  fun has(node: Node) = nodes.contains(node)

  fun has(edge: Edge) = edges.contains(edge)

}