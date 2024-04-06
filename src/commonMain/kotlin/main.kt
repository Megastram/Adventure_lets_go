import gameElements.*
import korlibs.image.color.*
import korlibs.image.text.*
import korlibs.io.async.*
import korlibs.korge.*
import korlibs.korge.input.*
import korlibs.korge.time.*
import korlibs.korge.view.*
import korlibs.logger.*
import korlibs.math.geom.*
import korlibs.render.GameWindow
import korlibs.time.*
import kotlin.time.Duration.Companion.seconds

lateinit var globalGameWindow : GameWindow

suspend fun main() = Korge(windowSize = Size(512, 512), backgroundColor = Colors.DARKGREY) {

    val container = this
    solidRect(container.width, container.height, color=Colors["#2b2b2b"])
    globalGameWindow = this.gameWindow

    val winText = text(
        "WIN",
        textSize=Text.DEFAULT_TEXT_SIZE*10,
        color= Colors.GREEN,
        alignment = TextAlignment.MIDDLE_CENTER
    ) {
        visible=false
        position(container.width/2, container.height/2)
    }

    // unser ufo
    val ufo = createUfo()

    launchImmediately {
        for ( countdown in 5 downTo 1 ) {
            val text = text(
                    "$countdown",
                    Text.DEFAULT_TEXT_SIZE*10,
                    color= Colors.GREEN,
                    alignment = TextAlignment.MIDDLE_CENTER
                ) {
                    position(container.width/2, container.height/2)
                }
            delay(1.seconds)
            text.removeFromParent()
        }
        // regelmäßig während das spiel läuft...
        addFixedUpdater( 1.timesPerSecond ) {

            // erzeuge einen asteroiden
            createAsteroid( ufo )

            if ( numasteroits > 0 ){
                launchImmediately {
                    winText.visible=true
                    delay(10.seconds)
                    gameWindow.exit()
                }
            }

        }
    }


    // Maus - Eingabe
    mouse {
        handleMouseInput(this, ufo, container)
    }

    //lange maus klick =riesen schuss (durch 3 kometen)


}



