import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Rectangle
import graph.GraphRenderer
import graph.factories.GridGraphFactory

class Main {

  private val boundary = calculateScreenBoundary()
  private val graphRenderer = GraphRenderer()
  private val g = GridGraphFactory.generateGrid(3, 4, boundary, randomization = .33f)

  fun onFrame() {
    graphRenderer.render(g)
  }

  private fun calculateScreenBoundary(): Rectangle {
    val boundary = 64f
    return Rectangle(boundary, boundary, Gdx.graphics.width - boundary * 2, Gdx.graphics.height - boundary * 2)
  }

}
