package graph


data class Edge(val from: Node, val to: Node) {

  init {
    validate()
  }

  fun has(node: Node) = from == node || to == node

  private fun validate() {
    if (from == to)
      throw IllegalArgumentException("Node can not be connected with itself")
  }

}
