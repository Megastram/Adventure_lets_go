import gameElements.createAsteroid
import gameElements.createUfo
import korlibs.image.color.*
import korlibs.korge.*
import korlibs.korge.input.*
import korlibs.korge.view.*
import korlibs.math.geom.*
import korlibs.render.GameWindow
import korlibs.time.*

lateinit var globalGameWindow : GameWindow

suspend fun main() = Korge(windowSize = Size(512, 512), backgroundColor = Colors.DARKGREY) {

    val container = this
    solidRect(container.width, container.height, color=Colors["#2b2b2b"])
    globalGameWindow = this.gameWindow


    // unser ufo
    val ufo = createUfo()

    // regelmäßig während das spiel läuft...
    addFixedUpdater( 1.timesPerSecond ) {
        // erzeuge einen asteroiden
        createAsteroid( ufo )
    }


    // Maus - Eingabe
    mouse {
        handleMouseInput(this, ufo, container)
    }

}

