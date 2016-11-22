import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import graph.GraphRenderer
import graph.factories.GridGraphFactory

class Main {

  private val shape = ShapeRenderer()
  private val boundary = calculateScreenBoundary()
  private val graphRenderer = GraphRenderer(shape)
  private val g = GridGraphFactory.generateGrid(3, 5, boundary, randomization = .33f)
  private val c = OrthographicCamera()
  private val processor = object : InputAdapter() {

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
      //println("touchDown")
      return true
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
      //println("touchUp")
      return true
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
      //println("touchDragged")
      return true
    }

  }

  init {
    Gdx.input.inputProcessor = processor
    c.setToOrtho(true, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
    shape.projectionMatrix.set(c.combined)
  }

  fun onFrame() {
    graphRenderer.render(g)
    val mouse = Vec2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat())
    val c = g.nearestNode(mouse)
    val e = g.nearestEdge(mouse)
    if (e != null) {
      val point = FastMath.nearestPointToLine(Vec2(e.from.x, e.from.y), Vec2(e.to.x, e.to.y), mouse)
      shape.begin(ShapeRenderer.ShapeType.Line)
      shape.line(mouse.x, mouse.y, point.x, point.y)
      shape.circle(point.x, point.y, 8f)
      shape.end()
    }
    if (c != null) {
      shape.begin(ShapeRenderer.ShapeType.Line)
      shape.circle(c.x, c.y, 16f)
      shape.line(c.x, c.y, mouse.x, mouse.y)
      shape.end()
    }
  }

  private fun calculateScreenBoundary(): Rectangle {
    val boundary = 64f
    return Rectangle(boundary, boundary, Gdx.graphics.width - boundary * 2, Gdx.graphics.height - boundary * 2)
  }

}
