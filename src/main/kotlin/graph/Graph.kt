package graph


data class Graph(val nodes: Collection<Node>, val edges: Collection<Edge>) {

  companion object {

    fun empty() = Graph(emptyList(), emptyList())

  }

  fun closestTo(x: Float, y: Float): Node? = TODO()

  fun isEmpty() = nodes.isEmpty()

  fun has(node: Node) = nodes.contains(node)

  fun has(edge: Edge) = edges.contains(edge)

}