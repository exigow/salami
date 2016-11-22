package graph.factories

import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import graph.Node


internal object FactoryUtilities {

  fun dummyBoundary() = Rectangle(0f, 0f, 1f, 1f)

  fun ensure(precondition: () -> Boolean, exceptionMsg: String = "Undescribed precondition failed") {
    if (!precondition.invoke())
      throw IllegalArgumentException(exceptionMsg)
  }

  fun randomNode(boundary: Rectangle): Node {
    val x = MathUtils.random(boundary.x, boundary.x + boundary.width)
    val y = MathUtils.random(boundary.y, boundary.y + boundary.height)
    return Node(x.toFloat(), y.toFloat())
  }

}
