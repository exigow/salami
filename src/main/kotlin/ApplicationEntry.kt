import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.GL20

object ApplicationEntry {

  @JvmStatic fun main(args: Array<String>) {
    val config = createConfig()
    Lwjgl3Application(LazyInitialisationAdapter(), config)
  }

  private fun createConfig(): Lwjgl3ApplicationConfiguration {
    val config = Lwjgl3ApplicationConfiguration()
    config.setWindowedMode(640, 960)
    config.useOpenGL3(true, 3, 2)
    return config
  }

  private class LazyInitialisationAdapter : ApplicationAdapter() {

    private var main: Main? = null

    override fun create() {
      main = Main()
    }

    override fun render() {
      clearBackground()
      main!!.onFrame()
    }

    private fun clearBackground() {
      val intensity = .0f
      Gdx.gl.glClearColor(intensity, intensity, intensity, 1f)
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

  }

}